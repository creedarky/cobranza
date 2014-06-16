package cl.acaya.web.ws.request;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ulayera
 * Date: 04-12-13
 * Time: 12:39 PM
 */
@XmlType(name = "NotificarFacturaAceptaRequest", namespace = "/model/NotificarFacturaAceptaRequest")
public class NotificarFacturaAceptaRequest implements Serializable {

    private String numFactura;
    private String evento;
    private String estadoEvento;
    private String duennoEvento;
    private Date fechaHoraEvento;
    private String observacion;
    private String urlFactura;


    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public String getDuennoEvento() {
        return duennoEvento;
    }

    public void setDuennoEvento(String duennoEvento) {
        this.duennoEvento = duennoEvento;
    }

    public Date getFechaHoraEvento() {
        return fechaHoraEvento;
    }

    public void setFechaHoraEvento(Date fechaHoraEvento) {
        this.fechaHoraEvento = fechaHoraEvento;
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

    @Override
    public String toString() {
        return "NotificarFacturaAceptaRequest{" +
                "numFactura='" + numFactura + '\'' +
                ", evento='" + evento + '\'' +
                ", estadoEvento='" + estadoEvento + '\'' +
                ", duennoEvento='" + duennoEvento + '\'' +
                ", fechaHoraEvento=" + fechaHoraEvento +
                ", observacion='" + observacion + '\'' +
                ", urlFactura='" + urlFactura + '\'' +
                '}';
    }
}
