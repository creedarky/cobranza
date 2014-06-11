package cl.acaya.api.vo.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcastro on 10-06-14.
 */
public enum TipoCuentasKupferType {
    KX("Kupfer Express"), GC("Grandes Cuentas"), MX("Mixto");

    private String nombre;

    private TipoCuentasKupferType(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    private static final List<TipoCuentasKupferType> tipos = new ArrayList<TipoCuentasKupferType>();

    static {
        tipos.addAll(Arrays.asList(TipoCuentasKupferType.values()));
    }

    public static List<TipoCuentasKupferType> getTipos() {
        return tipos;
    }

    public static String getNombreCuentaPorCodigoCanal(String codigoCanal) {
        String canal = "";
        if ("X".equals(codigoCanal)) {
            canal = KX.getNombre();

        } else if ("G".equals(codigoCanal)) {
            canal = GC.getNombre();

        } else if ("M".equals(codigoCanal)) {
            canal = MX.getNombre();
        }
        return canal;

    }
}
