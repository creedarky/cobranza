package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_logsistema", schema = "dbo", catalog = "COBRANZA")
public class LogSistema {
    private Integer systemId;
    private String usuLog;
    private Timestamp fechaLog;
    private Integer linkUsuario;
    private Integer linkDocumento;
    private Integer linkCliente;

    @Basic
    @Column(name = "system_id")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "usu_log")
    public String getUsuLog() {
        return usuLog;
    }

    public void setUsuLog(String usuLog) {
        this.usuLog = usuLog;
    }

    @Basic
    @Column(name = "fecha_log")
    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }

    @Basic
    @Column(name = "link_usuario")
    public Integer getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Integer linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    @Basic
    @Column(name = "link_documento")
    public Integer getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(Integer linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    @Basic
    @Column(name = "link_cliente")
    public Integer getLinkCliente() {
        return linkCliente;
    }

    public void setLinkCliente(Integer linkCliente) {
        this.linkCliente = linkCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogSistema that = (LogSistema) o;

        if (fechaLog != null ? !fechaLog.equals(that.fechaLog) : that.fechaLog != null) return false;
        if (linkCliente != null ? !linkCliente.equals(that.linkCliente) : that.linkCliente != null) return false;
        if (linkDocumento != null ? !linkDocumento.equals(that.linkDocumento) : that.linkDocumento != null)
            return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (usuLog != null ? !usuLog.equals(that.usuLog) : that.usuLog != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (usuLog != null ? usuLog.hashCode() : 0);
        result = 31 * result + (fechaLog != null ? fechaLog.hashCode() : 0);
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        result = 31 * result + (linkDocumento != null ? linkDocumento.hashCode() : 0);
        result = 31 * result + (linkCliente != null ? linkCliente.hashCode() : 0);
        return result;
    }
}
