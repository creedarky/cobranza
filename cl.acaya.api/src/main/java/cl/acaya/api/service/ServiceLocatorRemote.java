package cl.acaya.api.service;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * User: Kiosolutions
 */
public final class ServiceLocatorRemote {

    private static final Logger LOGGER = Logger.getLogger(ServiceLocatorRemote.class);

    private static ServiceLocatorRemote me;

    private int port;
    private String host;
    private String username;
    private String password;

    private ServiceLocatorRemote() {
    }

    private ServiceLocatorRemote(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public static ServiceLocatorRemote getInstance(String host, int port, String username, String password) {
        if (me == null) {
            me = new ServiceLocatorRemote();
            me.host = host;
            me.port = port;
            me.username = username;
            me.password = password;
        }

        return me;
    }

    public <T> T getRemoteService(final String jndiName, final Class<T> type) {

        Hashtable<String, String> env = new Hashtable<String, String>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, String.format("t3://%1$s:%2$s", host, port));
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);

        try {
            InitialContext initialContext = new InitialContext(env);
            return type.cast(initialContext.lookup(jndiName));
        } catch (NamingException e) {
            LOGGER.error(String.format("Error al intentar recuperar jndiName[%s]", jndiName));
            return null;
        } catch (ClassCastException e) {
            LOGGER.error(String.format("Tipo ingresado no es v\u00E1lido[%s]", type));
            return null;
        } catch (Exception e) {
            LOGGER.error(String.format("Error al recuperar servicio, jndiName[%s], INITIAL_CONTEXT_FACTORY[%s], PROVIDER_URL[%s], SECURITY_PRINCIPAL[%s], SECURITY_CREDENTIALS[%s]",
                    jndiName,
                    env.get(Context.INITIAL_CONTEXT_FACTORY),
                    env.get(Context.PROVIDER_URL),
                    env.get(Context.SECURITY_PRINCIPAL),
                    env.get(Context.SECURITY_CREDENTIALS)));
            return null;
        }
    }
}
