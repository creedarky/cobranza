package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private Usuario usuario;
    private Documento documento;
    private Cliente cliente;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_logSistema", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_logSistema"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_logSistema")
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

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario linkUsuario) {
        this.usuario = linkUsuario;
    }

    @JoinColumn(name = "link_documento", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento linkDocumento) {
        this.documento = linkDocumento;
    }

    @JoinColumn(name = "link_cliente", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente linkCliente) {
        this.cliente = linkCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogSistema that = (LogSistema) o;

        if (fechaLog != null ? !fechaLog.equals(that.fechaLog) : that.fechaLog != null) return false;
        if (cliente != null ? !cliente.equals(that.cliente) : that.cliente != null) return false;
        if (documento != null ? !documento.equals(that.documento) : that.documento != null)
            return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (usuLog != null ? !usuLog.equals(that.usuLog) : that.usuLog != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (usuLog != null ? usuLog.hashCode() : 0);
        result = 31 * result + (fechaLog != null ? fechaLog.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        return result;
    }
}
