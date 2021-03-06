package cl.acaya.api.vo;

import java.io.Serializable;

/**
 * Created by darkmoorx on 12-06-14.
 */
public class ContingenciaVO implements Serializable{

    private Integer idContingencia;
    private String contingencia;
    private Integer linkTipoContig;
    private String tipo;

    public Integer getIdContingencia() {
        return idContingencia;
    }

    public void setIdContingencia(Integer idContingencia) {
        this.idContingencia = idContingencia;
    }

    public String getContingencia() {
        return contingencia;
    }

    public void setContingencia(String contingencia) {
        this.contingencia = contingencia;
    }

    public Integer getLinkTipoContig() {
        return linkTipoContig;
    }

    public void setLinkTipoContig(Integer linkTipoContig) {
        this.linkTipoContig = linkTipoContig;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public ContingenciaVO clone() throws CloneNotSupportedException {
        ContingenciaVO contingenciaVO = new ContingenciaVO();
        contingenciaVO.setIdContingencia(idContingencia);
        contingenciaVO.setContingencia(contingencia);
        contingenciaVO.setLinkTipoContig(linkTipoContig);
        contingenciaVO.setTipo(tipo);
        return contingenciaVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContingenciaVO contingenciaVO = (ContingenciaVO) o;

        if (contingencia != null ? !contingencia.equals(contingenciaVO.contingencia) : contingenciaVO.contingencia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return contingencia != null ? contingencia.hashCode() : 0;
    }

}
