package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CONTACTO_CLIENTE")
@NamedQueries({@NamedQuery(name="ContactoCliente.findAll",query = "Select cn From ContactoCliente cn")})
@SequenceGenerator(name = "ContactoClienteSeq",
        sequenceName = "SEQ_ContactoCliente", allocationSize = 1, initialValue = 1)

public class ContactoCliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContactoClienteSeq")
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

    @JoinColumn(name = "link_cargo", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private CargoUsuario cargo;

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Cliente cliente;

    public ContactoCliente() {

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

    public CargoUsuario getCargo() {
        return cargo;
    }

    public void setCargo(CargoUsuario cargo) {
        this.cargo = cargo;
    }
}
