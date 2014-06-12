package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_recauda", schema = "dbo", catalog = "COBRANZA")
public class TblRecaudaEntity {
    private Integer systemId;
    private Integer linkFormapago;
    private Integer linkCliente;
    private String direccion;
    private Integer linkComuna;
    private Boolean entregaCedible;
    private Integer linkUsuarioRecauda;
    private Integer linkBanco;
    private Date fecPago;
    private String horarioPago;
    private Integer linkSucursalKup;
    private Integer linkSucursalCli;
    private Integer linkContacto;
    private Boolean pagoLun;
    private Boolean pagoMar;
    private Boolean pagoMie;
    private Boolean pagoJue;
    private Boolean pagoVie;
    private Boolean validada;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "link_formapago")
    public Integer getLinkFormapago() {
        return linkFormapago;
    }

    public void setLinkFormapago(Integer linkFormapago) {
        this.linkFormapago = linkFormapago;
    }

    @Basic
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "link_comuna")
    public Integer getLinkComuna() {
        return linkComuna;
    }

    public void setLinkComuna(Integer linkComuna) {
        this.linkComuna = linkComuna;
    }

    @Basic
    @Column(name = "entrega_cedible")
    public Boolean getEntregaCedible() {
        return entregaCedible;
    }

    public void setEntregaCedible(Boolean entregaCedible) {
        this.entregaCedible = entregaCedible;
    }

    @Basic
    @Column(name = "link_usuario_recauda")
    public Integer getLinkUsuarioRecauda() {
        return linkUsuarioRecauda;
    }

    public void setLinkUsuarioRecauda(Integer linkUsuarioRecauda) {
        this.linkUsuarioRecauda = linkUsuarioRecauda;
    }

    @Basic
    @Column(name = "link_banco")
    public Integer getLinkBanco() {
        return linkBanco;
    }

    public void setLinkBanco(Integer linkBanco) {
        this.linkBanco = linkBanco;
    }

    @Basic
    @Column(name = "fec_pago")
    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    @Basic
    @Column(name = "horario_pago")
    public String getHorarioPago() {
        return horarioPago;
    }

    public void setHorarioPago(String horarioPago) {
        this.horarioPago = horarioPago;
    }

    @Basic
    @Column(name = "link_sucursal_kup")
    public Integer getLinkSucursalKup() {
        return linkSucursalKup;
    }

    public void setLinkSucursalKup(Integer linkSucursalKup) {
        this.linkSucursalKup = linkSucursalKup;
    }

    @Basic
    @Column(name = "link_sucursal_cli")
    public Integer getLinkSucursalCli() {
        return linkSucursalCli;
    }

    public void setLinkSucursalCli(Integer linkSucursalCli) {
        this.linkSucursalCli = linkSucursalCli;
    }

    @Basic
    @Column(name = "link_contacto")
    public Integer getLinkContacto() {
        return linkContacto;
    }

    public void setLinkContacto(Integer linkContacto) {
        this.linkContacto = linkContacto;
    }

    @Basic
    @Column(name = "pago_lun")
    public Boolean getPagoLun() {
        return pagoLun;
    }

    public void setPagoLun(Boolean pagoLun) {
        this.pagoLun = pagoLun;
    }

    @Basic
    @Column(name = "pago_mar")
    public Boolean getPagoMar() {
        return pagoMar;
    }

    public void setPagoMar(Boolean pagoMar) {
        this.pagoMar = pagoMar;
    }

    @Basic
    @Column(name = "pago_mie")
    public Boolean getPagoMie() {
        return pagoMie;
    }

    public void setPagoMie(Boolean pagoMie) {
        this.pagoMie = pagoMie;
    }

    @Basic
    @Column(name = "pago_jue")
    public Boolean getPagoJue() {
        return pagoJue;
    }

    public void setPagoJue(Boolean pagoJue) {
        this.pagoJue = pagoJue;
    }

    @Basic
    @Column(name = "pago_vie")
    public Boolean getPagoVie() {
        return pagoVie;
    }

    public void setPagoVie(Boolean pagoVie) {
        this.pagoVie = pagoVie;
    }

    @Basic
    @Column(name = "validada")
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

        TblRecaudaEntity that = (TblRecaudaEntity) o;

        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (entregaCedible != null ? !entregaCedible.equals(that.entregaCedible) : that.entregaCedible != null)
            return false;
        if (fecPago != null ? !fecPago.equals(that.fecPago) : that.fecPago != null) return false;
        if (horarioPago != null ? !horarioPago.equals(that.horarioPago) : that.horarioPago != null) return false;
        if (linkBanco != null ? !linkBanco.equals(that.linkBanco) : that.linkBanco != null) return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkComuna != null ? !linkComuna.equals(that.linkComuna) : that.linkComuna != null) return false;
        if (linkContacto != null ? !linkContacto.equals(that.linkContacto) : that.linkContacto != null) return false;
        if (linkFormapago != null ? !linkFormapago.equals(that.linkFormapago) : that.linkFormapago != null)
            return false;
        if (linkSucursalCli != null ? !linkSucursalCli.equals(that.linkSucursalCli) : that.linkSucursalCli != null)
            return false;
        if (linkSucursalKup != null ? !linkSucursalKup.equals(that.linkSucursalKup) : that.linkSucursalKup != null)
            return false;
        if (linkUsuarioRecauda != null ? !linkUsuarioRecauda.equals(that.linkUsuarioRecauda) : that.linkUsuarioRecauda != null)
            return false;
        if (pagoJue != null ? !pagoJue.equals(that.pagoJue) : that.pagoJue != null) return false;
        if (pagoLun != null ? !pagoLun.equals(that.pagoLun) : that.pagoLun != null) return false;
        if (pagoMar != null ? !pagoMar.equals(that.pagoMar) : that.pagoMar != null) return false;
        if (pagoMie != null ? !pagoMie.equals(that.pagoMie) : that.pagoMie != null) return false;
        if (pagoVie != null ? !pagoVie.equals(that.pagoVie) : that.pagoVie != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (validada != null ? !validada.equals(that.validada) : that.validada != null) return false;

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
