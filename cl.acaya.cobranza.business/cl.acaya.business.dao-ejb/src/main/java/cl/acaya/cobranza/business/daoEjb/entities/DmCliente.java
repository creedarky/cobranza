package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Parameter;
import javax.persistence.Table;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_DM_CLIENTE")
@NamedQueries({@NamedQuery(name="DmCliente.findAll",query = "Select cn From DmCliente cn"),
@NamedQuery(name = "DmCliente.findByDmCliente", query = "from DmCliente where dmCliente = :dmCliente")})
//@SequenceGenerator(name = "DmClienteSeq",
        //sequenceName = "SEQ_DmCliente", allocationSize = 1, initialValue = 1)


public class DmCliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_DmCliente", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_DmCliente"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DmCliente")
    private Long systemId;

    @Column(name = "dm")
    private String dmCliente;

    @JoinColumn(name = "link_cliente")  // COD_TIPO_NEGOCIO_PE_FK
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
