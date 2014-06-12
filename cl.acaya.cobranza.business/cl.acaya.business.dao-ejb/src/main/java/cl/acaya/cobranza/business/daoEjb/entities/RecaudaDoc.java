package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_recauda_doc", schema = "dbo", catalog = "COBRANZA")
public class RecaudaDoc {
    private Integer linkRecauda;
    private Integer linkDocumento;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_recaudaDoc", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_recaudaDoc"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_recaudaDoc")
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
