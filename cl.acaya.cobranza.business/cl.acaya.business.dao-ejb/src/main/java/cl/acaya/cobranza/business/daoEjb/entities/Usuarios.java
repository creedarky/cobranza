package cl.acaya.cobranza.business.daoEjb.entities;

/**
 * Created by darkmoorx on 19-05-14.
 */
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "TBL_USUARIO")
@NamedQueries({@NamedQuery(name="Usuarios.findAll",query = "Select cn From Usuarios cn")})
//@SequenceGenerator(name = "UsuariosSeq",
//        sequenceName = "SEQ_Usuarios", allocationSize = 1, initialValue = 1)


public class Usuarios {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Usuarios", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_Usuarios"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Usuarios")
    private Long systemId;

    @Column(name = "nom_usuario")
    private String nombreUsuario;

    @Column(name = "nom_completo")
    private String nombreCompleto;

    @Column(name = "passw" )
    private String usuarioPassword;

    @Column(name = "email")
    private String usuarioEmail;

    @JoinColumn(name = "link_cargo")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private CargoUsuario cargo;



    public Usuarios() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public CargoUsuario getCargo() {
        return cargo;
    }

    public void setCargo(CargoUsuario cargo) {
        this.cargo = cargo;
    }
}
