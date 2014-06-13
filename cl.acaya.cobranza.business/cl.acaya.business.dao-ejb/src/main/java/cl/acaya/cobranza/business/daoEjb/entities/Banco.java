package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_banco", schema = "dbo", catalog = "COBRANZA")
public class Banco {
    private Integer systemId;
    private String banco;
    private Integer linkComuna;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_banco", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_banco"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_banco")
    private Long system_id;
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "banco")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @JoinColumn(name = "link_comuna", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    public Integer getLinkComuna() {
        return linkComuna;
    }

    public void setLinkComuna(Integer linkComuna) {
        this.linkComuna = linkComuna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banco banco1 = (Banco) o;

        if (banco != null ? !banco.equals(banco1.banco) : banco1.banco != null) return false;
        if (linkComuna != null ? !linkComuna.equals(banco1.linkComuna) : banco1.linkComuna != null) return false;
        if (systemId != null ? !systemId.equals(banco1.systemId) : banco1.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (banco != null ? banco.hashCode() : 0);
        result = 31 * result + (linkComuna != null ? linkComuna.hashCode() : 0);
        return result;
    }
}
