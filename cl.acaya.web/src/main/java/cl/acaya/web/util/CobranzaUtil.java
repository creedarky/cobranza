package cl.acaya.web.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author rquezada@kiosolutions.com
 */
public final class CobranzaUtil {

    private CobranzaUtil() {
    }



    /*
    public static void setAutorizadorExcepcionadorAnulacion(HttpServletRequest httpRequest, String autorizador) {
        HttpSession httpSession = httpRequest.getSession(false);
        httpSession.setAttribute(Parametros.AUTORIZADOR, autorizador);
    }

    public static String getAutorizadorExcepcionadorAnulacion(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession(false);
        return (String) httpSession.getAttribute(Parametros.AUTORIZADOR);
    }

    public static void removeAutorizadorExcepcionadorAnulacion(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession(false);
        httpSession.removeAttribute(Parametros.AUTORIZADOR);
    }
    */
}
