package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiosolutions
 */
public class JsonResponse implements Serializable {

    private static final long serialVersionUID = 4776919619627439711L;
    private Boolean success = false;
    private Object body = "empty";
    private List<String> mensajes = new ArrayList<String>();
    private String urlRedirect = null;

    public JsonResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccessToTrue() {
        success = true;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void addMensaje(String mensaje) {
        mensajes.add(mensaje);
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void addMensajes(final List<Mensaje> mensajes) {
        for (Mensaje mensaje : mensajes) {
            this.mensajes.add(mensaje.getTexto());
        }
    }

    public void addAll(final List<String> mensajes) {
        this.mensajes.addAll(mensajes);
    }

    public void setUrlRedirect(String urlRedirect) {
        this.urlRedirect = urlRedirect;
    }

    public String getUrlRedirect() {
        return urlRedirect;
    }

    public void setSuccessToFalse() {
        success = false;
    }
}
