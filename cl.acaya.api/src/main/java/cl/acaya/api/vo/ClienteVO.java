package cl.acaya.api.vo;

/**
 * Created by mcastro on 27-05-14.
 */
public class ClienteVO {


    private Long idCliente;
    private Long idDmCliente;
    private String nombreCliente;
    private String rutCliente;
    private String clasificacionRiesgo;
    private Long pedidosProceso;
    private String tipoSeguro;
    private String vigencia;
    private UsuarioVO usuarioAsignado;
    private Long montoSeguro;
    private Long lineaCredito;
    private boolean bloqueo;
    private Long lineaCreditoUtilizada;
    private Long lineaCreditoDisponible;
    private Double montoSeguroUF;
    private String canalVenta;
    private String estadoLinea;
    private String condicioPago;


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

    public Long getIdDmCliente() {
        return idDmCliente;
    }

    public void setIdDmCliente(Long idDmCliente) {
        this.idDmCliente = idDmCliente;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public void setMontoSeguro(Long montoSeguro) {
        this.montoSeguro = montoSeguro;
    }

    public Long getMontoSeguro() {
        return montoSeguro;
    }

    public void setLineaCredito(Long lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Long getLineaCredito() {
        return lineaCredito;
    }

    public Long getLineaCreditoUtilizada() {
        return lineaCreditoUtilizada;
    }

    public void setLineaCreditoUtilizada(Long lineaCreditoUtilizada) {
        this.lineaCreditoUtilizada = lineaCreditoUtilizada;
    }

    public Long getLineaCreditoDisponible() {
        return lineaCreditoDisponible;
    }

    public void setLineaCreditoDisponible(Long lineaCreditoDisponible) {
        this.lineaCreditoDisponible = lineaCreditoDisponible;
    }

    public Double getMontoSeguroUF() {
        return montoSeguroUF;
    }

    public void setMontoSeguroUF(Double montoSeguroUF) {
        this.montoSeguroUF = montoSeguroUF;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
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


    public void setCondicioPago(String condicioPago) {
        this.condicioPago = condicioPago;
    }

    public String getCondicioPago() {
        return condicioPago;
    }
}
