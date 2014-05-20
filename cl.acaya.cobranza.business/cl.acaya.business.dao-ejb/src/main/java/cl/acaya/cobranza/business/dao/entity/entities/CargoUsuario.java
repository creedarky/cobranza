package cl.acaya.cobranza.business.dao.entity.entities;

/**
 * Created by darkmoorx on 19-05-14.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TBL_CARGO_USUARIO")
@NamedQueries({@NamedQuery(name="CargoUsuario.findAll",query = "Select cn From CargoUsuario cn")})
@SequenceGenerator(name = "CargoUsuarioSeq",
        sequenceName = "SEQ_CargoUsuario", allocationSize = 1, initialValue = 1)


public class CargoUsuario {


    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CargoUsuarioSeq")
    private Long systemId;

    @Id
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;

    public CargoUsuario() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
