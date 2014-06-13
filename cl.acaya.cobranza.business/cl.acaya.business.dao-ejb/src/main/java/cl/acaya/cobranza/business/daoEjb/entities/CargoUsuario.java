package cl.acaya.cobranza.business.daoEjb.entities;

/**
 * Created by darkmoorx on 19-05-14.
 */

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "TBL_CARGO_USUARIO")
@NamedQueries({@NamedQuery(name="CargoUsuario.findAll",query = "Select cn From CargoUsuario cn")})
@SequenceGenerator(name = "CargoUsuarioSeq",
        sequenceName = "SEQ_CargoUsuario", allocationSize = 1, initialValue = 1)
public class CargoUsuario {


    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "cargoUsuarioSequenceGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_CARGOUSUARIO"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "cargoUsuarioSequenceGenerator")
    private Long systemId;

    @Id
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;

    public CargoUsuario() {
    }

    public CargoUsuario(String cargo) {
        this.cargo = cargo;

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
