package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_usuario", schema = "dbo", catalog = "COBRANZA")
public class TblUsuarioEntity {
    private Integer systemId;
    private String nomUsuario;
    private String nomCompleto;
    private String passw;
    private String email;
    private Integer linkCargo;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "nom_usuario")
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    @Basic
    @Column(name = "nom_completo")
    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    @Basic
    @Column(name = "passw")
    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "link_cargo")
    public Integer getLinkCargo() {
        return linkCargo;
    }

    public void setLinkCargo(Integer linkCargo) {
        this.linkCargo = linkCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblUsuarioEntity that = (TblUsuarioEntity) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (linkCargo != null ? !linkCargo.equals(that.linkCargo) : that.linkCargo != null) return false;
        if (nomCompleto != null ? !nomCompleto.equals(that.nomCompleto) : that.nomCompleto != null) return false;
        if (nomUsuario != null ? !nomUsuario.equals(that.nomUsuario) : that.nomUsuario != null) return false;
        if (passw != null ? !passw.equals(that.passw) : that.passw != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (nomUsuario != null ? nomUsuario.hashCode() : 0);
        result = 31 * result + (nomCompleto != null ? nomCompleto.hashCode() : 0);
        result = 31 * result + (passw != null ? passw.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (linkCargo != null ? linkCargo.hashCode() : 0);
        return result;
    }
}
