package cl.acaya.api.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * User: Kiosolutions
 */
public abstract class AbstractMensajes {

    public AbstractMensajes() {
    }

    public abstract String getBundleName();

    public ResourceBundle getResourceBundle(final Locale locale) {
        return ResourceBundle.getBundle(getBundleName(), locale);
    }

    public String getString(Locale locale, String key) {
        return getResourceBundle(locale).getString(key);
    }

    public String getFormattedString(Locale locale, String key, Object... arguments) {
        return MessageFormat.format(getResourceBundle(locale).getString(key), arguments);
    }
}
