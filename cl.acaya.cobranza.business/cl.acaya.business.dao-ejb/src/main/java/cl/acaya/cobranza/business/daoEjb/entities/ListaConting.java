package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_lista_conting", schema = "dbo", catalog = "COBRANZA")
public class ListaConting {
    private Integer systemId;
    private Documento linkDocumento;
    private Cliente linkCliente;
    private Contingencia linkContingencia;
    private Date fecha;
    private Boolean revisada;
    private Date fechaRevision;
    private Usuario linkUsuario;

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
    @ManyToOne
    public Documento getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Documento linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    public Cliente getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Cliente linkCliente) {
        this.linkCliente = linkCliente;
    }

    @JoinColumn(name = "link_contingencia", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    public Contingencia getLinkContingencia() {
        return linkContingencia;
    }

    public void setLinkContingencia(Contingencia linkContingencia) {
        this.linkContingencia = linkContingencia;
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
    @ManyToOne

    public Usuario getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Usuario linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaConting that = (ListaConting) o;

        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (fechaRevision != null ? !fechaRevision.equals(that.fechaRevision) : that.fechaRevision != null)
            return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkContingencia != null ? !linkContingencia.equals(that.linkContingencia) : that.linkContingencia != null)
            return false;
        if (linkDocumento != null ? !linkDocumento.equals(that.linkDocumento) : that.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;
        if (revisada != null ? !revisada.equals(that.revisada) : that.revisada != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (linkContingencia != null ? linkContingencia.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (revisada != null ? revisada.hashCode() : 0);
        result = 31 * result + (fechaRevision != null ? fechaRevision.hashCode() : 0);
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        return result;
    }
}
