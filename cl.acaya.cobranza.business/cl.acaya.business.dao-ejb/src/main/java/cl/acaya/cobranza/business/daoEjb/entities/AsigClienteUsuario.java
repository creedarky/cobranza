package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "TBL_ASIG_CLI_USU", schema = "dbo")
@NamedQueries({@NamedQuery(name="AsigClienteUsuario.findAll",query = "Select cn From AsigClienteUsuario cn")})
@SequenceGenerator(name = "AsigClienteUsuarioSeq",
        sequenceName = "SEQ_AsigClienteUsuario", allocationSize = 1, initialValue = 1)


public class AsigClienteUsuario implements Serializable {

        @Id
        @Basic(optional = false)
        @Column(name = "system_id")
        //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AsigClienteUsuarioSeq")
        private Long system_id;

        @Id
        @Basic(optional = false)
        @Column(name = "link_cliente", length = 18)
        private Integer linkCliente;

        @Column(name = "link_usuario", length = 18)
        private Integer linkUsuario;

        @Column(name = "fecha_ini")
        private Date fechaInicio;

        @Column(name = "fecha_fin")
        private Date fechaFin;

        @Column(name = "disabled" )
        private boolean estadoDisabled;

        public AsigClienteUsuario() {

        }

    public Long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(Long system_id) {
        this.system_id = system_id;
    }

    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    public Integer getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Integer linkUsuario) {
        this.linkUsuario = linkUsuario;
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
