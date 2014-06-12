package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_jefe_usuario", schema = "dbo", catalog = "COBRANZA")
public class JefeUsuario {
    private Integer systemId;
    private Integer linkUsuario;
    private Integer linkJefe;

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
    @Column(name = "link_jefe")
    public Integer getLinkJefe() {
        return linkJefe;
    }

    public void setLinkJefe(Integer linkJefe) {
        this.linkJefe = linkJefe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JefeUsuario that = (JefeUsuario) o;

        if (linkJefe != null ? !linkJefe.equals(that.linkJefe) : that.linkJefe != null) return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        result = 31 * result + (linkJefe != null ? linkJefe.hashCode() : 0);
        return result;
    }
}
