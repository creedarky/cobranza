package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_agenda", schema = "dbo", catalog = "COBRANZA")
public class Agenda {
    private Integer systemId;
    private Integer linkUsuario;
    private Date fecAgenda;
    private Integer linkDocumento;
    private Integer linkCliente;
    private Integer linkContacto;
    private Boolean realizada;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
    @Column(name = "fec_agenda")
    public Date getFecAgenda() {
        return fecAgenda;
    }

    public void setFecAgenda(Date fecAgenda) {
        this.fecAgenda = fecAgenda;
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
    @Column(name = "link_contacto")
    public Integer getLinkContacto() {
        return linkContacto;
    }

    public void setLinkContacto(Integer linkContacto) {
        this.linkContacto = linkContacto;
    }

    @Basic
    @Column(name = "realizada")
    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agenda agenda = (Agenda) o;

        if (fecAgenda != null ? !fecAgenda.equals(agenda.fecAgenda) : agenda.fecAgenda != null) return false;
        if (linkCliente != null ? !linkCliente.equals(agenda.linkCliente) : agenda.linkCliente != null) return false;
        if (linkContacto != null ? !linkContacto.equals(agenda.linkContacto) : agenda.linkContacto != null)
            return false;
        if (linkDocumento != null ? !linkDocumento.equals(agenda.linkDocumento) : agenda.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(agenda.linkUsuario) : agenda.linkUsuario != null) return false;
        if (realizada != null ? !realizada.equals(agenda.realizada) : agenda.realizada != null) return false;
        if (systemId != null ? !systemId.equals(agenda.systemId) : agenda.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        result = 31 * result + (fecAgenda != null ? fecAgenda.hashCode() : 0);
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (linkContacto != null ? linkContacto.hashCode() : 0);
        result = 31 * result + (realizada != null ? realizada.hashCode() : 0);
        return result;
    }
}
