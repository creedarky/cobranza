package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@javax.persistence.Table(name = "tbl_recauda", schema = "dbo", catalog = "COBRANZA")
public class Recauda {
    private Integer systemId;

    @Basic
    @javax.persistence.Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    private Integer linkFormapago;

    @Basic
    @javax.persistence.Column(name = "link_formapago")
    public Integer getLinkFormapago() {
        return linkFormapago;
    }

    public void setLinkFormapago(Integer linkFormapago) {
        this.linkFormapago = linkFormapago;
    }

    private Integer linkCliente;

    @Basic
    @javax.persistence.Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    private String direccion;

    @Basic
    @javax.persistence.Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private Integer linkComuna;

    @Basic
    @javax.persistence.Column(name = "link_comuna")
    public Integer getLinkComuna() {
        return linkComuna;
    }

    public void setLinkComuna(Integer linkComuna) {
        this.linkComuna = linkComuna;
    }

    private Boolean entregaCedible;

    @Basic
    @javax.persistence.Column(name = "entrega_cedible")
    public Boolean getEntregaCedible() {
        return entregaCedible;
    }

    public void setEntregaCedible(Boolean entregaCedible) {
        this.entregaCedible = entregaCedible;
    }

    private Integer linkUsuarioRecauda;

    @Basic
    @javax.persistence.Column(name = "link_usuario_recauda")
    public Integer getLinkUsuarioRecauda() {
        return linkUsuarioRecauda;
    }

    public void setLinkUsuarioRecauda(Integer linkUsuarioRecauda) {
        this.linkUsuarioRecauda = linkUsuarioRecauda;
    }

    private Integer linkBanco;

    @Basic
    @javax.persistence.Column(name = "link_banco")
    public Integer getLinkBanco() {
        return linkBanco;
    }

    public void setLinkBanco(Integer linkBanco) {
        this.linkBanco = linkBanco;
    }

    private Date fecPago;

    @Basic
    @javax.persistence.Column(name = "fec_pago")
    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    private String horarioPago;

    @Basic
    @javax.persistence.Column(name = "horario_pago")
    public String getHorarioPago() {
        return horarioPago;
    }

    public void setHorarioPago(String horarioPago) {
        this.horarioPago = horarioPago;
    }

    private Integer linkSucursalKup;

    @Basic
    @javax.persistence.Column(name = "link_sucursal_kup")
    public Integer getLinkSucursalKup() {
        return linkSucursalKup;
    }

    public void setLinkSucursalKup(Integer linkSucursalKup) {
        this.linkSucursalKup = linkSucursalKup;
    }

    private Integer linkSucursalCli;

    @Basic
    @javax.persistence.Column(name = "link_sucursal_cli")
    public Integer getLinkSucursalCli() {
        return linkSucursalCli;
    }

    public void setLinkSucursalCli(Integer linkSucursalCli) {
        this.linkSucursalCli = linkSucursalCli;
    }

    private Integer linkContacto;

    @Basic
    @javax.persistence.Column(name = "link_contacto")
    public Integer getLinkContacto() {
        return linkContacto;
    }

    public void setLinkContacto(Integer linkContacto) {
        this.linkContacto = linkContacto;
    }

    private Boolean pagoLun;

    @Basic
    @javax.persistence.Column(name = "pago_lun")
    public Boolean getPagoLun() {
        return pagoLun;
    }

    public void setPagoLun(Boolean pagoLun) {
        this.pagoLun = pagoLun;
    }

    private Boolean pagoMar;

    @Basic
    @javax.persistence.Column(name = "pago_mar")
    public Boolean getPagoMar() {
        return pagoMar;
    }

    public void setPagoMar(Boolean pagoMar) {
        this.pagoMar = pagoMar;
    }

    private Boolean pagoMie;

    @Basic
    @javax.persistence.Column(name = "pago_mie")
    public Boolean getPagoMie() {
        return pagoMie;
    }

    public void setPagoMie(Boolean pagoMie) {
        this.pagoMie = pagoMie;
    }

    private Boolean pagoJue;

    @Basic
    @javax.persistence.Column(name = "pago_jue")
    public Boolean getPagoJue() {
        return pagoJue;
    }

    public void setPagoJue(Boolean pagoJue) {
        this.pagoJue = pagoJue;
    }

    private Boolean pagoVie;

    @Basic
    @javax.persistence.Column(name = "pago_vie")
    public Boolean getPagoVie() {
        return pagoVie;
    }

    public void setPagoVie(Boolean pagoVie) {
        this.pagoVie = pagoVie;
    }

    private Boolean validada;

    @Basic
    @javax.persistence.Column(name = "validada")
    public Boolean getValidada() {
        return validada;
    }

    public void setValidada(Boolean validada) {
        this.validada = validada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recauda recauda = (Recauda) o;

        if (direccion != null ? !direccion.equals(recauda.direccion) : recauda.direccion != null) return false;
        if (entregaCedible != null ? !entregaCedible.equals(recauda.entregaCedible) : recauda.entregaCedible != null)
            return false;
        if (fecPago != null ? !fecPago.equals(recauda.fecPago) : recauda.fecPago != null) return false;
        if (horarioPago != null ? !horarioPago.equals(recauda.horarioPago) : recauda.horarioPago != null) return false;
        if (linkBanco != null ? !linkBanco.equals(recauda.linkBanco) : recauda.linkBanco != null) return false;
        if (linkCliente != null ? !linkCliente.equals(recauda.linkCliente) : recauda.linkCliente != null) return false;
        if (linkComuna != null ? !linkComuna.equals(recauda.linkComuna) : recauda.linkComuna != null) return false;
        if (linkContacto != null ? !linkContacto.equals(recauda.linkContacto) : recauda.linkContacto != null)
            return false;
        if (linkFormapago != null ? !linkFormapago.equals(recauda.linkFormapago) : recauda.linkFormapago != null)
            return false;
        if (linkSucursalCli != null ? !linkSucursalCli.equals(recauda.linkSucursalCli) : recauda.linkSucursalCli != null)
            return false;
        if (linkSucursalKup != null ? !linkSucursalKup.equals(recauda.linkSucursalKup) : recauda.linkSucursalKup != null)
            return false;
        if (linkUsuarioRecauda != null ? !linkUsuarioRecauda.equals(recauda.linkUsuarioRecauda) : recauda.linkUsuarioRecauda != null)
            return false;
        if (pagoJue != null ? !pagoJue.equals(recauda.pagoJue) : recauda.pagoJue != null) return false;
        if (pagoLun != null ? !pagoLun.equals(recauda.pagoLun) : recauda.pagoLun != null) return false;
        if (pagoMar != null ? !pagoMar.equals(recauda.pagoMar) : recauda.pagoMar != null) return false;
        if (pagoMie != null ? !pagoMie.equals(recauda.pagoMie) : recauda.pagoMie != null) return false;
        if (pagoVie != null ? !pagoVie.equals(recauda.pagoVie) : recauda.pagoVie != null) return false;
        if (systemId != null ? !systemId.equals(recauda.systemId) : recauda.systemId != null) return false;
        if (validada != null ? !validada.equals(recauda.validada) : recauda.validada != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkFormapago != null ? linkFormapago.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (linkComuna != null ? linkComuna.hashCode() : 0);
        result = 31 * result + (entregaCedible != null ? entregaCedible.hashCode() : 0);
        result = 31 * result + (linkUsuarioRecauda != null ? linkUsuarioRecauda.hashCode() : 0);
        result = 31 * result + (linkBanco != null ? linkBanco.hashCode() : 0);
        result = 31 * result + (fecPago != null ? fecPago.hashCode() : 0);
        result = 31 * result + (horarioPago != null ? horarioPago.hashCode() : 0);
        result = 31 * result + (linkSucursalKup != null ? linkSucursalKup.hashCode() : 0);
        result = 31 * result + (linkSucursalCli != null ? linkSucursalCli.hashCode() : 0);
        result = 31 * result + (linkContacto != null ? linkContacto.hashCode() : 0);
        result = 31 * result + (pagoLun != null ? pagoLun.hashCode() : 0);
        result = 31 * result + (pagoMar != null ? pagoMar.hashCode() : 0);
        result = 31 * result + (pagoMie != null ? pagoMie.hashCode() : 0);
        result = 31 * result + (pagoJue != null ? pagoJue.hashCode() : 0);
        result = 31 * result + (pagoVie != null ? pagoVie.hashCode() : 0);
        result = 31 * result + (validada != null ? validada.hashCode() : 0);
        return result;
    }
}
