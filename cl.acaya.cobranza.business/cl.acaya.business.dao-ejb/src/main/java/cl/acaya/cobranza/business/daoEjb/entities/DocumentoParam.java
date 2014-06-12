package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_documento_param", schema = "dbo", catalog = "COBRANZA")
public class DocumentoParam {
    private String depachoFact;
    private String validaFact;
    private String contingFact;
    private String perdidaIva;
    private String notificaClienteK34;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_documentoParam", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_documentoParam"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_documentoParam")
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

        DocumentoParam that = (DocumentoParam) o;

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
