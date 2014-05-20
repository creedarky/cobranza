package cl.acaya.web.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author rquezada@kiosolutions.com
 */
public class SecurityFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SecurityFilter.class);
    private FilterConfig filterConfig = null;
    public static final String USER_ATTRIBUTE_NAME = "pcdcUser";
    public static final String PARAMETER_LOGIN_SAU = "pstrParametrosLogin";
    public static final String PARAMETER_LOGIN_VMICA = "prmParametrosLogin";

    public SecurityFilter() {
    }

    /**
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     * @throws java.io.IOException if an input/output error occurs
     * @throws javax.servlet.ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String loginParam = httpRequest.getParameter(PARAMETER_LOGIN_SAU);
        if (loginParam == null) {
            loginParam = httpRequest.getParameter(PARAMETER_LOGIN_VMICA);
        }
        HttpSession httpSession = httpRequest.getSession();
        boolean ok = false;
        if (httpSession != null) {
            ok = true;
        }
        if (ok) {
            try {
                chain.doFilter(request, response);
            } catch (Throwable t) {
                LOGGER.error(t.getMessage(), t);
                throw new ServletException(t.getMessage(), t);
            }
        } else {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "No tiene permiso para acceder a este recurso"); //TODO: Internacionalizar
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
