package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_tipo_contingencia", schema = "dbo", catalog = "COBRANZA")
public class TipoContingencia {
    private Integer systemId;
    private String tipoContingencia;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "tipo_contingencia")
    public String getTipoContingencia() {
        return tipoContingencia;
    }

    public void setTipoContingencia(String tipoContingencia) {
        this.tipoContingencia = tipoContingencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoContingencia that = (TipoContingencia) o;

        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (tipoContingencia != null ? !tipoContingencia.equals(that.tipoContingencia) : that.tipoContingencia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (tipoContingencia != null ? tipoContingencia.hashCode() : 0);
        return result;
    }
}
