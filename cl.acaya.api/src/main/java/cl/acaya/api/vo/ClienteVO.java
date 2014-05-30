package cl.acaya.api.vo;

/**
 * Created by mcastro on 27-05-14.
 */
public class ClienteVO {


    private Long idCliente;
    private String nombreCliente;
    private String rutCliente;
    private UsuarioVO usuarioAsignado;


    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public UsuarioVO getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(UsuarioVO usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
}
