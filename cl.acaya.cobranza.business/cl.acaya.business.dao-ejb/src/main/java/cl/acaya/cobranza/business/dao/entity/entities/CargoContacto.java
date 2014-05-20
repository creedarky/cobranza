package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CARGO_CONTACTO")
@NamedQueries({@NamedQuery(name="CargoContacto.findAll",query = "Select cn From CargoContacto cn")})
@SequenceGenerator(name = "CargoContactoSeq",
        sequenceName = "SEQ_CargoContacto", allocationSize = 1, initialValue = 1)


public class CargoContacto {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CargoContactoSeq")
    private Long systemId;

    @Column(name = "cargo")
    private String cargoContacto;

    public CargoContacto(){

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }
}
