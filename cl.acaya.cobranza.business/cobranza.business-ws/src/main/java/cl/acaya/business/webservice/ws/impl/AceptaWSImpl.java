package cl.acaya.business.webservice.ws.impl;

/**
 * Created by Maximiliano on 13/06/2014.
 */

import cl.acaya.business.webservice.ws.AceptaWS;
import cl.acaya.business.webservice.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.business.webservice.ws.response.NotificarFacturaAceptaResponse;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@Stateless(name = "AceptaWS", mappedName = "ejb/AceptaWS")
@WebService(name = "AceptaWS", serviceName = "AceptaWS", targetNamespace = "http://localhost/aceptaws",wsdlLocation = "META-INF/wsdl/acepta.wsdl")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@Remote(AceptaWS.class)
public class AceptaWSImpl implements AceptaWS {

    private static final Logger LOGGER = Logger.getLogger(AceptaWSImpl.class);

    @PostConstruct
    public void postConstruct() {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);
    }

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
                response.setErrorMensaje("No se pudo notificar factura");
            }
        } catch (NumberFormatException e) {
            response.setSuccess(false);
            response.setErrorMensaje("error al parsear datos");
        }


        return response;
    }
}
