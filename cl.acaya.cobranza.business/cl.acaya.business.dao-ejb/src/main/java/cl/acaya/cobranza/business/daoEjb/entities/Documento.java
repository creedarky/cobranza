package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_DOCUMENTO", schema = "dbo")
@NamedQueries({@NamedQuery(name="Documento.findAll",query = "Select cn From Documento cn"),
@NamedQuery(name="Documento.findByNumeroFactura",query = "from Documento where numeroFactura = :numeroFactura")})
public class Documento {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Documento", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
            @Parameter(name = "table_name", value = "hibernate_sequences"),
            @Parameter(name = "segment_value", value = "SEQ_Documento"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "SEQ_Documento")
    private Long systemId;

    @Column(name = "num_doc")
    private String numeroDocumento;

    @Column(name = "num_fact")
    private String numeroFactura;

    @Column(name = "folio_sii")
    private String folioSII;

    @Column(name = "num_pedido")
    private String numeroPedido;

    @Column(name = "doc_compensacion")
    private String documentoCompensacion;

    @JoinColumn(name = "link_sociedad", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Sociedad sociedad;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "fecha_vencimiento" )
    private Date fechaVencimiento;

    @Column(name = "fecha_compensacion")
    private Date fechaCompensacion;

    @Column(name = "monto")
    private Integer montoDocumento;

    @Column(name = "saldo")
    private Integer saldoDocumento;

    @Column(name = "estado_doc")
    private boolean estadoDocumento;

    @JoinColumn(name = "link_tipo_doc", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumento;


    @JoinColumn(name = "link_dm", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private DmCliente dmCliente;

    @JoinColumn(name = "link_sucursal", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursal;

    @JoinColumn(name = "link_vendedor", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    @Column(name = "link_despacho")
    private Long despacho;

    @Column(name = "factura_rel")
    private String facturaRelacionada;

    @Column(name = "validado")
    private Boolean validado;

    @Column(name = "fecha_validado")
    private Date fechaValidado;

    @Column(name =  "last_update")
    private Date lastUpdate;

    @ManyToMany(mappedBy="documentos")
    private Set<Agenda> agendas = new HashSet<Agenda>();

    @ManyToMany(mappedBy="documentos")
    private Set<Recauda> recaudaciones = new HashSet<Recauda>();


    public Documento(){

    }

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

    public String getNumeroFactura() {
        return numeroFactura;
    }

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

    public Sociedad getSociedad() {
        return sociedad;
    }

    public void setSociedad(Sociedad sociedad) {
        this.sociedad = sociedad;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public DmCliente getDmCliente() {
        return dmCliente;
    }

    public void setDmCliente(DmCliente dmCliente) {
        this.dmCliente = dmCliente;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Long getDespacho() {
        return despacho;
    }

    public void setDespacho(Long despacho) {
        this.despacho = despacho;
    }

    public String getFacturaRelacionada() {
        return facturaRelacionada;
    }

    public void setFacturaRelacionada(String facturaRelacionada) {
        this.facturaRelacionada = facturaRelacionada;
    }

    public Set<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(Set<Agenda> agendas) {
        this.agendas = agendas;
    }

    public Set<Recauda> getRecaudaciones() {
        return recaudaciones;
    }

    public void setRecaudaciones(Set<Recauda> recaudaciones) {
        this.recaudaciones = recaudaciones;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    public Date getFechaValidado() {
        return fechaValidado;
    }

    public void setFechaValidado(Date fechaValidada) {
        this.fechaValidado = fechaValidada;
    }
}
