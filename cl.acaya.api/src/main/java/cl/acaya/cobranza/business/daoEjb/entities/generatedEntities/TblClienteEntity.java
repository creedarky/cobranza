package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_cliente", schema = "dbo", catalog = "COBRANZA")
public class TblClienteEntity {
    private Integer systemId;
    private String rut;
    private String nomCliente;
    private String seguro;
    private String tipoSeguro;
    private Integer montoSeguro;
    private Integer lineaCredito;
    private Boolean bloqueo;
    private String condicionPago;
    private Integer pedProc;
    private String clasificaRiesgo;
    private String vigSeg;
    private String canalVenta;
    private Integer lineaCreditoUtilizada;
    private Integer lineaCreditoDisponible;
    private BigDecimal montoSeguroUf;
    private String estadoLinea;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "rut")
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Basic
    @Column(name = "nom_cliente")
    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    @Basic
    @Column(name = "seguro")
    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    @Basic
    @Column(name = "tipo_seguro")
    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    @Basic
    @Column(name = "monto_seguro")
    public Integer getMontoSeguro() {
        return montoSeguro;
    }

    public void setMontoSeguro(Integer montoSeguro) {
        this.montoSeguro = montoSeguro;
    }

    @Basic
    @Column(name = "linea_credito")
    public Integer getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(Integer lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    @Basic
    @Column(name = "bloqueo")
    public Boolean getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(Boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    @Basic
    @Column(name = "condicion_pago")
    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    @Basic
    @Column(name = "ped_proc")
    public Integer getPedProc() {
        return pedProc;
    }

    public void setPedProc(Integer pedProc) {
        this.pedProc = pedProc;
    }

    @Basic
    @Column(name = "clasifica_riesgo")
    public String getClasificaRiesgo() {
        return clasificaRiesgo;
    }

    public void setClasificaRiesgo(String clasificaRiesgo) {
        this.clasificaRiesgo = clasificaRiesgo;
    }

    @Basic
    @Column(name = "vig_seg")
    public String getVigSeg() {
        return vigSeg;
    }

    public void setVigSeg(String vigSeg) {
        this.vigSeg = vigSeg;
    }

    @Basic
    @Column(name = "canal_venta")
    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    @Basic
    @Column(name = "linea_credito_utilizada")
    public Integer getLineaCreditoUtilizada() {
        return lineaCreditoUtilizada;
    }

    public void setLineaCreditoUtilizada(Integer lineaCreditoUtilizada) {
        this.lineaCreditoUtilizada = lineaCreditoUtilizada;
    }

    @Basic
    @Column(name = "linea_credito_disponible")
    public Integer getLineaCreditoDisponible() {
        return lineaCreditoDisponible;
    }

    public void setLineaCreditoDisponible(Integer lineaCreditoDisponible) {
        this.lineaCreditoDisponible = lineaCreditoDisponible;
    }

    @Basic
    @Column(name = "monto_seguro_uf")
    public BigDecimal getMontoSeguroUf() {
        return montoSeguroUf;
    }

    public void setMontoSeguroUf(BigDecimal montoSeguroUf) {
        this.montoSeguroUf = montoSeguroUf;
    }

    @Basic
    @Column(name = "estado_linea")
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

        TblClienteEntity that = (TblClienteEntity) o;

        if (bloqueo != null ? !bloqueo.equals(that.bloqueo) : that.bloqueo != null) return false;
        if (canalVenta != null ? !canalVenta.equals(that.canalVenta) : that.canalVenta != null) return false;
        if (clasificaRiesgo != null ? !clasificaRiesgo.equals(that.clasificaRiesgo) : that.clasificaRiesgo != null)
            return false;
        if (condicionPago != null ? !condicionPago.equals(that.condicionPago) : that.condicionPago != null)
            return false;
        if (estadoLinea != null ? !estadoLinea.equals(that.estadoLinea) : that.estadoLinea != null) return false;
        if (lineaCredito != null ? !lineaCredito.equals(that.lineaCredito) : that.lineaCredito != null) return false;
        if (lineaCreditoDisponible != null ? !lineaCreditoDisponible.equals(that.lineaCreditoDisponible) : that.lineaCreditoDisponible != null)
            return false;
        if (lineaCreditoUtilizada != null ? !lineaCreditoUtilizada.equals(that.lineaCreditoUtilizada) : that.lineaCreditoUtilizada != null)
            return false;
        if (montoSeguro != null ? !montoSeguro.equals(that.montoSeguro) : that.montoSeguro != null) return false;
        if (montoSeguroUf != null ? !montoSeguroUf.equals(that.montoSeguroUf) : that.montoSeguroUf != null)
            return false;
        if (nomCliente != null ? !nomCliente.equals(that.nomCliente) : that.nomCliente != null) return false;
        if (pedProc != null ? !pedProc.equals(that.pedProc) : that.pedProc != null) return false;
        if (rut != null ? !rut.equals(that.rut) : that.rut != null) return false;
        if (seguro != null ? !seguro.equals(that.seguro) : that.seguro != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (tipoSeguro != null ? !tipoSeguro.equals(that.tipoSeguro) : that.tipoSeguro != null) return false;
        if (vigSeg != null ? !vigSeg.equals(that.vigSeg) : that.vigSeg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (rut != null ? rut.hashCode() : 0);
        result = 31 * result + (nomCliente != null ? nomCliente.hashCode() : 0);
        result = 31 * result + (seguro != null ? seguro.hashCode() : 0);
        result = 31 * result + (tipoSeguro != null ? tipoSeguro.hashCode() : 0);
        result = 31 * result + (montoSeguro != null ? montoSeguro.hashCode() : 0);
        result = 31 * result + (lineaCredito != null ? lineaCredito.hashCode() : 0);
        result = 31 * result + (bloqueo != null ? bloqueo.hashCode() : 0);
        result = 31 * result + (condicionPago != null ? condicionPago.hashCode() : 0);
        result = 31 * result + (pedProc != null ? pedProc.hashCode() : 0);
        result = 31 * result + (clasificaRiesgo != null ? clasificaRiesgo.hashCode() : 0);
        result = 31 * result + (vigSeg != null ? vigSeg.hashCode() : 0);
        result = 31 * result + (canalVenta != null ? canalVenta.hashCode() : 0);
        result = 31 * result + (lineaCreditoUtilizada != null ? lineaCreditoUtilizada.hashCode() : 0);
        result = 31 * result + (lineaCreditoDisponible != null ? lineaCreditoDisponible.hashCode() : 0);
        result = 31 * result + (montoSeguroUf != null ? montoSeguroUf.hashCode() : 0);
        result = 31 * result + (estadoLinea != null ? estadoLinea.hashCode() : 0);
        return result;
    }
}
