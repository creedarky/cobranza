package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "tbl_intacepta", schema = "dbo")
@NamedQueries({@NamedQuery(name="IntegracionAcepta.findAll",query = "Select cn From IntegracionAcepta cn"),
@NamedQuery(name="IntegracionAcepta.findByNumeroFactura",query = "from IntegracionAcepta where numeroFactura = :numeroFactura")})
public class IntegracionAcepta {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Documento", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
            @Parameter(name = "table_name", value = "hibernate_sequences"),
            @Parameter(name = "segment_value", value = "SEQ_Documento"),
            @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "SEQ_Documento")
    private Long systemId;


    @Column(name = "numfactura")
    private String numeroFactura;

    @Column
    private String duennoEvento;

    @Column
    private String estadoEvento;

    @Column
    private Date fechaHora;

    @Column
    private String observacion;

    @Column
    private String urlFactura;

    @Column(name = "fecha_syst")
    private Date fechaSys;

    public IntegracionAcepta() {
        fechaSys = new Date();
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getDuennoEvento() {
        return duennoEvento;
    }

    public void setDuennoEvento(String duennoEvento) {
        this.duennoEvento = duennoEvento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUrlFactura() {
        return urlFactura;
    }

    public void setUrlFactura(String urlFactura) {
        this.urlFactura = urlFactura;
    }

    public Date getFechaSys() {
        return fechaSys;
    }

    public void setFechaSys(Date fechaSys) {
        this.fechaSys = fechaSys;
    }
}
