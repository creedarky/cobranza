package cl.acaya.web.controllers;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.Parametros;
import cl.acaya.api.vo.Request;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mcastro on 22-05-14.
 */

@Controller
public class DocumentoController {

    private static final Logger LOGGER = Logger.getLogger(DocumentoController.class);

    private CobranzaServiceRemote cobranzaServiceRemote;

    @Autowired
    public DocumentoController(CobranzaServiceRemote cobranzaServiceRemote) {
        this.cobranzaServiceRemote = cobranzaServiceRemote;
    }

    @RequestMapping(value = "/prueba")
    public String cargarDocumentos(HttpServletRequest httpRequest) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(BusinessParameter.RUT_CLIENTE,"61704000K");
        request.addParam(BusinessParameter.SOCIEDAD, "1000");
        cobranzaServiceRemote.obtenerDocumentosSAP(request);
        return "";

    }

}
