package cl.acaya.business.webservice.ws.impl;

/**
 * Created by Maximiliano on 13/06/2014.
 */

import cl.acaya.business.webservice.ws.AceptaWS;
import cl.acaya.business.webservice.ws.request.NotificarFacturaAceptaRequest;
import cl.acaya.business.webservice.ws.response.NotificarFacturaAceptaResponse;
import cl.acaya.cobranza.business.daoEjb.dao.IntegracionAceptaDAO;
import cl.acaya.cobranza.business.daoEjb.entities.IntegracionAcepta;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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

    @EJB
    IntegracionAceptaDAO integracionAceptaDAO;

    @Override
    @WebMethod
    @WebResult(name = "notificarFactura")
    public NotificarFacturaAceptaResponse notificarFactura(NotificarFacturaAceptaRequest request) {
        NotificarFacturaAceptaResponse response = new NotificarFacturaAceptaResponse();

        try {
            boolean resultado = integracionAceptaDAO.crearIntegracionAcepta(request.getNumFactura(), request.getDuennoEvento(),
                    request.getEstadoEvento(),request.getFechaHoraEvento(), request.getObservacion(), request.getUrlFactura());

            if (resultado) {
                response.setSuccess(true);
            } else {
                response.setSuccess(false);
                response.setErrorMensaje("No se pudo notificar factura");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMensaje("Ha ocurrido un error al recibir los datos");
        }


        return response;
    }
}
