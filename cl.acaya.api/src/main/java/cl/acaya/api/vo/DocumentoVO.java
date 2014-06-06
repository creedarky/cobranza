package cl.acaya.api.vo;

import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class DocumentoVO {

    private Long systemId;
    private String numeroDocumento;
    private String numeroFactura;
    private String folioSII;
    private String numeroPedido;
    private String documentoCompensacion;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private Date fechaCompensacion;
    private Integer montoDocumento;
    private Integer saldoDocumento;
    private boolean estadoDocumento;
    private Long despacho;


    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroFactura() { return numeroFactura; }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFolioSII() {
        return folioSII;
    }

    public void setFolioSII(String folioSII) {
        this.folioSII = folioSII;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getDocumentoCompensacion() {
        return documentoCompensacion;
    }

    public void setDocumentoCompensacion(String documentoCompensacion) {
        this.documentoCompensacion = documentoCompensacion;
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

    public Date getFechaCompensacion() {
        return fechaCompensacion;
    }

    public void setFechaCompensacion(Date fechaCompensacion) {
        this.fechaCompensacion = fechaCompensacion;
    }

    public Integer getMontoDocumento() {
        return montoDocumento;
    }

    public void setMontoDocumento(Integer montoDocumento) {
        this.montoDocumento = montoDocumento;
    }

    public Integer getSaldoDocumento() {
        return saldoDocumento;
    }

    public void setSaldoDocumento(Integer saldoDocumento) {
        this.saldoDocumento = saldoDocumento;
    }

    public boolean isEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(boolean estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public Long getDespacho() {
        return despacho;
    }

    public void setDespacho(Long despacho) {
        this.despacho = despacho;
    }

}
