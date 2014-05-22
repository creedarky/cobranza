package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CLIENTE")
@NamedQueries({@NamedQuery(name="Cliente.findAll",query = "Select cn From Cliente cn")})
@SequenceGenerator(name = "ClienteSeq",
        sequenceName = "SEQ_Cliente", allocationSize = 1, initialValue = 1)

public class Cliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ClienteSeq")
    private Long systemId;

    @Column(name = "rut")
    private String rutCliente;

    @Column(name = "nom_cliente")
    private String nombreCliente;

    public Cliente(){

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }
}
