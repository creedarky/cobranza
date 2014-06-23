package cl.acaya.api.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mcastro on 05-06-14.
 */
public class DocumentoClienteVO {

    private Long idDocumento;
    private String razonSocial;
    private String rut;
    private String tramo;
    private Integer diasVencidos;
    private BigDecimal monto;
    private String numDoc;
    private String vendedor;
    private String codigoTipo;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String tipoDocumento;
    private String indicadorSentido;
    private String observacion;
    private String urlAcepta;
    private String serviEntrega;
    private Date fechaQR;
    private Long idDM;
    private String DM;
    private String estado;
    private Date ultimaGestion;

    public DocumentoClienteVO() {
        observacion = "";
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public Integer getDiasVencidos() {
        return diasVencidos;
    }

    public void setDiasVencidos(Integer diasVencidos) {
        this.diasVencidos = diasVencidos;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getIndicadorSentido() {
        return indicadorSentido;
    }

    public void setIndicadorSentido(String indicadorSentido) {
        this.indicadorSentido = indicadorSentido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUrlAcepta() {
        return urlAcepta;
    }

    public void setUrlAcepta(String urlAcepta) {
        this.urlAcepta = urlAcepta;
    }

    public String getServiEntrega() {
        return serviEntrega;
    }

    public void setServiEntrega(String serviEntrega) {
        this.serviEntrega = serviEntrega;
    }

    public Date getFechaQR() {
        return fechaQR;
    }

    public void setFechaQR(Date fechaQR) {
        this.fechaQR = fechaQR;
    }

    public void setIdDM(Long idDM) {
        this.idDM = idDM;
    }

    public Long getIdDM() {
        return idDM;
    }

    public void setDM(String DM) {
        this.DM = DM;
    }

    public String getDM() {
        return DM;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setUltimaGestion(Date ultimaGestion) {
        this.ultimaGestion = ultimaGestion;
    }

    public Date getUltimaGestion() {
        return ultimaGestion;
    }
}
