package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_contacto_cliente", schema = "dbo", catalog = "COBRANZA")
public class TblContactoClienteEntity {
    private Integer systemId;
    private String nomContacto;
    private String emailContacto;
    private String fonoContacto1;
    private String fonoContacto2;
    private String fonoContacto3;
    private Integer linkCargo;
    private Integer linkCliente;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "nom_contacto")
    public String getNomContacto() {
        return nomContacto;
    }

    public void setNomContacto(String nomContacto) {
        this.nomContacto = nomContacto;
    }

    @Basic
    @Column(name = "email_contacto")
    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    @Basic
    @Column(name = "fono_contacto1")
    public String getFonoContacto1() {
        return fonoContacto1;
    }

    public void setFonoContacto1(String fonoContacto1) {
        this.fonoContacto1 = fonoContacto1;
    }

    @Basic
    @Column(name = "fono_contacto2")
    public String getFonoContacto2() {
        return fonoContacto2;
    }

    public void setFonoContacto2(String fonoContacto2) {
        this.fonoContacto2 = fonoContacto2;
    }

    @Basic
    @Column(name = "fono_contacto3")
    public String getFonoContacto3() {
        return fonoContacto3;
    }

    public void setFonoContacto3(String fonoContacto3) {
        this.fonoContacto3 = fonoContacto3;
    }

    @Basic
    @Column(name = "link_cargo")
    public Integer getLinkCargo() {
        return linkCargo;
    }

    public void setLinkCargo(Integer linkCargo) {
        this.linkCargo = linkCargo;
    }

    @Basic
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblContactoClienteEntity that = (TblContactoClienteEntity) o;

        if (emailContacto != null ? !emailContacto.equals(that.emailContacto) : that.emailContacto != null)
            return false;
        if (fonoContacto1 != null ? !fonoContacto1.equals(that.fonoContacto1) : that.fonoContacto1 != null)
            return false;
        if (fonoContacto2 != null ? !fonoContacto2.equals(that.fonoContacto2) : that.fonoContacto2 != null)
            return false;
        if (fonoContacto3 != null ? !fonoContacto3.equals(that.fonoContacto3) : that.fonoContacto3 != null)
            return false;
        if (linkCargo != null ? !linkCargo.equals(that.linkCargo) : that.linkCargo != null) return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (nomContacto != null ? !nomContacto.equals(that.nomContacto) : that.nomContacto != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (nomContacto != null ? nomContacto.hashCode() : 0);
        result = 31 * result + (emailContacto != null ? emailContacto.hashCode() : 0);
        result = 31 * result + (fonoContacto1 != null ? fonoContacto1.hashCode() : 0);
        result = 31 * result + (fonoContacto2 != null ? fonoContacto2.hashCode() : 0);
        result = 31 * result + (fonoContacto3 != null ? fonoContacto3.hashCode() : 0);
        result = 31 * result + (linkCargo != null ? linkCargo.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        return result;
    }
}
