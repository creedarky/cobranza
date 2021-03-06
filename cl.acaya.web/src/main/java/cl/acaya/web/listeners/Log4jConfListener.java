package cl.acaya.web.listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 10/21/13
 * Time: 10:29 AM
 */
public class Log4jConfListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(Log4jConfListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //String log4jconfigPath = servletContextEvent.getServletContext().getInitParameter("log4j.config.path");
        String ruta = String.format("%s/aplsEPCS/pcdc/config/log4j-web.properties", System.getProperty("user.dir"));
        System.out.println("- PCU ruta: " + ruta);
        System.out.println("- PCU user dir: " + System.getProperty("user.dir"));
        PropertyConfigurator.configure(ruta);
        LOGGER.info("log4j web configurado para PCU");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // do nothing
    }
}
