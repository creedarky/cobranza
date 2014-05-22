/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.acaya.api.vo;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author aruizp
 */
public class DocumentoVO implements Cloneable {
    private String codigoSociedad;
    private String codigoCliente;
    private String codigoOperacion;
    private String indicacionOperacion;
    private Date fechaCompensacion;
    private String numeroDocumento;
    private String numeroAsignacion;
    private Integer numeroEjercicio;
    private String numeroContable;
    private Integer numeroApunte;
    private String rutCliente;
    private Date fechaCotizacion;
    private Date fechaDocumento;
    private String claseDocumento;
    private Double montoCobrar;
    private String indicadorSentencia;
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

    public DocumentoVO() {
    }


    public DocumentoVO(String codigoSociedad, String codigoCliente, String codigoOperacion, String indicacionOperacion, Date fechaCompensacion, String numeroDocumento, String numeroAsignacion, Integer numeroEjercicio, String numeroContable, Integer numeroApunte, String rutCliente, Date fechaCotizacion, Date fechaDocumento, String claseDocumento, Double montoCobrar, String indicadorSentencia, Date fechaVencimiento, String nombreResponsable, String oficinaResponsable, String numeroFactura, String folioSii, String clavePago, Integer codigoCobrador, String grupoMateriales, String ordenCompra, String codigoCuenta) {
        this.codigoSociedad = codigoSociedad;
        this.codigoCliente = codigoCliente;
        this.codigoOperacion = codigoOperacion;
        this.indicacionOperacion = indicacionOperacion;
        this.fechaCompensacion = fechaCompensacion;
        this.numeroDocumento = numeroDocumento;
        this.numeroAsignacion = numeroAsignacion;
        this.numeroEjercicio = numeroEjercicio;
        this.numeroContable = numeroContable;
        this.numeroApunte = numeroApunte;
        this.rutCliente = rutCliente;
        this.fechaCotizacion = fechaCotizacion;
        this.fechaDocumento = fechaDocumento;
        this.claseDocumento = claseDocumento;
        this.montoCobrar = montoCobrar;
        this.indicadorSentencia = indicadorSentencia;
        this.fechaVencimiento = fechaVencimiento;
        this.nombreResponsable = nombreResponsable;
        this.oficinaResponsable = oficinaResponsable;
        this.numeroFactura = numeroFactura;
        this.folioSii = folioSii;
        this.clavePago = clavePago;
        this.codigoCobrador = codigoCobrador;
        this.grupoMateriales = grupoMateriales;
        this.ordenCompra = ordenCompra;
        this.codigoCuenta = codigoCuenta;
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

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
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

    public Double getMontoCobrar() {
        return montoCobrar;
    }

    public void setMontoCobrar(Double montoCobrar) {
        this.montoCobrar = montoCobrar;
    }

    public String getIndicadorSentencia() {
        return indicadorSentencia;
    }

    public void setIndicadorSentencia(String indicadorSentencia) {
        this.indicadorSentencia = indicadorSentencia;
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


}

