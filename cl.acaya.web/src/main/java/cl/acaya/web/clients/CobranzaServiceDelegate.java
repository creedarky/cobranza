package cl.acaya.web.clients;

import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

/**
 * Created by mcastro on 22-05-14.
 */
public class CobranzaServiceDelegate extends AbstractServiceDelegate implements CobranzaServiceRemote {

    CobranzaServiceRemote cobranzaServiceRemote;

    @Override
    public void setJndiName(String jndiName) {
        cobranzaServiceRemote = getService(jndiName, CobranzaServiceRemote.class);
    }

    @Override
    public Response obtenerDocumentosSAP(Request request) {
        return cobranzaServiceRemote.obtenerDocumentosSAP(request);
    }
}