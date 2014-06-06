/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.acaya.api.vo;

import java.util.Date;

/**
 * @author aruizp
 */
public class PartidasSAPVO implements Cloneable {
    private String codigoSociedad;
    private String codigoCliente;
    private String codigoOperacion;
    private String indicacionOperacion;
    private Date fechaCompensacion;
    private String numeroDocumentoCompensacion;
    private String numeroAsignacion;
    private Integer numeroEjercicio;
    private String numeroContable;
    private Integer numeroApunte;
    private String rutCliente;
    private Date fechaContable;
    private Date fechaDocumento;
    private String claseDocumento;
    private Integer montoCobrar;
    private String indicadorSentido;
    private Date fechaVencimiento;
    private String nombreResponsable;
    private String oficinaResponsable;
    private String numeroFactura;
    private String folioSii;
    private String clavePago;
    private Integer codigoCobrador;
    private String grupoMateriales;
    private String ordenCompra;
    private String codigoCuenta;
    private Integer montoPartida;
    private String nombreCliente;

    public PartidasSAPVO() {
    }



    public String getCodigoSociedad() {
        return codigoSociedad;
    }

    public void setCodigoSociedad(String codigoSociedad) {
        this.codigoSociedad = codigoSociedad;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getIndicacionOperacion() {
        return indicacionOperacion;
    }

    public void setIndicacionOperacion(String indicacionOperacion) {
        this.indicacionOperacion = indicacionOperacion;
    }

    public Date getFechaCompensacion() {
        return fechaCompensacion;
    }

    public void setFechaCompensacion(Date fechaCompensacion) {
        this.fechaCompensacion = fechaCompensacion;
    }

    public String getNumeroDocumentoCompensacion() {
        return numeroDocumentoCompensacion;
    }

    public void setNumeroDocumentoCompensacion(String numeroDocumentoCompensacion) {
        this.numeroDocumentoCompensacion = numeroDocumentoCompensacion;
    }

    public String getNumeroAsignacion() {
        return numeroAsignacion;
    }

    public void setNumeroAsignacion(String numeroAsignacion) {
        this.numeroAsignacion = numeroAsignacion;
    }

    public Integer getNumeroEjercicio() {
        return numeroEjercicio;
    }

    public void setNumeroEjercicio(Integer numeroEjercicio) {
        this.numeroEjercicio = numeroEjercicio;
    }

    public String getNumeroContable() {
        return numeroContable;
    }

    public void setNumeroContable(String numeroContable) {
        this.numeroContable = numeroContable;
    }

    public Integer getNumeroApunte() {
        return numeroApunte;
    }

    public void setNumeroApunte(Integer numeroApunte) {
        this.numeroApunte = numeroApunte;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Date getFechaContable() {
        return fechaContable;
    }

    public void setFechaContable(Date fechaContable) {
        this.fechaContable = fechaContable;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getClaseDocumento() {
        return claseDocumento;
    }

    public void setClaseDocumento(String claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    public Integer getMontoCobrar() {
        return montoCobrar;
    }

    public void setMontoCobrar(Integer montoCobrar) {
        this.montoCobrar = montoCobrar;
    }

    public Integer getMontoPartida() {
        return montoPartida;
    }

    public void setMontoPartida(Integer montoPartida) {
        this.montoPartida = montoPartida;
    }

    public String getIndicadorSentido() {
        return indicadorSentido;
    }

    public void setIndicadorSentido(String indicadorSentido) {
        this.indicadorSentido = indicadorSentido;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getOficinaResponsable() {
        return oficinaResponsable;
    }

    public void setOficinaResponsable(String oficinaResponsable) {
        this.oficinaResponsable = oficinaResponsable;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFolioSii() {
        return folioSii;
    }

    public void setFolioSii(String folioSii) {
        this.folioSii = folioSii;
    }

    public String getClavePago() {
        return clavePago;
    }

    public void setClavePago(String clavePago) {
        this.clavePago = clavePago;
    }

    public Integer getCodigoCobrador() {
        return codigoCobrador;
    }

    public void setCodigoCobrador(Integer codigoCobrador) {
        this.codigoCobrador = codigoCobrador;
    }

    public String getGrupoMateriales() {
        return grupoMateriales;
    }

    public void setGrupoMateriales(String grupoMateriales) {
        this.grupoMateriales = grupoMateriales;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


}

