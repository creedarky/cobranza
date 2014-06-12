package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_sociedad_usuario", schema = "dbo", catalog = "COBRANZA")
public class SociedadUsuario {
    private Integer linkSociedad;
    private Integer linkUsuario;

    @Basic
    @Column(name = "link_sociedad")
    public Integer getLinkSociedad() {
        return linkSociedad;
    }

    public void setLinkSociedad(Integer linkSociedad) {
        this.linkSociedad = linkSociedad;
    }

    @Basic
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

        SociedadUsuario that = (SociedadUsuario) o;

        if (linkSociedad != null ? !linkSociedad.equals(that.linkSociedad) : that.linkSociedad != null) return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linkSociedad != null ? linkSociedad.hashCode() : 0;
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        return result;
    }
}
