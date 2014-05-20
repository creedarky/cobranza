package cl.acaya.web.controllers;

import cl.acaya.api.vo.JsonResponse;
import cl.acaya.api.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA. User: fbrule Date: 9/24/13 Time: 2:59 PM
 */
@Controller
public class SystemStatusController {

    private static final Logger LOGGER = Logger.getLogger(SystemStatusController.class);
    //private SystemStatusRemote systemStatusRemote;
    //private SystemParameterServiceDelegate systemParameterServiceRemote;

    public SystemStatusController() {
    }
    /*
    @Autowired
    public SystemStatusController(SystemStatusRemote systemStatusRemote, SystemParameterServiceDelegate systemParameterServiceRemote) {
        this.systemStatusRemote = systemStatusRemote;
        this.systemParameterServiceRemote = systemParameterServiceRemote;
    }
    */

    @RequestMapping(value = "/system-status")
    public String getClienteForm() {
        return "layouts/system-status";
    }
    /*

    @RequestMapping(value = "/get-system-status", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResponse systemStatus(
            HttpServletRequest httpRequest,
            @RequestParam("dummy") String dummy) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("enter");
        }

        JsonResponse jsonResp = new JsonResponse();

        PcdcRequest pcdcRequest = PcdcRequestFactory.newPcdcRequest(httpRequest);
        {
            SystemStatusVO systemStatusVO = new SystemStatusVO();
            systemStatusVO.addTextToTraza("Entro a: " + getClass().getSimpleName());
            systemStatusVO.addTextToTraza("Remote Host: " + httpRequest.getRemoteHost());

            Properties props = System.getProperties();
            for (Object key : props.keySet()) {
                String value = props.get(key) != null ? props.get(key).toString() : "";
                systemStatusVO.addFrontEndProp(new ParKeyValue<String, String>(key.toString(), value));
            }

            pcdcRequest.addParam(Parametros.SYSTEM_STATUS, systemStatusVO);
        }


        long start = System.nanoTime();
        PcdcResponse pcdcResponse = systemStatusRemote.getSystemStatus(pcdcRequest);
        long elapsed = (System.nanoTime() - start) / 10000000;

        SystemStatusVO systemStatusVO = pcdcResponse.getResp(Parametros.SYSTEM_STATUS, SystemStatusVO.class);
        systemStatusVO.setElapsed(elapsed);

        systemStatusVO.addTextToTraza("Retornando de: " + getClass().getSimpleName());

        jsonResp.setBody(systemStatusVO);
        jsonResp.setSuccessToTrue();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(systemStatusVO);
            LOGGER.debug("quit");
        }

        return jsonResp;
    }
    */
}
