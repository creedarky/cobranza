package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_VENDEDOR")
@NamedQueries({@NamedQuery(name="Vendedor.findAll",query = "Select cn From Vendedor cn")})
@SequenceGenerator(name = "VendedorSeq",
        sequenceName = "SEQ_Vendedor", allocationSize = 1, initialValue = 1)

public class Vendedor {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VendedorSeq")
    private Long systemId;

    @Column(name = "cod_vendedor")
    private String codigoVendedor;

    @Column(name = "nom_vendedor")
    private String nombreVendedor;

    @Column(name = "email" )
    private String emailVendedor;

    @Column(name = "fono_vend1")
    private String fonoVendedor1;

    @Column(name = "fono_vend2")
    private String fonoVendedor2;

    @Column(name = "fono_vend3")
    private String fonoVendedor3;

    public Vendedor() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public String getFonoVendedor1() {
        return fonoVendedor1;
    }

    public void setFonoVendedor1(String fonoVendedor1) {
        this.fonoVendedor1 = fonoVendedor1;
    }

    public String getFonoVendedor2() {
        return fonoVendedor2;
    }

    public void setFonoVendedor2(String fonoVendedor2) {
        this.fonoVendedor2 = fonoVendedor2;
    }

    public String getFonoVendedor3() {
        return fonoVendedor3;
    }

    public void setFonoVendedor3(String fonoVendedor3) {
        this.fonoVendedor3 = fonoVendedor3;
    }
}
