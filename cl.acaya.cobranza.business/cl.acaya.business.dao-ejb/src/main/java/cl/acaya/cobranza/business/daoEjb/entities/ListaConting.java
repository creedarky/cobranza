package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_lista_conting", schema = "dbo", catalog = "COBRANZA")
public class ListaConting {
    private Integer systemId;
    private Documento documento;
    private Cliente cliente;
    private Contingencia contingencia;
    private Date fecha;
    private Boolean revisada;
    private Date fechaRevision;
    private Usuario usuario;
    private String observacion;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_listaConting", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_listaConting"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_listaConting")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @JoinColumn(name = "link_documento", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento linkDocumento) {
        this.documento = linkDocumento;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente linkCliente) {
        this.cliente = linkCliente;
    }

    @JoinColumn(name = "link_contingencia", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Contingencia getContingencia() {
        return contingencia;
    }

    public void setContingencia(Contingencia linkContingencia) {
        this.contingencia = linkContingencia;
    }

    @Basic
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "revisada")
    public Boolean getRevisada() {
        return revisada;
    }

    public void setRevisada(Boolean revisada) {
        this.revisada = revisada;
    }

    @Basic
    @Column(name = "fecha_revision")
    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario linkUsuario) {
        this.usuario = linkUsuario;
    }

    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaConting that = (ListaConting) o;

        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (fechaRevision != null ? !fechaRevision.equals(that.fechaRevision) : that.fechaRevision != null)
            return false;
        if (cliente != null ? !cliente.equals(that.cliente) : that.cliente != null) return false;
        if (contingencia != null ? !contingencia.equals(that.contingencia) : that.contingencia != null)
            return false;
        if (documento != null ? !documento.equals(that.documento) : that.documento != null)
            return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (revisada != null ? !revisada.equals(that.revisada) : that.revisada != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (contingencia != null ? contingencia.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (revisada != null ? revisada.hashCode() : 0);
        result = 31 * result + (fechaRevision != null ? fechaRevision.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
