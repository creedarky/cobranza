package cl.acaya.api.vo;

import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class CampanhaVO {


    private Long id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaTermino;
    private ClienteVO cliente;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
}
