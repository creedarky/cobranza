package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kiosolutions
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -4565097383655842799L;
    private RespStatus status = RespStatus.FAIL;
    private List<Mensaje> mensajes = new ArrayList<Mensaje>();
    private Map<String, Object> resp = new HashMap<String, Object>();

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void addAllMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public Object getResp(String prm) {
        return resp.get(prm);
    }

    public Map<String, Object> getAllResp() {
        return resp;
    }

    public <T extends Object> T getResp(String valueName, Class<T> type) {
        try {
            return type.cast(resp.get(valueName));
        } catch (Exception e) {
            return null;
        }
    }

    public void addResp(String prm, Object resp) {
        this.resp.put(prm, resp);
    }

    public void addMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

    public boolean isOK() {
        return status != null && status.equals(RespStatus.SUCCESS);
    }

    public boolean isFail() {
        return status != null && status.equals(RespStatus.FAIL);
    }

    public boolean isEmpty() {
        return status != null && status.equals(RespStatus.EMPTY);
    }

    public void fail() {
        status = RespStatus.FAIL;
    }

    public void success() {
        status = RespStatus.SUCCESS;
    }

    public void empty() {
        status = RespStatus.EMPTY;
    }

    public void setStatus(RespStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("RespStatus:%s, isOK:%s, %s mensajes", status, isOK(), (mensajes != null ? mensajes.size() : "null"));
    }

}
