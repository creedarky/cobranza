package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Kiosolutions
 */
public class Request implements Serializable {

    private static final long serialVersionUID = -2102694828588115106L;
    private Map<String, Object> params = new HashMap<String, Object>();
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void addParam(String param, Object value) {
        this.params.put(param, value);
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public Set<String> getParamNames() {
        return params.keySet();
    }

    /**
     * Obtiene un parametro, ver PcdcCommonTest
     *
     * @param param el nombre del paramtro
     * @param type
     * @param <T>   el tipo Java del parametro
     * @return
     */
    public <T extends Object> T getParam(String param, Class<T> type) {
        try {
            return type.cast(params.get(param));
        } catch (ClassCastException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Object getParam(String param) {
        return params.get(param);
    }

    public void deleteParam(String param) {
        params.remove(param);
    }

    public void deleteAllParams() {
        params.clear();
    }
}
