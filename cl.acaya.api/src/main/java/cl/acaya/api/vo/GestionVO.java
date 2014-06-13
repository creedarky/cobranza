package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by mcastro on 13-06-14.
 */
public class GestionVO implements Serializable{

    private Long idCliente;
    private Long idContacto;
    private String observacion;
    private Long[] idDocumentosContingencia = {} ;
    private Integer[] idContingencias = {};
    private String[] observacionesContingencia = {};
    private Long[] idDocumentosValidados = {};
    private Long[] idDocumentosRecaudados = {};
    private RecaudaVO recaudaVO;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    public Long[] getIdDocumentosValidados() {
        return idDocumentosValidados;
    }

    public void setIdDocumentosValidados(Long[] idDocumentosValidados) {
        this.idDocumentosValidados = idDocumentosValidados;
    }

    public Long[] getIdDocumentosRecaudados() {
        return idDocumentosRecaudados;
    }

    public void setIdDocumentosRecaudados(Long[] idDocumentosRecaudados) {
        this.idDocumentosRecaudados = idDocumentosRecaudados;
    }

    public RecaudaVO getRecaudaVO() {
        return recaudaVO;
    }

    public void setRecaudaVO(RecaudaVO recaudaVO) {
        this.recaudaVO = recaudaVO;
    }

    public Long[] getIdDocumentosContingencia() {
        return idDocumentosContingencia;
    }

    public void setIdDocumentosContingencia(Long[] idDocumentosContingencia) {
        this.idDocumentosContingencia = idDocumentosContingencia;
    }

    public Integer[] getIdContingencias() {
        return idContingencias;
    }

    public void setIdContingencias(Integer[] idContingencias) {
        this.idContingencias = idContingencias;
    }

    public String[] getObservacionesContingencia() {
        return observacionesContingencia;
    }

    public void setObservacionesContingencia(String[] observacionesContingencia) {
        this.observacionesContingencia = observacionesContingencia;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public String toString() {
        return "GestionVO{" +
                "idCliente=" + idCliente +
                ", observacion='" + observacion + '\'' +
                ", idDocumentosContingencia=" + Arrays.toString(idDocumentosContingencia) +
                ", idContingencias=" + Arrays.toString(idContingencias) +
                ", observacionesContingencia=" + Arrays.toString(observacionesContingencia) +
                ", idDocumentosValidados=" + Arrays.toString(idDocumentosValidados) +
                ", idDocumentosRecaudados=" + Arrays.toString(idDocumentosRecaudados) +
                ", recaudaVO=" + recaudaVO +
                '}';
    }
}
