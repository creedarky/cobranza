package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_zona", schema = "dbo", catalog = "COBRANZA")
public class TblZonaEntity {
    private Integer systemId;
    private String codZona;
    private String nomZona;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "cod_zona")
    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    @Basic
    @Column(name = "nom_zona")
    public String getNomZona() {
        return nomZona;
    }

    public void setNomZona(String nomZona) {
        this.nomZona = nomZona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblZonaEntity that = (TblZonaEntity) o;

        if (codZona != null ? !codZona.equals(that.codZona) : that.codZona != null) return false;
        if (nomZona != null ? !nomZona.equals(that.nomZona) : that.nomZona != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (codZona != null ? codZona.hashCode() : 0);
        result = 31 * result + (nomZona != null ? nomZona.hashCode() : 0);
        return result;
    }
}
