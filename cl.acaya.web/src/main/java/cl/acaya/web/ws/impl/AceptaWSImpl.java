package cl.acaya.web.ws.impl;

/**
 * Created by Maximiliano on 13/06/2014.
 */

import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.web.ws.AceptaWS;
import cl.acaya.web.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.web.ws.response.NotificarFacturaAceptaResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(serviceName = "AceptaWS")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public class AceptaWSImpl {



    @WebMethod(operationName = "notificarFactura")
    public NotificarFacturaAceptaResponse notificarFactura(NotificarFacturaAceptaRequest request) {
        NotificarFacturaAceptaResponse response = new NotificarFacturaAceptaResponse();

        try {

            if (true) {
                response.setSuccess(true);
            } else {
                response.setSuccess(false);
                response.setErrorMensaje("No se pudieron desactivar los productos de la cuenta");
            }
        } catch (NumberFormatException e) {
            response.setSuccess(false);
            response.setErrorMensaje("Error, idCuenta no valido");
        }


        return response;
    }
}
