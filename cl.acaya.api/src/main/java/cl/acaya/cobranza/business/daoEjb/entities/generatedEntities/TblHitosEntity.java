package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_hitos", schema = "dbo", catalog = "COBRANZA")
public class TblHitosEntity {
    private Integer systemId;
    private Integer linkDocumento;
    private Integer linkCliente;
    private Integer linkDocEtapa;
    private Integer linkUsuario;
    private Integer linkContacto;
    private Timestamp fechaHito;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "link_documento")
    public Integer getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Integer linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @Basic
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Basic
    @Column(name = "link_doc_etapa")
    public Integer getLinkDocEtapa() {
        return linkDocEtapa;
    }

    public void setLinkDocEtapa(Integer linkDocEtapa) {
        this.linkDocEtapa = linkDocEtapa;
    }

    @Basic
    @Column(name = "link_usuario")
    public Integer getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Integer linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    @Basic
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

        TblHitosEntity that = (TblHitosEntity) o;

        if (fechaHito != null ? !fechaHito.equals(that.fechaHito) : that.fechaHito != null) return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkContacto != null ? !linkContacto.equals(that.linkContacto) : that.linkContacto != null) return false;
        if (linkDocEtapa != null ? !linkDocEtapa.equals(that.linkDocEtapa) : that.linkDocEtapa != null) return false;
        if (linkDocumento != null ? !linkDocumento.equals(that.linkDocumento) : that.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

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
