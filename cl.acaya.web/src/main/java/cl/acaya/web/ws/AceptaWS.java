package cl.acaya.web.ws;

import cl.acaya.web.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.web.ws.response.NotificarFacturaAceptaResponse;

/**
 * Created by Maximiliano on 13/06/2014.
 */
public interface AceptaWS {
    NotificarFacturaAceptaResponse notificarFactura(NotificarFacturaAceptaRequest request);
}
