package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CONTACTO_CLIENTE")
@NamedQueries({@NamedQuery(name="ContactoCliente.findAll",query = "Select cn From ContactoCliente cn"),
@NamedQuery(name = "ContactoCliente.findByid", query = "from ContactoCliente where systemId = :system_id")})
//@SequenceGenerator(name = "ContactoClienteSeq",
//        sequenceName = "SEQ_ContactoCliente", allocationSize = 1, initialValue = 1)

public class ContactoCliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_ContactoCliente", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_ContactoCliente"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ContactoCliente")
    private Long systemId;

    @Column(name = "nom_contacto")
    private String nombreContacto;

    @Column(name = "email_contacto")
    private String emailContacto;

    @Column(name = "fono_contacto1" )
    private String fonoContacto1;

    @Column(name = "fono_contacto2")
    private String fonoContacto2;

    @Column(name = "fono_contacto3" )
    private String fonoContacto3;

    @JoinColumn(name = "link_cargo")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private CargoContacto cargo;

    @JoinColumn(name = "link_cliente")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public ContactoCliente() {

    }

    @PrePersist @PreUpdate
    public void prepare() {
        System.out.println(this.toString());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public String getFonoContacto1() {
        return fonoContacto1;
    }

    public void setFonoContacto1(String fonoContacto1) {
        this.fonoContacto1 = fonoContacto1;
    }

    public String getFonoContacto2() {
        return fonoContacto2;
    }

    public void setFonoContacto2(String fonoContacto2) {
        this.fonoContacto2 = fonoContacto2;
    }

    public String getFonoContacto3() {
        return fonoContacto3;
    }

    public void setFonoContacto3(String fonoContacto3) {
        this.fonoContacto3 = fonoContacto3;
    }

    public CargoContacto getCargo() {
        return cargo;
    }

    public void setCargo(CargoContacto cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "ContactoCliente{" +
                "systemId=" + systemId +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", emailContacto='" + emailContacto + '\'' +
                ", fonoContacto1='" + fonoContacto1 + '\'' +
                ", fonoContacto2='" + fonoContacto2 + '\'' +
                ", fonoContacto3='" + fonoContacto3 + '\'' +
                ", cargo=" + cargo +
                ", cliente=" + cliente +
                '}';
    }
}
