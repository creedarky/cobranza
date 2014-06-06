package cl.acaya.api.vo;

/**
 * Created by darkmoorx on 05-06-14.
 */
public class VendedorVO {

    private Long systemId;
    private String codigoVendedor;
    private String nombreVendedor;
    private String emailVendedor;
    private String fonoVendedor1;
    private String fonoVendedor2;
    private String fonoVendedor3;

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }

    public String getFonoVendedor1() {
        return fonoVendedor1;
    }

    public void setFonoVendedor1(String fonoVendedor1) {
        this.fonoVendedor1 = fonoVendedor1;
    }

    public String getFonoVendedor2() {
        return fonoVendedor2;
    }

    public void setFonoVendedor2(String fonoVendedor2) {
        this.fonoVendedor2 = fonoVendedor2;
    }

    public String getFonoVendedor3() {
        return fonoVendedor3;
    }

    public void setFonoVendedor3(String fonoVendedor3) {
        this.fonoVendedor3 = fonoVendedor3;
    }

}
