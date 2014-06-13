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
    private Documento Documento;
    private Cliente cliente;
    private String comentario;
    private Usuario usuario;

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
    @ManyToOne(fetch = FetchType.LAZY)
    public Documento getDocumento() {
        return Documento;
    }

    public void setDocumento(Documento linkDocumento) {
        this.Documento = linkDocumento;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente linkCliente) {
        this.cliente = linkCliente;
    }

    @Basic
    @Column(name = "comentario")
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bitacora bitacora = (Bitacora) o;

        if (comentario != null ? !comentario.equals(bitacora.comentario) : bitacora.comentario != null) return false;
        if (fechaComent != null ? !fechaComent.equals(bitacora.fechaComent) : bitacora.fechaComent != null)
            return false;
        if (cliente != null ? !cliente.equals(bitacora.cliente) : bitacora.cliente != null)
            return false;
        if (Documento != null ? !Documento.equals(bitacora.Documento) : bitacora.Documento != null)
            return false;
        if (usuario != null ? !usuario.equals(bitacora.usuario) : bitacora.usuario != null)
            return false;
        if (systemId != null ? !systemId.equals(bitacora.systemId) : bitacora.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (fechaComent != null ? fechaComent.hashCode() : 0);
        result = 31 * result + (Documento != null ? Documento.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (comentario != null ? comentario.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
