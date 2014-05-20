package cl.acaya.api.vo;

/**
 * User: Kiosolutions
 */
public final class MensajesFactory {

    private MensajesFactory() {
    }

    public static Mensaje newMensajeInfo(final String codigo, final String msg) {
        return new Mensaje(TipoMsg.INFO, codigo, msg);
    }

    public static Mensaje newMensajeWarn(final String codigo, final String msg) {
        return new Mensaje(TipoMsg.WARNING, codigo, msg);
    }

    public static Mensaje newMensajeError(final String codigo, final String msg) {
        return new Mensaje(TipoMsg.ERROR, codigo, msg);
    }

}
