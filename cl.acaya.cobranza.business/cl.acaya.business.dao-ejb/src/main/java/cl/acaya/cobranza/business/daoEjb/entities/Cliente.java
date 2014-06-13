package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CLIENTE")
@NamedQueries({@NamedQuery(name="Cliente.findAll",query = "Select cn From Cliente cn order by cn.nombreCliente asc"),
@NamedQuery(name = "Cliente.findByRut", query = "from Cliente where rutCliente = :rutCliente")})

public class Cliente {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Cliente", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_Cliente"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Cliente")
    private Long systemId;

    @Column(name = "rut")
    private String rutCliente;

    @Column(name = "nom_cliente")
    private String nombreCliente;

    @Column(name = "seguro")
    private String seguro;


    @Column(name = "tipo_seguro")
    private String tipoSeguro;

    @Column(name = "condicion_pago")
    private String condicionPago;

    @Column(name = "linea_credito")
    private Long lineaCredito;

    @Column(name = "linea_credito_utilizada")
    private Long lineaCreditoUtilizada;

    @Column(name = "linea_credito_disponible")
    private Long lineaCreditoDisponible;

    @Column(name = "monto_seguro")
    private Long montoSeguro;

    @Column(name = "monto_seguro_uf")
    private Double montoSeguroUF;


    @Column(name = "bloqueo")
    private boolean bloqueo = false;

    @Column(name = "ped_proc")
    private Long pedidosEnProceso;

    @Column(name = "vig_seg")
    private String vigencia;

    @Column(name = "clasifica_riesgo")
    private String clasificacionRiesgo;

    @Column(name = "canal_venta")
    private String canalVenta;

    @Column(name = "estado_linea")
    private String estadoLinea;





    public Cliente(){
        bloqueo = false;

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public Long getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(Long lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Long getMontoSeguro() {
        return montoSeguro;
    }

    public void setMontoSeguro(Long montoSeguro) {
        this.montoSeguro = montoSeguro;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public Long getPedidosEnProceso() {
        return pedidosEnProceso;
    }

    public void setPedidosEnProceso(Long pedidosEnProceso) {
        this.pedidosEnProceso = pedidosEnProceso;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getClasificacionRiesgo() {
        return clasificacionRiesgo;
    }

    public void setClasificacionRiesgo(String clasificacionRiesgo) {
          this.clasificacionRiesgo = clasificacionRiesgo;
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
    public String toString() {
        return "Cliente{" +
                "systemId=" + systemId +
                ", rutCliente='" + rutCliente + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
