package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_bitacora", schema = "dbo", catalog = "COBRANZA")
public class Bitacora {
    private Integer systemId;
    private Timestamp fechaComent;
    private Integer linkDocumento;
    private Integer linkCliente;
    private String comentario;
    private Integer linkUsuario;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_bitacora", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_bitacora"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_bitacora")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "fecha_coment")
    public Timestamp getFechaComent() {
        return fechaComent;
    }

    public void setFechaComent(Timestamp fechaComent) {
        this.fechaComent = fechaComent;
    }

    @JoinColumn(name = "link_documento", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    public Integer getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Integer linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Basic
    @Column(name = "comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @JoinColumn(name = "cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_usuario")
    public Integer getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Integer linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bitacora bitacora = (Bitacora) o;

        if (comentario != null ? !comentario.equals(bitacora.comentario) : bitacora.comentario != null) return false;
        if (fechaComent != null ? !fechaComent.equals(bitacora.fechaComent) : bitacora.fechaComent != null)
            return false;
        if (linkCliente != null ? !linkCliente.equals(bitacora.linkCliente) : bitacora.linkCliente != null)
            return false;
        if (linkDocumento != null ? !linkDocumento.equals(bitacora.linkDocumento) : bitacora.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(bitacora.linkUsuario) : bitacora.linkUsuario != null)
            return false;
        if (systemId != null ? !systemId.equals(bitacora.systemId) : bitacora.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (fechaComent != null ? fechaComent.hashCode() : 0);
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        return result;
    }
}
