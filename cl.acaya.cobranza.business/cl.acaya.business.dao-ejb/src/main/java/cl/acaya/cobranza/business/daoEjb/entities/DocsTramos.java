package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.sql.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@javax.persistence.Table(name = "vw_docs_tramos", schema = "dbo", catalog = "COBRANZA")
public class DocsTramos {
    private Integer systemId;

    @Basic
    @javax.persistence.Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    private String numDoc;

    @Basic
    @javax.persistence.Column(name = "num_doc")
    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    private String numFact;

    @Basic
    @javax.persistence.Column(name = "num_fact")
    public String getNumFact() {
        return numFact;
    }

    public void setNumFact(String numFact) {
        this.numFact = numFact;
    }

    private String folioSii;

    @Basic
    @javax.persistence.Column(name = "folio_sii")
    public String getFolioSii() {
        return folioSii;
    }

    public void setFolioSii(String folioSii) {
        this.folioSii = folioSii;
    }

    private String numPedido;

    @Basic
    @javax.persistence.Column(name = "num_pedido")
    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    private Integer linkSociedad;

    @Basic
    @javax.persistence.Column(name = "link_sociedad")
    public Integer getLinkSociedad() {
        return linkSociedad;
    }

    public void setLinkSociedad(Integer linkSociedad) {
        this.linkSociedad = linkSociedad;
    }

    private Date fechaEmision;

    @Basic
    @javax.persistence.Column(name = "fecha_emision")
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    private Date fechaVencimiento;

    @Basic
    @javax.persistence.Column(name = "fecha_vencimiento")
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    private String docCompensacion;

    @Basic
    @javax.persistence.Column(name = "doc_compensacion")
    public String getDocCompensacion() {
        return docCompensacion;
    }

    public void setDocCompensacion(String docCompensacion) {
        this.docCompensacion = docCompensacion;
    }

    private Date fechaCompensacion;

    @Basic
    @javax.persistence.Column(name = "fecha_compensacion")
    public Date getFechaCompensacion() {
        return fechaCompensacion;
    }

    public void setFechaCompensacion(Date fechaCompensacion) {
        this.fechaCompensacion = fechaCompensacion;
    }

    private Integer monto;

    @Basic
    @javax.persistence.Column(name = "monto")
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    private Integer saldo;

    @Basic
    @javax.persistence.Column(name = "saldo")
    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    private Integer linkCondpago;

    @Basic
    @javax.persistence.Column(name = "link_condpago")
    public Integer getLinkCondpago() {
        return linkCondpago;
    }

    public void setLinkCondpago(Integer linkCondpago) {
        this.linkCondpago = linkCondpago;
    }

    private Boolean estadoDoc;

    @Basic
    @javax.persistence.Column(name = "estado_doc")
    public Boolean getEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(Boolean estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    private Integer linkTipoDoc;

    @Basic
    @javax.persistence.Column(name = "link_tipo_doc")
    public Integer getLinkTipoDoc() {
        return linkTipoDoc;
    }

    public void setLinkTipoDoc(Integer linkTipoDoc) {
        this.linkTipoDoc = linkTipoDoc;
    }

    private Integer linkDm;

    @Basic
    @javax.persistence.Column(name = "link_dm")
    public Integer getLinkDm() {
        return linkDm;
    }

    public void setLinkDm(Integer linkDm) {
        this.linkDm = linkDm;
    }

    private Integer linkSucursal;

    @Basic
    @javax.persistence.Column(name = "link_sucursal")
    public Integer getLinkSucursal() {
        return linkSucursal;
    }

    public void setLinkSucursal(Integer linkSucursal) {
        this.linkSucursal = linkSucursal;
    }

    private Integer linkVendedor;

    @Basic
    @javax.persistence.Column(name = "link_vendedor")
    public Integer getLinkVendedor() {
        return linkVendedor;
    }

    public void setLinkVendedor(Integer linkVendedor) {
        this.linkVendedor = linkVendedor;
    }

    private Integer linkDespacho;

    @Basic
    @javax.persistence.Column(name = "link_despacho")
    public Integer getLinkDespacho() {
        return linkDespacho;
    }

    public void setLinkDespacho(Integer linkDespacho) {
        this.linkDespacho = linkDespacho;
    }

    private Integer dias;

    @Basic
    @javax.persistence.Column(name = "dias")
    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    private Integer systramo;

    @Basic
    @javax.persistence.Column(name = "systramo")
    public Integer getSystramo() {
        return systramo;
    }

    public void setSystramo(Integer systramo) {
        this.systramo = systramo;
    }

    private String tramo;

    @Basic
    @javax.persistence.Column(name = "tramo")
    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocsTramos that = (DocsTramos) o;

        if (dias != null ? !dias.equals(that.dias) : that.dias != null) return false;
        if (docCompensacion != null ? !docCompensacion.equals(that.docCompensacion) : that.docCompensacion != null)
            return false;
        if (estadoDoc != null ? !estadoDoc.equals(that.estadoDoc) : that.estadoDoc != null) return false;
        if (fechaCompensacion != null ? !fechaCompensacion.equals(that.fechaCompensacion) : that.fechaCompensacion != null)
            return false;
        if (fechaEmision != null ? !fechaEmision.equals(that.fechaEmision) : that.fechaEmision != null) return false;
        if (fechaVencimiento != null ? !fechaVencimiento.equals(that.fechaVencimiento) : that.fechaVencimiento != null)
            return false;
        if (folioSii != null ? !folioSii.equals(that.folioSii) : that.folioSii != null) return false;
        if (linkCondpago != null ? !linkCondpago.equals(that.linkCondpago) : that.linkCondpago != null) return false;
        if (linkDespacho != null ? !linkDespacho.equals(that.linkDespacho) : that.linkDespacho != null) return false;
        if (linkDm != null ? !linkDm.equals(that.linkDm) : that.linkDm != null) return false;
        if (linkSociedad != null ? !linkSociedad.equals(that.linkSociedad) : that.linkSociedad != null) return false;
        if (linkSucursal != null ? !linkSucursal.equals(that.linkSucursal) : that.linkSucursal != null) return false;
        if (linkTipoDoc != null ? !linkTipoDoc.equals(that.linkTipoDoc) : that.linkTipoDoc != null) return false;
        if (linkVendedor != null ? !linkVendedor.equals(that.linkVendedor) : that.linkVendedor != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (numDoc != null ? !numDoc.equals(that.numDoc) : that.numDoc != null) return false;
        if (numFact != null ? !numFact.equals(that.numFact) : that.numFact != null) return false;
        if (numPedido != null ? !numPedido.equals(that.numPedido) : that.numPedido != null) return false;
        if (saldo != null ? !saldo.equals(that.saldo) : that.saldo != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (systramo != null ? !systramo.equals(that.systramo) : that.systramo != null) return false;
        if (tramo != null ? !tramo.equals(that.tramo) : that.tramo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (numDoc != null ? numDoc.hashCode() : 0);
        result = 31 * result + (numFact != null ? numFact.hashCode() : 0);
        result = 31 * result + (folioSii != null ? folioSii.hashCode() : 0);
        result = 31 * result + (numPedido != null ? numPedido.hashCode() : 0);
        result = 31 * result + (linkSociedad != null ? linkSociedad.hashCode() : 0);
        result = 31 * result + (fechaEmision != null ? fechaEmision.hashCode() : 0);
        result = 31 * result + (fechaVencimiento != null ? fechaVencimiento.hashCode() : 0);
        result = 31 * result + (docCompensacion != null ? docCompensacion.hashCode() : 0);
        result = 31 * result + (fechaCompensacion != null ? fechaCompensacion.hashCode() : 0);
        result = 31 * result + (monto != null ? monto.hashCode() : 0);
        result = 31 * result + (saldo != null ? saldo.hashCode() : 0);
        result = 31 * result + (linkCondpago != null ? linkCondpago.hashCode() : 0);
        result = 31 * result + (estadoDoc != null ? estadoDoc.hashCode() : 0);
        result = 31 * result + (linkTipoDoc != null ? linkTipoDoc.hashCode() : 0);
        result = 31 * result + (linkDm != null ? linkDm.hashCode() : 0);
        result = 31 * result + (linkSucursal != null ? linkSucursal.hashCode() : 0);
        result = 31 * result + (linkVendedor != null ? linkVendedor.hashCode() : 0);
        result = 31 * result + (linkDespacho != null ? linkDespacho.hashCode() : 0);
        result = 31 * result + (dias != null ? dias.hashCode() : 0);
        result = 31 * result + (systramo != null ? systramo.hashCode() : 0);
        result = 31 * result + (tramo != null ? tramo.hashCode() : 0);
        return result;
    }
}
