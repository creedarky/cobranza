package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_DM_CLIENTE")
@NamedQueries({@NamedQuery(name="DmCliente.findAll",query = "Select cn From DmCliente cn")})
@SequenceGenerator(name = "DmClienteSeq",
        sequenceName = "SEQ_DmCliente", allocationSize = 1, initialValue = 1)


public class DmCliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DmClienteSeq")
    private Long systemId;

    @Column(name = "dm")
    private String dmCliente;

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Cliente cliente;

    public DmCliente() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getDmCliente() {
        return dmCliente;
    }

    public void setDmCliente(String dmCliente) {
        this.dmCliente = dmCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
