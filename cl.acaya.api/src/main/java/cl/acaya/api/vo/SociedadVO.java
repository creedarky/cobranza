package cl.acaya.api.vo;

/**
 * Created by darkmoorx on 05-06-14.
 */
public class SociedadVO {

    private Long systemId;
    private String codigoSociedad;
    private String nombreSociedad;

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoSociedad() {
        return codigoSociedad;
    }

    public void setCodigoSociedad(String codigoSociedad) {
        this.codigoSociedad = codigoSociedad;
    }

    public String getNombreSociedad() {
        return nombreSociedad;
    }

    public void setNombreSociedad(String nombreSociedad) {
        this.nombreSociedad = nombreSociedad;
    }

}
