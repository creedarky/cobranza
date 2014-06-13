package cl.acaya.business.service.ws;

import cl.acaya.business.service.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.business.service.ws.response.NotificarFacturaAceptaResponse;

import javax.jws.WebMethod;
import javax.jws.WebResult;

/**
 * Created by Maximiliano on 13/06/2014.
 */
public interface AceptaWS {
    NotificarFacturaAceptaResponse notificarFactura(NotificarFacturaAceptaRequest request);
}
