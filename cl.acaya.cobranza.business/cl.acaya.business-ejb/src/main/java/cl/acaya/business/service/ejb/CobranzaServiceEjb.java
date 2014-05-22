package cl.acaya.business.service.ejb;

import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;

/**
 * Created by mcastro on 21-05-14.
 */
public interface CobranzaServiceEjb {

    Response obtenerDocumentosSAP(Request request);
}
