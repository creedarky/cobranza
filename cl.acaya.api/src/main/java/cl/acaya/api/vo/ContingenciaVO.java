package cl.acaya.api.vo;

/**
 * Created by darkmoorx on 12-06-14.
 */
public class ContingenciaVO {

    private Integer systemId;
    private String contingencia;
    private Integer linkTipoContig;
    private String tipo;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
        contingenciaVO.setSystemId(systemId);
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

        if (contingencia != null ? !contingencia.equals(contingenciaVO.contingencia) : contingenciaVO.contingencia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return contingencia != null ? contingencia.hashCode() : 0;
    }

}
