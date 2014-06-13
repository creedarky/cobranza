package cl.acaya.business.service.ws.impl;

/**
 * Created by Maximiliano on 13/06/2014.
 */

import cl.acaya.business.service.ws.AceptaWS;
import cl.acaya.business.service.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.business.service.ws.response.NotificarFacturaAceptaResponse;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Stateless(name = "AceptaWSEJB", mappedName = "ejb/AceptaWSEJB")
@WebService(name = "AceptaWS", serviceName = "AceptaWS", targetNamespace = "http://localhost/aceptaws")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)

@Remote(AceptaWS.class)
public class AceptaWSImpl implements AceptaWS {

    private static final Logger LOGGER = Logger.getLogger(AceptaWSImpl.class);

    @Override
    @WebMethod
    @WebResult(name = "notificarFactura")
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
