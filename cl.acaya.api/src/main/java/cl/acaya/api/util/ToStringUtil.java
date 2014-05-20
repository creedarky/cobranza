package cl.acaya.api.util;


import cl.acaya.api.vo.Mensaje;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: fbrule
 * Date: 8/21/13
 * Time: 5:54 PM
 */
public class ToStringUtil {

    private ToStringUtil() {
    }

    public static String toString(Map<String, Object> params) {
        StringBuilder ts = new StringBuilder();
        for (String key : params.keySet()) {
            ts.append(String.format("\t- [%s]=>[%s]\n", key, params.get(key)));
        }
        return ts.toString();
    }

    public static String toString(List<Mensaje> mensajes) {
        StringBuilder ts = new StringBuilder();
        for (Mensaje mensaje : mensajes) {
            ts.append(mensaje.getTexto() + "\n");
        }

        return ts.toString();
    }

}
