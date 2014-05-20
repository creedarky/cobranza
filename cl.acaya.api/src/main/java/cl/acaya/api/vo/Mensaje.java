package cl.acaya.api.vo;

import java.io.Serializable;

/**
 * @author Kiosolutions
 */
public class Mensaje implements Serializable {

    private TipoMsg tipoMsg;
    private String codigo;
    private String texto;

    public Mensaje() {
    }

    public Mensaje(TipoMsg tipoMsg, String codigo, String texto) {
        this.tipoMsg = tipoMsg;
        this.codigo = codigo;
        this.texto = texto;
    }

    public TipoMsg getTipoMsg() {
        return tipoMsg;
    }

    public void setTipoMsg(TipoMsg tipoMsg) {
        this.tipoMsg = tipoMsg;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
