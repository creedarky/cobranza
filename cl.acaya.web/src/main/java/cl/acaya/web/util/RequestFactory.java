package cl.acaya.web.util;

import cl.acaya.api.vo.Context;
import cl.acaya.api.vo.Request;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Kiosolutions
 */
public final class RequestFactory {

    private RequestFactory() {
    }

    public static Request newRequest(final HttpServletRequest httpRequest) {
        Request request = new Request();
        {
            Context context = new Context();
            {
                context.setLocale(LocaleContextHolder.getLocale());
                context.setRemoteHost(httpRequest.getRemoteHost());
                context.setUsername((httpRequest.getUserPrincipal() != null ? httpRequest.getUserPrincipal().getName() : ""));
            }

            request.setContext(context);
        }


        //
        //
        //
        //
        //request.addParam(Parametros.PRM_USUARIO_SAU, sau);
        //request.addParam(Parametros.MQ_INVOKE_URL, SecurityUtil.getInvokeUrl(httpRequest));

        return request;
    }
}
