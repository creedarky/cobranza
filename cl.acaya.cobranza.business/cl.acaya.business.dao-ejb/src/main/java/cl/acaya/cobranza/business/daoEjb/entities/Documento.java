package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_DOCUMENTO")
@NamedQueries({@NamedQuery(name="Documento.findAll",query = "Select cn From Documento cn")})
@SequenceGenerator(name = "DocumentoSeq",
        sequenceName = "SEQ_Documento", allocationSize = 1, initialValue = 1)


public class Documento {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DocumentoSeq")
    private Long systemId;

    @Column(name = "num_doc")
    private String numeroDocumento;

    @JoinColumn(name = "link_sociedad", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
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

    @Column(name = "seguro")
    private String seguroDocumento;

    @Column(name = "tipo_seguro")
    private String tipoSeguro;

    @Column(name = "monto_seguro")
    private Integer montoSeguro;

    @Column(name = "linea_credito")
    private Integer lineaCredito;

    @Column(name = "estado_doc")
    private boolean estadoDocumento;

    @JoinColumn(name = "link_tipo_doc", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private TipoDocumento tipoDocumento;

    @JoinColumn(name = "link_dm", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private DmCliente dmCliente;

    @JoinColumn(name = "link_sucursal", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Sucursal sucursal;

    @JoinColumn(name = "link_vendedor", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Vendedor vendedor;

    @Column(name = "link_despacho")
    private Long despacho;

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

    public String getSeguroDocumento() {
        return seguroDocumento;
    }

    public void setSeguroDocumento(String seguroDocumento) {
        this.seguroDocumento = seguroDocumento;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public Integer getMontoSeguro() {
        return montoSeguro;
    }

    public void setMontoSeguro(Integer montoSeguro) {
        this.montoSeguro = montoSeguro;
    }

    public Integer getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(Integer lineaCredito) {
        this.lineaCredito = lineaCredito;
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
}
