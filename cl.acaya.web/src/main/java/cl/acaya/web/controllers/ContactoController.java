package cl.acaya.web.controllers;

import cl.acaya.api.service.CobranzaServiceRemote;
import cl.acaya.api.service.ContactoServiceRemote;
import cl.acaya.api.vo.JsonResponse;
import cl.acaya.api.vo.Parametros;
import cl.acaya.api.vo.Request;
import cl.acaya.api.vo.Response;
import cl.acaya.web.util.RequestFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by darkmoorx on 08-06-14.
 */
public class ContactoController {

    private static final Logger LOGGER = Logger.getLogger(ContactoController.class);

    private ContactoServiceRemote contactoServiceRemote;

    @Autowired
    public ContactoController(ContactoServiceRemote contactoServiceRemote) {
        this.contactoServiceRemote = contactoServiceRemote;
    }

    @RequestMapping(value = "/guardar-contacto", method = RequestMethod.POST)
    public @ResponseBody
    JsonResponse guardarDatosAsignaciones(HttpServletRequest httpServletRequest,
                                          @RequestParam(Parametros.NOMBRE_CONTACTO) Long nombre,
                                          @RequestParam(Parametros.TELEFONO_CONTACTO) Long[] telefono,
                                          @RequestParam(Parametros.EMAIL_CONTACTO) Long[] email) {
        Request request = RequestFactory.newRequest(httpServletRequest);

        Response response = contactoServiceRemote.guardarContacto(request);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setSuccess(response.isOK());
        return jsonResponse;
    }
}
