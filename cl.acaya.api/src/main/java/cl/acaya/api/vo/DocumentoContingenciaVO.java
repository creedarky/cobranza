package cl.acaya.api.vo;

import java.io.Serializable;

/**
 * Created by mcastro on 13-06-14.
 */
public class DocumentoContingenciaVO implements Serializable{

    private Long idDocumento;
    private Long idContingencia;
    private String observacion;

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdContingencia() {
        return idContingencia;
    }

    public void setIdContingencia(Long idContingencia) {
        this.idContingencia = idContingencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "DocumentoContingenciaVO{" +
                "idDocumento=" + idDocumento +
                ", idContingencia=" + idContingencia +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
