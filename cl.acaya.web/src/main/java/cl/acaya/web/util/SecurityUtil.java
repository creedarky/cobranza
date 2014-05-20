package cl.acaya.web.util;

import cl.acaya.web.filters.SecurityFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author rquezada
 */
public final class SecurityUtil {

    private SecurityUtil() {
    }

    public static HttpSession getSesionSAU(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);
        return sesion;
    }

    public static String getInvokeUrl(HttpServletRequest request) {
        return "pcdc.".concat(request.getServletPath().replace("/", ""));
    }

    public static void setSesionSau(HttpSession httpSession, Object user) {
        //httpSession.setAttribute(SecurityFilter.USER_ATTRIBUTE_NAME, user);
    }
}
