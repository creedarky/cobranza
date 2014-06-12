package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_sucursal", schema = "dbo", catalog = "COBRANZA")
public class TblSucursalEntity {
    private Integer systemId;
    private String codSucursal;
    private String nomSucursal;
    private Integer linkZona;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "cod_sucursal")
    public String getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }

    @Basic
    @Column(name = "nom_sucursal")
    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    @Basic
    @Column(name = "link_zona")
    public Integer getLinkZona() {
        return linkZona;
    }

    public void setLinkZona(Integer linkZona) {
        this.linkZona = linkZona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSucursalEntity that = (TblSucursalEntity) o;

        if (codSucursal != null ? !codSucursal.equals(that.codSucursal) : that.codSucursal != null) return false;
        if (linkZona != null ? !linkZona.equals(that.linkZona) : that.linkZona != null) return false;
        if (nomSucursal != null ? !nomSucursal.equals(that.nomSucursal) : that.nomSucursal != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (codSucursal != null ? codSucursal.hashCode() : 0);
        result = 31 * result + (nomSucursal != null ? nomSucursal.hashCode() : 0);
        result = 31 * result + (linkZona != null ? linkZona.hashCode() : 0);
        return result;
    }
}
