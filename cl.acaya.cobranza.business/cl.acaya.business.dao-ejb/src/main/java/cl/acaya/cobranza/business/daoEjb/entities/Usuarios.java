package cl.acaya.cobranza.business.daoEjb.entities;

/**
 * Created by darkmoorx on 19-05-14.
 */
import javax.persistence.*;


@Entity
@Table(name = "TBL_USUARIO")
@NamedQueries({@NamedQuery(name="Usuarios.findAll",query = "Select cn From Usuarios cn")})
@SequenceGenerator(name = "UsuariosSeq",
        sequenceName = "SEQ_Usuarios", allocationSize = 1, initialValue = 1)


public class Usuarios {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSeq")
    private Long systemId;

    @Column(name = "nom_usuario")
    private String nombreUsuario;

    @Column(name = "nom_completo")
    private String nombreCompleto;

    @Column(name = "passw" )
    private String usuarioPassword;

    @Column(name = "email")
    private String usuarioEmail;

        @JoinColumn(name = "link_cargo", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
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
