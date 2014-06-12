package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_forma_pago", schema = "dbo", catalog = "COBRANZA")
public class FormaPago {
    private Integer systemId;
    private String formaPago;
    private Integer diasProm;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "forma_pago")
    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Basic
    @Column(name = "dias_prom")
    public Integer getDiasProm() {
        return diasProm;
    }

    public void setDiasProm(Integer diasProm) {
        this.diasProm = diasProm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormaPago formaPago1 = (FormaPago) o;

        if (diasProm != null ? !diasProm.equals(formaPago1.diasProm) : formaPago1.diasProm != null) return false;
        if (formaPago != null ? !formaPago.equals(formaPago1.formaPago) : formaPago1.formaPago != null) return false;
        if (systemId != null ? !systemId.equals(formaPago1.systemId) : formaPago1.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (formaPago != null ? formaPago.hashCode() : 0);
        result = 31 * result + (diasProm != null ? diasProm.hashCode() : 0);
        return result;
    }
}
