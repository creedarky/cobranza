package cl.acaya.api.vo;

/**
 * Created by mcastro on 27-05-14.
 */
public class ClienteVO {


    private Long idCliente;
    private String nombreCliente;
    private String rutCliente;
    private String clasificacionRiesgo;
    private Long pedidosProceso;
    private String tipoSeguro;
    private String vigencia;
    private String estadoCliente;
    private String estadoLinea;
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

    public String getClasificacionRiesgo() {
        return clasificacionRiesgo;
    }

    public void setClasificacionRiesgo(String clasificacionRiesgo) {
        this.clasificacionRiesgo = clasificacionRiesgo;
    }

    public Long getPedidosProceso() {
        return pedidosProceso;
    }

    public void setPedidosProceso(Long pedidosProceso) {
        this.pedidosProceso = pedidosProceso;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getEstadoLinea() {
        return estadoLinea;
    }

    public void setEstadoLinea(String estadoLinea) {
        this.estadoLinea = estadoLinea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteVO clienteVO = (ClienteVO) o;

        if (!idCliente.equals(clienteVO.idCliente)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idCliente.hashCode();
    }
}
