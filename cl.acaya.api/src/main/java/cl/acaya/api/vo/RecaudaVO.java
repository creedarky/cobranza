package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mcastro on 13-06-14.
 */
public class RecaudaVO implements Serializable{

    private Long idContacto;
    private Integer idFormaPago;
    private Integer idBanco;
    private Boolean entregaCopia;
    private String direccion;
    private Boolean pagoLun;
    private Boolean pagoMar;
    private Boolean pagoMie;
    private Boolean pagoJue;
    private Boolean pagoVie;
    private Date fecha;

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Boolean getEntregaCopia() {
        return entregaCopia;
    }

    public void setEntregaCopia(Boolean entregaCopia) {
        this.entregaCopia = entregaCopia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getPagoLun() {
        return pagoLun;
    }

    public void setPagoLun(Boolean pagoLun) {
        this.pagoLun = pagoLun;
    }

    public Boolean getPagoMar() {
        return pagoMar;
    }

    public void setPagoMar(Boolean pagoMar) {
        this.pagoMar = pagoMar;
    }

    public Boolean getPagoMie() {
        return pagoMie;
    }

    public void setPagoMie(Boolean pagoMie) {
        this.pagoMie = pagoMie;
    }

    public Boolean getPagoJue() {
        return pagoJue;
    }

    public void setPagoJue(Boolean pagoJue) {
        this.pagoJue = pagoJue;
    }

    public Boolean getPagoVie() {
        return pagoVie;
    }

    public void setPagoVie(Boolean pagoVie) {
        this.pagoVie = pagoVie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RecaudaVO{" +
                "idContacto=" + idContacto +
                ", idFormaPago=" + idFormaPago +
                ", direccion='" + direccion + '\'' +
                ", idBanco=" + idBanco +
                ", entregaCopia=" + entregaCopia +
                ", direccion='" + direccion + '\'' +
                ", pagoLun=" + pagoLun +
                ", pagoMar=" + pagoMar +
                ", pagoMie=" + pagoMie +
                ", pagoJue=" + pagoJue +
                ", pagoVie=" + pagoVie +
                ", fecha=" + fecha +
                '}';
    }
}
