package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_documento_etapas", schema = "dbo", catalog = "COBRANZA")
public class DocumentoEtapas {
    private Integer systemId;
    private String etapaDoc;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "etapa_doc")
    public String getEtapaDoc() {
        return etapaDoc;
    }

    public void setEtapaDoc(String etapaDoc) {
        this.etapaDoc = etapaDoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentoEtapas that = (DocumentoEtapas) o;

        if (etapaDoc != null ? !etapaDoc.equals(that.etapaDoc) : that.etapaDoc != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (etapaDoc != null ? etapaDoc.hashCode() : 0);
        return result;
    }
}
