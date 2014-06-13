package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_hitos", schema = "dbo", catalog = "COBRANZA")
public class Hitos {
    private Integer systemId;
    private Integer linkDocumento;
    private Integer linkCliente;
    private Integer linkDocEtapa;
    private Integer linkUsuario;
    private Integer linkContacto;
    private Timestamp fechaHito;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_hitos", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_hitos"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_hitos")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @JoinColumn(name = "link_documento", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_documento")
    public Integer getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Integer linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @JoinColumn(name = "linnk_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_tipo_contig")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @JoinColumn(name = "link_tipo_contig", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_tipo_contig")
    public Integer getLinkDocEtapa() {
        return linkDocEtapa;
    }

    public void setLinkDocEtapa(Integer linkDocEtapa) {
        this.linkDocEtapa = linkDocEtapa;
    }

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_usuario")
    public Integer getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Integer linkUsuario) {
        this.linkUsuario = linkUsuario;
    }


    @JoinColumn(name = "link_contacto", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_contacto")



    public Integer getLinkContacto() {
        return linkContacto;
    }

    public void setLinkContacto(Integer linkContacto) {
        this.linkContacto = linkContacto;
    }

    @Basic
    @Column(name = "fecha_hito")
    public Timestamp getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Timestamp fechaHito) {
        this.fechaHito = fechaHito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hitos hitos = (Hitos) o;

        if (fechaHito != null ? !fechaHito.equals(hitos.fechaHito) : hitos.fechaHito != null) return false;
        if (linkCliente != null ? !linkCliente.equals(hitos.linkCliente) : hitos.linkCliente != null) return false;
        if (linkContacto != null ? !linkContacto.equals(hitos.linkContacto) : hitos.linkContacto != null) return false;
        if (linkDocEtapa != null ? !linkDocEtapa.equals(hitos.linkDocEtapa) : hitos.linkDocEtapa != null) return false;
        if (linkDocumento != null ? !linkDocumento.equals(hitos.linkDocumento) : hitos.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(hitos.linkUsuario) : hitos.linkUsuario != null) return false;
        if (systemId != null ? !systemId.equals(hitos.systemId) : hitos.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (linkDocEtapa != null ? linkDocEtapa.hashCode() : 0);
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        result = 31 * result + (linkContacto != null ? linkContacto.hashCode() : 0);
        result = 31 * result + (fechaHito != null ? fechaHito.hashCode() : 0);
        return result;
    }
}
