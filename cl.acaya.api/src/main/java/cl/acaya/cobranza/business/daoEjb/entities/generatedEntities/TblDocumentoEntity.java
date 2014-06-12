package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_documento", schema = "dbo", catalog = "COBRANZA")
public class TblDocumentoEntity {
    private Integer systemId;
    private String numDoc;
    private String numFact;
    private String folioSii;
    private String numPedido;
    private Integer linkSociedad;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String docCompensacion;
    private Date fechaCompensacion;
    private Integer monto;
    private Integer saldo;
    private Integer linkCondpago;
    private Boolean estadoDoc;
    private Boolean validado;
    private Date fechaValidado;
    private Integer linkUsuarioValida;
    private Boolean recaudado;
    private Date fechaRecauda;
    private Integer linkUsuarioRecauda;
    private String ultGestion;
    private Timestamp fecUltgest;
    private Integer linkUsuarioUltgest;
    private Integer linkTipoDoc;
    private Integer linkDm;
    private Integer linkSucursal;
    private Integer linkVendedor;
    private Integer linkDespacho;
    private Timestamp lastUpdate;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "num_doc")
    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    @Basic
    @Column(name = "num_fact")
    public String getNumFact() {
        return numFact;
    }

    public void setNumFact(String numFact) {
        this.numFact = numFact;
    }

    @Basic
    @Column(name = "folio_sii")
    public String getFolioSii() {
        return folioSii;
    }

    public void setFolioSii(String folioSii) {
        this.folioSii = folioSii;
    }

    @Basic
    @Column(name = "num_pedido")
    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    @Basic
    @Column(name = "link_sociedad")
    public Integer getLinkSociedad() {
        return linkSociedad;
    }

    public void setLinkSociedad(Integer linkSociedad) {
        this.linkSociedad = linkSociedad;
    }

    @Basic
    @Column(name = "fecha_emision")
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Basic
    @Column(name = "fecha_vencimiento")
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Basic
    @Column(name = "doc_compensacion")
    public String getDocCompensacion() {
        return docCompensacion;
    }

    public void setDocCompensacion(String docCompensacion) {
        this.docCompensacion = docCompensacion;
    }

    @Basic
    @Column(name = "fecha_compensacion")
    public Date getFechaCompensacion() {
        return fechaCompensacion;
    }

    public void setFechaCompensacion(Date fechaCompensacion) {
        this.fechaCompensacion = fechaCompensacion;
    }

    @Basic
    @Column(name = "monto")
    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "saldo")
    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Basic
    @Column(name = "link_condpago")
    public Integer getLinkCondpago() {
        return linkCondpago;
    }

    public void setLinkCondpago(Integer linkCondpago) {
        this.linkCondpago = linkCondpago;
    }

    @Basic
    @Column(name = "estado_doc")
    public Boolean getEstadoDoc() {
        return estadoDoc;
    }

    public void setEstadoDoc(Boolean estadoDoc) {
        this.estadoDoc = estadoDoc;
    }

    @Basic
    @Column(name = "validado")
    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @Basic
    @Column(name = "fecha_validado")
    public Date getFechaValidado() {
        return fechaValidado;
    }

    public void setFechaValidado(Date fechaValidado) {
        this.fechaValidado = fechaValidado;
    }

    @Basic
    @Column(name = "link_usuario_valida")
    public Integer getLinkUsuarioValida() {
        return linkUsuarioValida;
    }

    public void setLinkUsuarioValida(Integer linkUsuarioValida) {
        this.linkUsuarioValida = linkUsuarioValida;
    }

    @Basic
    @Column(name = "recaudado")
    public Boolean getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(Boolean recaudado) {
        this.recaudado = recaudado;
    }

    @Basic
    @Column(name = "fecha_recauda")
    public Date getFechaRecauda() {
        return fechaRecauda;
    }

    public void setFechaRecauda(Date fechaRecauda) {
        this.fechaRecauda = fechaRecauda;
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
    @Column(name = "ult_gestion")
    public String getUltGestion() {
        return ultGestion;
    }

    public void setUltGestion(String ultGestion) {
        this.ultGestion = ultGestion;
    }

    @Basic
    @Column(name = "fec_ultgest")
    public Timestamp getFecUltgest() {
        return fecUltgest;
    }

    public void setFecUltgest(Timestamp fecUltgest) {
        this.fecUltgest = fecUltgest;
    }

    @Basic
    @Column(name = "link_usuario_ultgest")
    public Integer getLinkUsuarioUltgest() {
        return linkUsuarioUltgest;
    }

    public void setLinkUsuarioUltgest(Integer linkUsuarioUltgest) {
        this.linkUsuarioUltgest = linkUsuarioUltgest;
    }

    @Basic
    @Column(name = "link_tipo_doc")
    public Integer getLinkTipoDoc() {
        return linkTipoDoc;
    }

    public void setLinkTipoDoc(Integer linkTipoDoc) {
        this.linkTipoDoc = linkTipoDoc;
    }

    @Basic
    @Column(name = "link_dm")
    public Integer getLinkDm() {
        return linkDm;
    }

    public void setLinkDm(Integer linkDm) {
        this.linkDm = linkDm;
    }

    @Basic
    @Column(name = "link_sucursal")
    public Integer getLinkSucursal() {
        return linkSucursal;
    }

    public void setLinkSucursal(Integer linkSucursal) {
        this.linkSucursal = linkSucursal;
    }

    @Basic
    @Column(name = "link_vendedor")
    public Integer getLinkVendedor() {
        return linkVendedor;
    }

    public void setLinkVendedor(Integer linkVendedor) {
        this.linkVendedor = linkVendedor;
    }

    @Basic
    @Column(name = "link_despacho")
    public Integer getLinkDespacho() {
        return linkDespacho;
    }

    public void setLinkDespacho(Integer linkDespacho) {
        this.linkDespacho = linkDespacho;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblDocumentoEntity that = (TblDocumentoEntity) o;

        if (docCompensacion != null ? !docCompensacion.equals(that.docCompensacion) : that.docCompensacion != null)
            return false;
        if (estadoDoc != null ? !estadoDoc.equals(that.estadoDoc) : that.estadoDoc != null) return false;
        if (fecUltgest != null ? !fecUltgest.equals(that.fecUltgest) : that.fecUltgest != null) return false;
        if (fechaCompensacion != null ? !fechaCompensacion.equals(that.fechaCompensacion) : that.fechaCompensacion != null)
            return false;
        if (fechaEmision != null ? !fechaEmision.equals(that.fechaEmision) : that.fechaEmision != null) return false;
        if (fechaRecauda != null ? !fechaRecauda.equals(that.fechaRecauda) : that.fechaRecauda != null) return false;
        if (fechaValidado != null ? !fechaValidado.equals(that.fechaValidado) : that.fechaValidado != null)
            return false;
        if (fechaVencimiento != null ? !fechaVencimiento.equals(that.fechaVencimiento) : that.fechaVencimiento != null)
            return false;
        if (folioSii != null ? !folioSii.equals(that.folioSii) : that.folioSii != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null) return false;
        if (linkCondpago != null ? !linkCondpago.equals(that.linkCondpago) : that.linkCondpago != null) return false;
        if (linkDespacho != null ? !linkDespacho.equals(that.linkDespacho) : that.linkDespacho != null) return false;
        if (linkDm != null ? !linkDm.equals(that.linkDm) : that.linkDm != null) return false;
        if (linkSociedad != null ? !linkSociedad.equals(that.linkSociedad) : that.linkSociedad != null) return false;
        if (linkSucursal != null ? !linkSucursal.equals(that.linkSucursal) : that.linkSucursal != null) return false;
        if (linkTipoDoc != null ? !linkTipoDoc.equals(that.linkTipoDoc) : that.linkTipoDoc != null) return false;
        if (linkUsuarioRecauda != null ? !linkUsuarioRecauda.equals(that.linkUsuarioRecauda) : that.linkUsuarioRecauda != null)
            return false;
        if (linkUsuarioUltgest != null ? !linkUsuarioUltgest.equals(that.linkUsuarioUltgest) : that.linkUsuarioUltgest != null)
            return false;
        if (linkUsuarioValida != null ? !linkUsuarioValida.equals(that.linkUsuarioValida) : that.linkUsuarioValida != null)
            return false;
        if (linkVendedor != null ? !linkVendedor.equals(that.linkVendedor) : that.linkVendedor != null) return false;
        if (monto != null ? !monto.equals(that.monto) : that.monto != null) return false;
        if (numDoc != null ? !numDoc.equals(that.numDoc) : that.numDoc != null) return false;
        if (numFact != null ? !numFact.equals(that.numFact) : that.numFact != null) return false;
        if (numPedido != null ? !numPedido.equals(that.numPedido) : that.numPedido != null) return false;
        if (recaudado != null ? !recaudado.equals(that.recaudado) : that.recaudado != null) return false;
        if (saldo != null ? !saldo.equals(that.saldo) : that.saldo != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (ultGestion != null ? !ultGestion.equals(that.ultGestion) : that.ultGestion != null) return false;
        if (validado != null ? !validado.equals(that.validado) : that.validado != null) return false;

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
        result = 31 * result + (validado != null ? validado.hashCode() : 0);
        result = 31 * result + (fechaValidado != null ? fechaValidado.hashCode() : 0);
        result = 31 * result + (linkUsuarioValida != null ? linkUsuarioValida.hashCode() : 0);
        result = 31 * result + (recaudado != null ? recaudado.hashCode() : 0);
        result = 31 * result + (fechaRecauda != null ? fechaRecauda.hashCode() : 0);
        result = 31 * result + (linkUsuarioRecauda != null ? linkUsuarioRecauda.hashCode() : 0);
        result = 31 * result + (ultGestion != null ? ultGestion.hashCode() : 0);
        result = 31 * result + (fecUltgest != null ? fecUltgest.hashCode() : 0);
        result = 31 * result + (linkUsuarioUltgest != null ? linkUsuarioUltgest.hashCode() : 0);
        result = 31 * result + (linkTipoDoc != null ? linkTipoDoc.hashCode() : 0);
        result = 31 * result + (linkDm != null ? linkDm.hashCode() : 0);
        result = 31 * result + (linkSucursal != null ? linkSucursal.hashCode() : 0);
        result = 31 * result + (linkVendedor != null ? linkVendedor.hashCode() : 0);
        result = 31 * result + (linkDespacho != null ? linkDespacho.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
