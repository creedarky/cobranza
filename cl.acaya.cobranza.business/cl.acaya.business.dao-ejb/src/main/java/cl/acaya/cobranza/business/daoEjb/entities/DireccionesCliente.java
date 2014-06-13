package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_direcciones_cliente", schema = "dbo", catalog = "COBRANZA")
public class DireccionesCliente {
    private Integer systemId;
    private Integer linkCliente;
    private String direccionCli;
    private Integer linkComunaCli;
    private String direccionDesp;
    private String linkComunaDesp;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_direccionesCliente", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_direccionesCliente"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_direccionesCliente")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Basic
    @Column(name = "direccion_cli")
    public String getDireccionCli() {
        return direccionCli;
    }

    public void setDireccionCli(String direccionCli) {
        this.direccionCli = direccionCli;
    }

    @JoinColumn(name = "link_comuna_cli", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_comuna_cli")
    public Integer getLinkComunaCli() {
        return linkComunaCli;
    }

    public void setLinkComunaCli(Integer linkComunaCli) {
        this.linkComunaCli = linkComunaCli;
    }

    @Basic
    @Column(name = "direccion_desp")
    public String getDireccionDesp() {
        return direccionDesp;
    }

    public void setDireccionDesp(String direccionDesp) {
        this.direccionDesp = direccionDesp;
    }

    @JoinColumn(name = "link_comuna_desp", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    @Column(name = "link_comuna_desp")
    public String getLinkComunaDesp() {
        return linkComunaDesp;
    }

    public void setLinkComunaDesp(String linkComunaDesp) {
        this.linkComunaDesp = linkComunaDesp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DireccionesCliente that = (DireccionesCliente) o;

        if (direccionCli != null ? !direccionCli.equals(that.direccionCli) : that.direccionCli != null) return false;
        if (direccionDesp != null ? !direccionDesp.equals(that.direccionDesp) : that.direccionDesp != null)
            return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkComunaCli != null ? !linkComunaCli.equals(that.linkComunaCli) : that.linkComunaCli != null)
            return false;
        if (linkComunaDesp != null ? !linkComunaDesp.equals(that.linkComunaDesp) : that.linkComunaDesp != null)
            return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        result = 31 * result + (direccionCli != null ? direccionCli.hashCode() : 0);
        result = 31 * result + (linkComunaCli != null ? linkComunaCli.hashCode() : 0);
        result = 31 * result + (direccionDesp != null ? direccionDesp.hashCode() : 0);
        result = 31 * result + (linkComunaDesp != null ? linkComunaDesp.hashCode() : 0);
        return result;
    }
}
