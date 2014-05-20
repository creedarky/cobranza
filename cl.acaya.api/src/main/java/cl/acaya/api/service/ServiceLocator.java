package cl.acaya.api.service;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Kiosolutions
 */
public final class ServiceLocator {

    private static final Logger LOGGER = Logger.getLogger(ServiceLocator.class);
    private static ServiceLocator me = new ServiceLocator();

    private ServiceLocator() {
    }

    public static ServiceLocator getInstance() {
        return me;
    }

    public <T extends Object> T getService(final String jndiName, final Class<T> type) {

        if (jndiName == null || jndiName.equals("")) {
            throw new IllegalArgumentException("No has ingresado JNDI Name");
        }

        if (type == null) {
            throw new IllegalArgumentException("No has ingresado Type");
        }

        try {
            InitialContext initialContext = new InitialContext();
            return type.cast(initialContext.lookup(jndiName));
        } catch (NamingException e) {
            LOGGER.error(String.format("Error al intentar recuperar jndiName[%s]", jndiName));
            return null;
        } catch (ClassCastException e) {
            LOGGER.error(String.format("Tipo ingresado no es v\u00E1lido[%s]", type));
            return null;
        } catch (Exception e) {
            LOGGER.error(String.format("Error al recuperar servicio: jndiName[%s]", jndiName));
            return null;
        }
    }

}
