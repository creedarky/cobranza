package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class GuardarAgendaVO implements Serializable {


    private Date fechaAgendada;
    private String comentario;
    private Long idContacto;
    private Long idCliente;
    private String cargo;
    private Long[] idDocumentos;

    public Date getFechaAgendada() {
        return fechaAgendada;
    }

    public void setFechaAgendada(Date fechaAgendada) {
        this.fechaAgendada = fechaAgendada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long[] getIdDocumentos() {
        return idDocumentos;
    }

    public void setIdDocumentos(Long[] idDocumentos) {
        this.idDocumentos = idDocumentos;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "GuardarAgendaVO{" +
                "fechaAgendada=" + fechaAgendada +
                ", comentario='" + comentario + '\'' +
                ", idContacto=" + idContacto +
                ", cargo='" + cargo + '\'' +
                ", idDocumentos=" + Arrays.toString(idDocumentos) +
                '}';
    }
}
