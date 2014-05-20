package cl.acaya.web.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author rquezada@kiosolutions.com
 */
public class BrowserDetectionFilter implements Filter {

    private FilterConfig filterConfig = null;
    private static final Logger LOGGER = Logger.getLogger(BrowserDetectionFilter.class);
    private static final Pattern PATRON_IE = Pattern.compile("MSIE \\d{1,2}.[0123456789bB]{1,3}");
    private static final Pattern PATRON_FIREFOX = Pattern.compile("Firefox/\\d{1,2}.[0123456789bB]{1,3}");
    private static final Pattern PATRON_CHROME = Pattern.compile("Chrome/(\\d{1,2}.[0123456789]{1,3})*");
    private static final Pattern PATRON_VERSION = Pattern.compile("\\d{1,2}");

    public BrowserDetectionFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception java.io.IOException if an input/output error occurs
     * @exception javax.servlet.ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String userAgent;
        String browser = "GENERIC";
        String version = "1";
        if (request instanceof HttpServletRequest) {
            userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
            if (userAgent != null) {
                Scanner sc = new Scanner(userAgent);
                String rpta = sc.findInLine(PATRON_IE);
                if (rpta != null) {
                    Scanner scd = new Scanner(rpta);
                    browser = "MSIE";
                    version = scd.findInLine(PATRON_VERSION);
                } else {
                    rpta = sc.findInLine(PATRON_FIREFOX);
                    if (rpta != null) {
                        Scanner scd = new Scanner(rpta);
                        browser = "FIREFOX";
                        version = scd.findInLine(PATRON_VERSION);
                    } else {
                        rpta = sc.findInLine(PATRON_CHROME);
                        if (rpta != null) {
                            Scanner scd = new Scanner(rpta);
                            browser = "CHROME";
                            version = scd.findInLine(PATRON_VERSION);
                            if (version == null) {
                                version = "1";
                            }
                        }
                    }
                }
            }
        }
        request.setAttribute("browser", browser);
        request.setAttribute("browser.version", version);

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            LOGGER.error(t.getMessage(), t);
            throw new ServletException(t.getMessage(), t);
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

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("BrowserDetectionFilter()");
        }
        StringBuffer sb = new StringBuffer("BrowserDetectionFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
}
