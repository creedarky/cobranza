package cl.acaya.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author rquezada@kiosolutions.com
 */
public class ResourcesVersionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rv = sce.getServletContext().getInitParameter("pcuResourcesVersion");
        sce.getServletContext().setAttribute("pcuResourcesVersion", rv);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
