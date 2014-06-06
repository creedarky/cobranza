package cl.acaya.web.controllers;

import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.*;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
                                   Model model
                                   ) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(Parametros.ID_CLIENTE, idCliente);
        Response response = cobranzaServiceRemote.getDatosGestionCliente(request);
        List<DocumentoClienteVO> documentoClienteVOList = response.getResp(Parametros.DOCUMENTOS_CLIENTE, List.class);
        ClienteVO clienteVO = response.getResp(Parametros.CLIENTE, ClienteVO.class);
        List<TramoVO> tramoVOList = response.getResp(Parametros.TRAMOS, List.class);
        CarteraVO carteraVO = response.getResp(Parametros.CARTERA_CLIENTE, CarteraVO.class);
        model.addAttribute(Parametros.CLIENTE, clienteVO);
        model.addAttribute(Parametros.DOCUMENTOS_CLIENTE, documentoClienteVOList);
        model.addAttribute(Parametros.TRAMOS,tramoVOList);
        model.addAttribute(Parametros.CARTERA_CLIENTE, carteraVO);
        return "gestion_cliente";
    }


}
