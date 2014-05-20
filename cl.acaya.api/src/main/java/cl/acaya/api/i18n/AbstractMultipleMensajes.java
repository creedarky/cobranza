package cl.acaya.api.i18n;

import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA. User: fbrule Date: 10/28/13 Time: 3:06 PM
 */
public abstract class AbstractMultipleMensajes {

    private static final Logger LOGGER = Logger.getLogger(AbstractMultipleMensajes.class);
    private final Map<String, Map<Locale, ResourceBundle>> cache =
            new HashMap<String, Map<Locale, ResourceBundle>>();

    public AbstractMultipleMensajes() {

        if (getBundleNames() == null || getBundleNames().length == 0) {
            throw new IllegalArgumentException("No has ingresado Bundle names");
        }

        for (String bundleName : getBundleNames()) {
            if (bundleName == null || "".equals(bundleName.trim())) {
                throw new IllegalArgumentException("Bundle name ingresado esta vacio");
            }
        }

        List<String> codigos = new ArrayList<String>();
        List<String> codigosRepetidos = new ArrayList<String>();
        Locale locale = new Locale("es", "CL");
        for (String bundleName : getBundleNames()) {
            ResourceBundle resourceBundle = getResourceBundle(bundleName, locale);
            if (resourceBundle != null) {
                Enumeration<String> codigosEnum = resourceBundle.getKeys();
                while (codigosEnum.hasMoreElements()) {
                    String codigo = codigosEnum.nextElement();
                    if (!codigos.contains(codigo)) {
                        codigos.add(codigo);
                    } else {
                        codigosRepetidos.add(codigo);
                    }
                }
            }
        }

        if (false) // TODO hay codigos repetidos, hacer limpieza!
        {
            if (!codigosRepetidos.isEmpty()) {
                StringBuilder ts = new StringBuilder();
                int c = 0;
                for (String mensaje : codigosRepetidos) {
                    ts.append(mensaje);
                    c++;
                    if (c < codigosRepetidos.size()) {
                        ts.append(", ");
                    }
                }

                throw new IllegalArgumentException("Los siguientes C\u00F3digos est\u00E1n repetidos: " + ts.toString());
            }
        }

    }

    private void valida(final String code) {
        if (code == null || "".equals(code.trim())) {
            throw new IllegalArgumentException("No has ingresado C\u00F3digo de Mensaje");
        }
    }

    private void valida(final Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("No has ingresado Locale");
        }
    }

    private ResourceBundle doGetBundle(final String bundleName, final Locale locale) throws MissingResourceException {
        return ResourceBundle.getBundle(bundleName, locale);
    }

    public ResourceBundle getResourceBundle(final String bundleName, final Locale locale) {

        Map<Locale, ResourceBundle> cacheMap = cache.get(bundleName);
        // Si esta en el cache
        if (cacheMap != null) {
            ResourceBundle bundle = cacheMap.get(locale);
            if (bundle != null) {
                return bundle;
            }
        }

        // No esta en el cache
        try {

            ResourceBundle bundle = doGetBundle(bundleName, locale);
            cacheMap = new HashMap<Locale, ResourceBundle>();
            cacheMap.put(locale, bundle);
            cache.put(bundleName, cacheMap);

            return bundle;

        } catch (MissingResourceException ex) {
            LOGGER.warn("ResourceBundle [" + bundleName + "] not found for MessageSource: " + ex.getMessage());
            return null;
        }
    }

    private String getStringOrNull(final ResourceBundle bundle, final String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException ex) {
            // Assume key not found
            // -> do NOT throw the exception to allow for checking parent message source.
            return null;
        }
    }

    public String getString(final Locale locale, final String code) {
        valida(locale);
        valida(code);
        String mensaje = null;
        for (int i = 0; i < getBundleNames().length; i++) {
            ResourceBundle bundle = getResourceBundle(getBundleNames()[i], locale);
            if (bundle != null) {
                mensaje = getStringOrNull(bundle, code);
                if (mensaje != null) {
                    break;
                }
            }
        }

        return mensaje;
    }

    public String getFormattedString(final Locale locale, final String code, final Object... arguments) {
        valida(locale);
        valida(code);
        String mensaje = getString(locale, code);
        if (mensaje != null) {
            return MessageFormat.format(mensaje, arguments);
        } else {
            return String.format("Mensaje no encontrado para el C\u00F3digo: " + code);
        }
    }

    public abstract String[] getBundleNames();
}
