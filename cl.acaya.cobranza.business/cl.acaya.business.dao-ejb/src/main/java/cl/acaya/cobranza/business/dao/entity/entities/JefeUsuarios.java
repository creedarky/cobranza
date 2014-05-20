package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_JEFE_USUARIO")
@NamedQueries({@NamedQuery(name="JefeUsuarios.findAll",query = "Select cn From JefeUsuarios cn")})
@SequenceGenerator(name = "JefeUsuariosSeq",
        sequenceName = "SEQ_JefeUsuarios", allocationSize = 1, initialValue = 1)

public class JefeUsuarios {

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToMany
    private Usuarios usuario;

    @JoinColumn(name = "link_jefe", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToMany
    private Usuarios jefe;

    public JefeUsuarios() {

    }

    public Usuarios getJefe() {
        return jefe;
    }

    public void setJefe(Usuarios jefe) {
        this.jefe = jefe;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
