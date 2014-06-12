package cl.acaya.web.controllers;

import cl.acaya.api.service.ClienteServiceRemote;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.*;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mcastro on 22-05-14.
 */

@Controller
@RequestMapping("/cliente/gestion")
public class ClienteRestController {

    private static final Logger LOGGER = Logger.getLogger(ClienteRestController.class);

    private CobranzaServiceRemote cobranzaServiceRemote;
    private ClienteServiceRemote clienteServiceRemote;

    @Autowired
    public ClienteRestController(CobranzaServiceRemote cobranzaServiceRemote, ClienteServiceRemote clienteServiceRemote) {
        this.cobranzaServiceRemote = cobranzaServiceRemote;
        this.clienteServiceRemote = clienteServiceRemote;
    }

    @RequestMapping(value = "{idCliente}", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse cargarCliente(HttpServletRequest httpRequest,
                                   @PathVariable Long idCliente

                                   ) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(Parametros.ID_CLIENTE, idCliente);
        Response response = clienteServiceRemote.getDatosGestionCliente(request);
        List<DocumentoClienteVO> documentoClienteVOList = response.getResp(Parametros.DOCUMENTOS_CLIENTE, List.class);
        ClienteVO clienteVO = response.getResp(Parametros.CLIENTE, ClienteVO.class);
        List<TramoVO> tramoVOList = response.getResp(Parametros.TRAMOS, List.class);
        CarteraVO carteraVO = response.getResp(Parametros.CARTERA_CLIENTE, CarteraVO.class);
        Map map = new HashMap();
        map.put(Parametros.CLIENTE, clienteVO);
        map.put(Parametros.DOCUMENTOS_CLIENTE, documentoClienteVOList);
        map.put(Parametros.TRAMOS, tramoVOList);
        map.put(Parametros.CARTERA_CLIENTE, carteraVO);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccessToTrue();
        jsonResponse.setBody(map);
        return jsonResponse;
    }




}
