package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@javax.persistence.Table(name = "tbl_recauda", schema = "dbo", catalog = "COBRANZA")
public class Recauda {
    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_recauda", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_recauda"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_recauda")
    private Integer systemId;

    @JoinColumn(name = "link_formapago", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private FormaPago formaPago;

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Cliente cliente;

    private String direccion;

    @Column(name = "link_comuna")
    private Integer linkComuna;

    private Boolean entregaCedible;

    @JoinColumn(name = "link_usuario_recauda", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "link_banco", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Banco banco;

    @Column(name = "fec_pago")
    private Date fecPago;


    @Column(name = "horario_pago")
    private String horarioPago;

    @JoinColumn(name = "link_sucursal_kup", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Sucursal sucursalKupfer;

    @JoinColumn(name = "link_sucursal_cli", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Sucursal sucursalCliente;

    @JoinColumn(name = "link_contacto", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private ContactoCliente contactoCliente;

    @Column(name = "pago_lun")
    private Boolean pagoLun;

    @Column(name = "pago_mar")
    private Boolean pagoMar;

    @Column(name = "pago_mie")
    private Boolean pagoMie;

    @Column(name = "pago_jue")
    private Boolean pagoJue;

    @Column(name = "pago_vie")
    private Boolean pagoVie;

    @Column(name = "validada")
    private Boolean validada;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="tbl_recauda_doc",
            joinColumns={@JoinColumn(name="link_recauda")},
            inverseJoinColumns={@JoinColumn(name="link_documento")})
    private Set<Documento> documentos = new HashSet<Documento>();

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getLinkComuna() {
        return linkComuna;
    }

    public void setLinkComuna(Integer linkComuna) {
        this.linkComuna = linkComuna;
    }

    public Boolean getEntregaCedible() {
        return entregaCedible;
    }

    public void setEntregaCedible(Boolean entregaCedible) {
        this.entregaCedible = entregaCedible;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    public String getHorarioPago() {
        return horarioPago;
    }

    public void setHorarioPago(String horarioPago) {
        this.horarioPago = horarioPago;
    }

    public Sucursal getSucursalKupfer() {
        return sucursalKupfer;
    }

    public void setSucursalKupfer(Sucursal sucursalKupfer) {
        this.sucursalKupfer = sucursalKupfer;
    }

    public Sucursal getSucursalCliente() {
        return sucursalCliente;
    }

    public void setSucursalCliente(Sucursal sucursalCliente) {
        this.sucursalCliente = sucursalCliente;
    }

    public ContactoCliente getContactoCliente() {
        return contactoCliente;
    }

    public void setContactoCliente(ContactoCliente contactoCliente) {
        this.contactoCliente = contactoCliente;
    }

    public Boolean getPagoLun() {
        return pagoLun;
    }

    public void setPagoLun(Boolean pagoLun) {
        this.pagoLun = pagoLun;
    }

    public Boolean getPagoMar() {
        return pagoMar;
    }

    public void setPagoMar(Boolean pagoMar) {
        this.pagoMar = pagoMar;
    }

    public Boolean getPagoMie() {
        return pagoMie;
    }

    public void setPagoMie(Boolean pagoMie) {
        this.pagoMie = pagoMie;
    }

    public Boolean getPagoJue() {
        return pagoJue;
    }

    public void setPagoJue(Boolean pagoJue) {
        this.pagoJue = pagoJue;
    }

    public Boolean getPagoVie() {
        return pagoVie;
    }

    public void setPagoVie(Boolean pagoVie) {
        this.pagoVie = pagoVie;
    }

    public Boolean getValidada() {
        return validada;
    }

    public void setValidada(Boolean validada) {
        this.validada = validada;
    }

    public Set<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }
}
