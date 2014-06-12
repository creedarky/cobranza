package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_sociedad", schema = "dbo", catalog = "COBRANZA")
public class TblSociedadEntity {
    private Integer systemId;
    private String codSociedad;
    private String nomSociedad;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "cod_sociedad")
    public String getCodSociedad() {
        return codSociedad;
    }

    public void setCodSociedad(String codSociedad) {
        this.codSociedad = codSociedad;
    }

    @Basic
    @Column(name = "nom_sociedad")
    public String getNomSociedad() {
        return nomSociedad;
    }

    public void setNomSociedad(String nomSociedad) {
        this.nomSociedad = nomSociedad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSociedadEntity that = (TblSociedadEntity) o;

        if (codSociedad != null ? !codSociedad.equals(that.codSociedad) : that.codSociedad != null) return false;
        if (nomSociedad != null ? !nomSociedad.equals(that.nomSociedad) : that.nomSociedad != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (codSociedad != null ? codSociedad.hashCode() : 0);
        result = 31 * result + (nomSociedad != null ? nomSociedad.hashCode() : 0);
        return result;
    }
}
