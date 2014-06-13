package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TBL_ASIG_CLI_USU", schema = "dbo")
@NamedQueries({@NamedQuery(name="AsignacionClienteUsuario.findAll",query = "Select cn From AsignacionClienteUsuario cn")})
public class AsignacionClienteUsuario implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_asigClienteUsuario", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_asigClienteUsuario"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_asigClienteUsuario")
    private Long system_id;

    @JoinColumn(name = "link_usuario")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @JoinColumn(name = "link_cliente")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "fecha_ini")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "disabled" )
    private boolean estadoDisabled;

    public AsignacionClienteUsuario() {
        estadoDisabled = false;
        fechaInicio = new Date();

    }

    public Long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(Long system_id) {
        this.system_id = system_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstadoDisabled() {
        return estadoDisabled;
    }

    public void setEstadoDisabled(boolean estadoDisabled) {
        this.estadoDisabled = estadoDisabled;
    }
}
