package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_documento_param", schema = "dbo", catalog = "COBRANZA")
public class TblDocumentoParamEntity {
    private String depachoFact;
    private String validaFact;
    private String contingFact;
    private String perdidaIva;
    private String notificaClienteK34;

    @Basic
    @Column(name = "depacho_fact")
    public String getDepachoFact() {
        return depachoFact;
    }

    public void setDepachoFact(String depachoFact) {
        this.depachoFact = depachoFact;
    }

    @Basic
    @Column(name = "valida_fact")
    public String getValidaFact() {
        return validaFact;
    }

    public void setValidaFact(String validaFact) {
        this.validaFact = validaFact;
    }

    @Basic
    @Column(name = "conting_fact")
    public String getContingFact() {
        return contingFact;
    }

    public void setContingFact(String contingFact) {
        this.contingFact = contingFact;
    }

    @Basic
    @Column(name = "perdida_iva")
    public String getPerdidaIva() {
        return perdidaIva;
    }

    public void setPerdidaIva(String perdidaIva) {
        this.perdidaIva = perdidaIva;
    }

    @Basic
    @Column(name = "notifica_cliente_k34")
    public String getNotificaClienteK34() {
        return notificaClienteK34;
    }

    public void setNotificaClienteK34(String notificaClienteK34) {
        this.notificaClienteK34 = notificaClienteK34;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblDocumentoParamEntity that = (TblDocumentoParamEntity) o;

        if (contingFact != null ? !contingFact.equals(that.contingFact) : that.contingFact != null) return false;
        if (depachoFact != null ? !depachoFact.equals(that.depachoFact) : that.depachoFact != null) return false;
        if (notificaClienteK34 != null ? !notificaClienteK34.equals(that.notificaClienteK34) : that.notificaClienteK34 != null)
            return false;
        if (perdidaIva != null ? !perdidaIva.equals(that.perdidaIva) : that.perdidaIva != null) return false;
        if (validaFact != null ? !validaFact.equals(that.validaFact) : that.validaFact != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depachoFact != null ? depachoFact.hashCode() : 0;
        result = 31 * result + (validaFact != null ? validaFact.hashCode() : 0);
        result = 31 * result + (contingFact != null ? contingFact.hashCode() : 0);
        result = 31 * result + (perdidaIva != null ? perdidaIva.hashCode() : 0);
        result = 31 * result + (notificaClienteK34 != null ? notificaClienteK34.hashCode() : 0);
        return result;
    }
}
