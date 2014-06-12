package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_tipo_documento", schema = "dbo", catalog = "COBRANZA")
public class TblTipoDocumentoEntity {
    private Integer systemId;
    private String codTipo;
    private String nomTipo;
    private String ind;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "cod_tipo")
    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
    }

    @Basic
    @Column(name = "nom_tipo")
    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    @Basic
    @Column(name = "ind")
    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblTipoDocumentoEntity that = (TblTipoDocumentoEntity) o;

        if (codTipo != null ? !codTipo.equals(that.codTipo) : that.codTipo != null) return false;
        if (ind != null ? !ind.equals(that.ind) : that.ind != null) return false;
        if (nomTipo != null ? !nomTipo.equals(that.nomTipo) : that.nomTipo != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (codTipo != null ? codTipo.hashCode() : 0);
        result = 31 * result + (nomTipo != null ? nomTipo.hashCode() : 0);
        result = 31 * result + (ind != null ? ind.hashCode() : 0);
        return result;
    }
}
