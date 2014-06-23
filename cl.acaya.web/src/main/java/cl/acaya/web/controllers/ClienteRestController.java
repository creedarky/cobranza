package cl.acaya.web.controllers;

import cl.acaya.api.service.ClienteServiceRemote;
import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.vo.*;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        List<ContingenciaVO> contingenciaVOList = response.getResp(Parametros.CONTINGENCIAS, List.class);
        Map map = new HashMap();
        map.put(Parametros.CLIENTE, clienteVO);
        map.put(Parametros.DOCUMENTOS_CLIENTE, documentoClienteVOList);
        map.put(Parametros.TRAMOS, tramoVOList);
        map.put(Parametros.CARTERA_CLIENTE, carteraVO);
        map.put(Parametros.CONTINGENCIAS, contingenciaVOList);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccessToTrue();
        jsonResponse.setBody(map);
        return jsonResponse;
    }

    @RequestMapping(value = "contactos/{idCliente}", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse cargarContactos(HttpServletRequest httpRequest,
                               @PathVariable Long idCliente) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(Parametros.ID_CLIENTE,idCliente);
        JsonResponse jsonResponse = new JsonResponse();
        Response response = clienteServiceRemote.getContactosClientes(request);
        System.out.println("cargando clientes");
        if(response.isOK()) {
            jsonResponse.setBody(response.getAllResp());
        }
        return jsonResponse;

    }

    @RequestMapping(value="guardar-agenda", method = RequestMethod.POST)
    public @ResponseBody JsonResponse guardarAgenda(@RequestBody final GuardarAgendaVO guardarAgendaVO) {
        System.out.println(guardarAgendaVO.toString());
        clienteServiceRemote.guardarAgenda(guardarAgendaVO);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccessToTrue();
        return  new JsonResponse();



    }

    @RequestMapping(value="guardar-contacto", method = RequestMethod.POST)
    public @ResponseBody JsonResponse guardarContacto(@RequestBody final ContactoVO contactoVO) {
        System.out.println(contactoVO.toString());
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccessToTrue();
        jsonResponse.setBody(clienteServiceRemote.guardarContacto(contactoVO));
        return  jsonResponse;
    }

    @RequestMapping(value =  "bancos", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse getBancos() {
        Response response = clienteServiceRemote.getBancosYFormasdePago();
        Map<String, List> map = new HashMap<String, List>();
        JsonResponse jsonResponse = new JsonResponse();
        map.put(Parametros.BANCOS, response.getResp(Parametros.BANCOS,List.class));
        map.put(Parametros.FORMAS_PAGO, response.getResp(Parametros.FORMAS_PAGO,List.class));
        jsonResponse.setBody(map);
        return jsonResponse;
    }

    @RequestMapping(value="guardar-gestion", method = RequestMethod.POST)
    public @ResponseBody JsonResponse guardarGestion(@RequestBody final GestionVO gestionVO) {
        System.out.println(gestionVO.toString());
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccessToTrue();
        jsonResponse.setBody(clienteServiceRemote.guardarGestion(gestionVO));
        return  jsonResponse;
    }


    @RequestMapping(value = "hitos/{idCliente}", method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse cargarHitos(HttpServletRequest httpRequest,
                                 @PathVariable Long idCliente) {
        Request request = RequestFactory.newRequest(httpRequest);
        request.addParam(Parametros.ID_CLIENTE,idCliente);
        JsonResponse jsonResponse = new JsonResponse();
        Response response = clienteServiceRemote.getHitosCliente(request);
        System.out.println("cargando clientes");
        if(response.isOK()) {
            jsonResponse.setBody(response.getAllResp());
        }
        return jsonResponse;

    }

}
