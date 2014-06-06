package cl.acaya.web.controllers;

import cl.acaya.api.business.BusinessParameter;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.*;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mcastro on 22-05-14.
 */

@Controller
public class ClienteController {

    private static final Logger LOGGER = Logger.getLogger(ClienteController.class);

    private CobranzaServiceRemote cobranzaServiceRemote;

    @Autowired
    public ClienteController(CobranzaServiceRemote cobranzaServiceRemote) {
        this.cobranzaServiceRemote = cobranzaServiceRemote;
    }

    @RequestMapping(value = "/gestioncliente", method = RequestMethod.GET)
    public String cargarCliente(HttpServletRequest httpRequest,
                                   @ModelAttribute(Parametros.ID_CLIENTE) Long idCliente,
                                   @ModelAttribute(Parametros.ID_DMCLIENTE) Long idDMCLiente,
                                   Model model
                                   ) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(Parametros.ID_CLIENTE, idCliente);
        request.addParam(Parametros.ID_DMCLIENTE, idDMCLiente);
        Response response = cobranzaServiceRemote.getDocumentosByCliente(request);
        List<DocumentoVO> documentoVOList = response.getResp("doc", List.class);
        model.addAttribute(Parametros.CLIENTE, new ClienteVO());
        model.addAttribute("doc", documentoVOList);
        return "gestion_cliente";
    }


}
