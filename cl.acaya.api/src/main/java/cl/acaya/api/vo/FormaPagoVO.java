package cl.acaya.api.vo;

/**
 * Created by mcastro on 13-06-14.
 */
public class FormaPagoVO {

    private Integer idFormaPago;
    private String formaPago;
    private Integer dias;

    public FormaPagoVO() {
    }

    public FormaPagoVO(Integer idFormaPago, String formaPago, Integer dias) {
        this.idFormaPago = idFormaPago;
        this.formaPago = formaPago;
        this.dias = dias;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
}
