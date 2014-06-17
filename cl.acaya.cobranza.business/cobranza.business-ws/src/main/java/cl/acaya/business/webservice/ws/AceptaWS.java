package cl.acaya.business.webservice.ws;

import cl.acaya.business.webservice.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.business.webservice.ws.response.NotificarFacturaAceptaResponse;

/**
 * Created by Maximiliano on 13/06/2014.
 */
public interface AceptaWS {
    NotificarFacturaAceptaResponse notificarFactura(NotificarFacturaAceptaRequest request);
}
