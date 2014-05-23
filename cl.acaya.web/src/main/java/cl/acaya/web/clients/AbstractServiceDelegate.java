package cl.acaya.web.clients;


import cl.acaya.api.service.ServiceLocator;

/**
 * @author Kiosolutions
 */
public abstract class AbstractServiceDelegate {

    abstract void setJndiName(String jndiName);

    protected <T extends Object> T getService(final String jndiName, final Class<T> type) {
        return ServiceLocator.getInstance().getService(jndiName, type);
    }
}
