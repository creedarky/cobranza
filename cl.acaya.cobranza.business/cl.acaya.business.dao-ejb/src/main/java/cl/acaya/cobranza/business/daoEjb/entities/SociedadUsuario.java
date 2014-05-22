package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_SOCIEDAD_USUARIO")
@NamedQueries({@NamedQuery(name="SociedadUsuario.findAll",query = "Select cn From SociedadUsuario cn")})

public class SociedadUsuario {


    @JoinColumn(name = "link_sociedad", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Sociedad sociedad;

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Usuarios usuarios;

    public SociedadUsuario() {

    }

    public Sociedad getSociedad() {
        return sociedad;
    }

    public void setSociedad(Sociedad sociedad) {
        this.sociedad = sociedad;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
