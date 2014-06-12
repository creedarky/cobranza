package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_banco", schema = "dbo", catalog = "COBRANZA")
public class TblBancoEntity {
    private Integer systemId;
    private String banco;
    private Integer linkComuna;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "banco")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Basic
    @Column(name = "link_comuna")
    public Integer getLinkComuna() {
        return linkComuna;
    }

    public void setLinkComuna(Integer linkComuna) {
        this.linkComuna = linkComuna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblBancoEntity that = (TblBancoEntity) o;

        if (banco != null ? !banco.equals(that.banco) : that.banco != null) return false;
        if (linkComuna != null ? !linkComuna.equals(that.linkComuna) : that.linkComuna != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (banco != null ? banco.hashCode() : 0);
        result = 31 * result + (linkComuna != null ? linkComuna.hashCode() : 0);
        return result;
    }
}
