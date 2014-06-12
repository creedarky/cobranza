package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_recauda_doc", schema = "dbo", catalog = "COBRANZA")
public class RecaudaDoc {
    private Integer linkRecauda;
    private Integer linkDocumento;

    @Basic
    @Column(name = "link_recauda")
    public Integer getLinkRecauda() {
        return linkRecauda;
    }

    public void setLinkRecauda(Integer linkRecauda) {
        this.linkRecauda = linkRecauda;
    }

    @Basic
    @Column(name = "link_documento")
    public Integer getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Integer linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecaudaDoc that = (RecaudaDoc) o;

        if (linkDocumento != null ? !linkDocumento.equals(that.linkDocumento) : that.linkDocumento != null)
            return false;
        if (linkRecauda != null ? !linkRecauda.equals(that.linkRecauda) : that.linkRecauda != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linkRecauda != null ? linkRecauda.hashCode() : 0;
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        return result;
    }
}
