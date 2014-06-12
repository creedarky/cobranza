package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_vendedor", schema = "dbo", catalog = "COBRANZA")
public class TblVendedorEntity {
    private Integer systemId;
    private String codVendedor;
    private String nomVendedor;
    private String email;
    private String fonoVend1;
    private String fonoVend2;
    private String fonoVend3;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "cod_vendedor")
    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    @Basic
    @Column(name = "nom_vendedor")
    public String getNomVendedor() {
        return nomVendedor;
    }

    public void setNomVendedor(String nomVendedor) {
        this.nomVendedor = nomVendedor;
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
    @Column(name = "fono_vend1")
    public String getFonoVend1() {
        return fonoVend1;
    }

    public void setFonoVend1(String fonoVend1) {
        this.fonoVend1 = fonoVend1;
    }

    @Basic
    @Column(name = "fono_vend2")
    public String getFonoVend2() {
        return fonoVend2;
    }

    public void setFonoVend2(String fonoVend2) {
        this.fonoVend2 = fonoVend2;
    }

    @Basic
    @Column(name = "fono_vend3")
    public String getFonoVend3() {
        return fonoVend3;
    }

    public void setFonoVend3(String fonoVend3) {
        this.fonoVend3 = fonoVend3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblVendedorEntity that = (TblVendedorEntity) o;

        if (codVendedor != null ? !codVendedor.equals(that.codVendedor) : that.codVendedor != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (fonoVend1 != null ? !fonoVend1.equals(that.fonoVend1) : that.fonoVend1 != null) return false;
        if (fonoVend2 != null ? !fonoVend2.equals(that.fonoVend2) : that.fonoVend2 != null) return false;
        if (fonoVend3 != null ? !fonoVend3.equals(that.fonoVend3) : that.fonoVend3 != null) return false;
        if (nomVendedor != null ? !nomVendedor.equals(that.nomVendedor) : that.nomVendedor != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (codVendedor != null ? codVendedor.hashCode() : 0);
        result = 31 * result + (nomVendedor != null ? nomVendedor.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fonoVend1 != null ? fonoVend1.hashCode() : 0);
        result = 31 * result + (fonoVend2 != null ? fonoVend2.hashCode() : 0);
        result = 31 * result + (fonoVend3 != null ? fonoVend3.hashCode() : 0);
        return result;
    }
}
