package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_contingencia", schema = "dbo", catalog = "COBRANZA")
public class Contingencia {
    private Integer systemId;
    private String contingencia;
    private Integer linkTipoContig;
    private String tipo;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "contingencia")
    public String getContingencia() {
        return contingencia;
    }

    public void setContingencia(String contingencia) {
        this.contingencia = contingencia;
    }

    @Basic
    @Column(name = "link_tipo_contig")
    public Integer getLinkTipoContig() {
        return linkTipoContig;
    }

    public void setLinkTipoContig(Integer linkTipoContig) {
        this.linkTipoContig = linkTipoContig;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contingencia that = (Contingencia) o;

        if (contingencia != null ? !contingencia.equals(that.contingencia) : that.contingencia != null) return false;
        if (linkTipoContig != null ? !linkTipoContig.equals(that.linkTipoContig) : that.linkTipoContig != null)
            return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (contingencia != null ? contingencia.hashCode() : 0);
        result = 31 * result + (linkTipoContig != null ? linkTipoContig.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
