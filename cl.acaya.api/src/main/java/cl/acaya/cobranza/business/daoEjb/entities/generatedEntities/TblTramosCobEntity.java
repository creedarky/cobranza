package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_tramos_cob", schema = "dbo", catalog = "COBRANZA")
public class TblTramosCobEntity {
    private Integer systemId;
    private String nomTramo;
    private Integer diasIni;
    private Integer diasFin;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "nom_tramo")
    public String getNomTramo() {
        return nomTramo;
    }

    public void setNomTramo(String nomTramo) {
        this.nomTramo = nomTramo;
    }

    @Basic
    @Column(name = "dias_ini")
    public Integer getDiasIni() {
        return diasIni;
    }

    public void setDiasIni(Integer diasIni) {
        this.diasIni = diasIni;
    }

    @Basic
    @Column(name = "dias_fin")
    public Integer getDiasFin() {
        return diasFin;
    }

    public void setDiasFin(Integer diasFin) {
        this.diasFin = diasFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblTramosCobEntity that = (TblTramosCobEntity) o;

        if (diasFin != null ? !diasFin.equals(that.diasFin) : that.diasFin != null) return false;
        if (diasIni != null ? !diasIni.equals(that.diasIni) : that.diasIni != null) return false;
        if (nomTramo != null ? !nomTramo.equals(that.nomTramo) : that.nomTramo != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (nomTramo != null ? nomTramo.hashCode() : 0);
        result = 31 * result + (diasIni != null ? diasIni.hashCode() : 0);
        result = 31 * result + (diasFin != null ? diasFin.hashCode() : 0);
        return result;
    }
}
