package cl.acaya.web.ws.response;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ulayera
 * Date: 04-12-13
 * Time: 12:39 PM
 */
@XmlType(name = "NotificarFacturaAceptaResponse", namespace = "/model/NotificarFacturaAceptaResponse")
public class NotificarFacturaAceptaResponse implements Serializable {
    private Boolean success;
    private String errorMensaje;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMensaje() {
        return errorMensaje;
    }

    public void setErrorMensaje(String errorMensaje) {
        this.errorMensaje = errorMensaje;
    }

    @Override
    public String toString() {
        return "NotificarFacturaAceptaResponse{" +
                ", success=" + success +
                ", errorMensaje='" + errorMensaje + '\'' +
                '}';
    }
}
