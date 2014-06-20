package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by mcastro on 27-05-14.
 */
public class ContactoVO implements Serializable {

    private String nombre;
    private String email;
    private String fono;
    private Long idCargo;
    private String cargo;
    private Long idContacto;
    private Long idCliente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "ContactoVO{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fono='" + fono + '\'' +
                ", cargo='" + idCargo + '\'' +
                ", idContacto=" + idContacto +
                ", idCliente=" + idCliente +
                '}';
    }
}
