package cl.acaya.api.i18n;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 10/7/13
 * Time: 7:14 PM
 */
public class I18nUtil {

    private static final Logger LOGGER = Logger.getLogger(I18nUtil.class);

    private final static Locale LOCALE_ES_CL = new Locale("es", "CL");

    private I18nUtil() {
    }

    public static BigDecimal newCantidadMonetaria(final String numberSt) {

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(LOCALE_ES_CL);
        decimalFormat.setParseBigDecimal(true);

        BigDecimal bigDecimal = null;

        if (numberSt != null && !numberSt.trim().equals("")) {

            try {
                bigDecimal = (BigDecimal) decimalFormat.parseObject(numberSt);
            } catch (ParseException e) {
                LOGGER.error(e);
                // TODO throw
            }
        } else {
            bigDecimal=BigDecimal.ZERO;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("number string[%s] = bigdecimal[%s]", numberSt, bigDecimal));
        }

        return bigDecimal;
    }

}