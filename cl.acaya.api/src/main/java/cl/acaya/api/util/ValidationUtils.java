package cl.acaya.api.util;

import cl.acaya.api.vo.Mensaje;
import cl.acaya.api.vo.MensajesFactory;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 8/9/13
 * Time: 10:40 AM
 */
public class ValidationUtils {

    private static final Logger LOGGER = Logger.getLogger(ValidationUtils.class);

    private ValidationUtils() {
    }

    public static void main(String[] args) {
        String cadena = "   ";
        //System.out.println(cadena.isEmpty());

        String rut = "23423";
        System.out.println(haveOnlyNums(rut));
    }

    public static boolean isNotNullNotEmpty(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /* public static List<String> validaRut(String rutCliente, String rutClienteDv) {

        List<String> errores = new ArrayList<String>();

        if (!ValidationUtils.isNotNullNotEmpty(rutCliente)) {
            errores.add("No has ingresado RUT");// TODO add i18n
        }

        if (!ValidationUtils.isNotNullNotEmpty(rutClienteDv)) {
            errores.add("No has ingresado Digito Verificador de RUT");// TODO add i18n
        }

        // TODO algoritmo valida rut

        return errores;
    } */

    public static boolean isNum(String num) {
        return num != null && num.matches("\\d+");
    }

    public static void validaShort(String someShort, String fieldName, List<Mensaje> errores) {
        if (!isNotNullNotEmpty(someShort)) {
            errores.add(MensajesFactory.newMensajeError("00018", "No has ingresado: " + fieldName));
        } else if (!haveOnlyNums(someShort)) {
            errores.add(MensajesFactory.newMensajeError("00017", "No has ingresado un valor n\u00FAmerico apropiado para: " + fieldName));
        } else {
            try {
                Short.parseShort(someShort);
            } catch (Exception e) {
                errores.add(MensajesFactory.newMensajeError("00016", "No has ingresado un valor n\u00FAmerico apropiado para: " + fieldName));
            }
        }
    }

    public static boolean haveOnlyNums(String someString) {
        return someString != null && someString.matches("\\d+");
    }

    public static void validaString(String someString, String fieldName, List<Mensaje> errores) {
        if (!isNotNullNotEmpty(someString)) {
            errores.add(MensajesFactory.newMensajeError("00015", "No has ingresado: " + fieldName));
        }
    }


    public static boolean isLong(final String numberSt) {
        boolean isLong = false;
        if (isNotNullNotEmpty(numberSt)) {
            try {
                Long.valueOf(numberSt);
                isLong = true;
            } catch (NumberFormatException e) {
            }
        }

        return isLong;
    }

    public static void validaDate(Date someDate, String fieldName, List<Mensaje> errores) {
        if (!isNotNull(someDate)) {
            errores.add(MensajesFactory.newMensajeError("00011", "No has ingresado: " + fieldName));
        }
    }

    public static void validaNotNull(Object someObj, String fieldName, List<Mensaje> errores) {
        if (!isNotNull(someObj)) {
            errores.add(MensajesFactory.newMensajeError("00010", "No has ingresado: " + fieldName));
        }
    }
}