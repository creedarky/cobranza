package cl.acaya.api.util;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

/**
 *
 * @author rquezada@kiosolutions.com
 */
public class StringUtils {

    private static final Logger LOGGER = Logger.getLogger(StringUtils.class);

    private StringUtils() {
    }

    public static String toUpperCase(String text) {
        if (text == null) {
            return null;
        }
        return text.trim().toUpperCase();
    }

    public static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }
        return text.trim().isEmpty();
    }

    public static String truncate(String entity, String property, String value, int length) {
        if (value != null && value.length() > length) {
            String old = value;
            value = value.substring(0, length);
            LOGGER.warn(MessageFormat.format("{0}.{1} Max Length {2}, Truncate [{3}] to [{4}]", new Object[]{entity, property, length, old, value}));
        }
        return value;
    }

    public static String trimForSave(String entity, String property, String value, int length) {
        return truncate(entity, property, toUpperCase(value), length);
    }
}
