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

    @Override
    public Response getDatosPantallaInicial(Request request) {
        return cobranzaServiceRemote.getDatosPantallaInicial(request);
    }

    @Override
    public Response getDatosAsignacion(Request request) {
        return cobranzaServiceRemote.getDatosAsignacion(request);
    }

    @Override
    public Response guardarDatosAsignacion(Request request) {
        return cobranzaServiceRemote.guardarDatosAsignacion(request);
    }

    @Override
    public Response getDatosGestionCliente(Request request) {
        return cobranzaServiceRemote.getDatosGestionCliente(request);
    }

    @Override
    public Response ejecutarCargaMasiva() {
        return cobranzaServiceRemote.ejecutarCargaMasiva();
    }
}
