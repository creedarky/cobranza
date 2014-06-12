package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_dm_cliente", schema = "dbo", catalog = "COBRANZA")
public class TblDmClienteEntity {
    private Integer systemId;
    private String dm;
    private Integer linkCliente;
    private Integer linkSucursal;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "dm")
    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }

    @Basic
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Basic
    @Column(name = "link_sucursal")
    public Integer getLinkSucursal() {
        return linkSucursal;
    }

    public void setLinkSucursal(Integer linkSucursal) {
        this.linkSucursal = linkSucursal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblDmClienteEntity that = (TblDmClienteEntity) o;

        if (dm != null ? !dm.equals(that.dm) : that.dm != null) return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkSucursal != null ? !linkSucursal.equals(that.linkSucursal) : that.linkSucursal != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (dm != null ? dm.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (linkSucursal != null ? linkSucursal.hashCode() : 0);
        return result;
    }
}
