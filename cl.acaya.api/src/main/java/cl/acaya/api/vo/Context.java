package cl.acaya.api.vo;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author Kiosolutions
 */
public class Context implements Serializable {

    private static final long serialVersionUID = 783938273750057046L;
    private String remoteHost;
    private String username;
    private Long userId;
    private Locale locale;

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
