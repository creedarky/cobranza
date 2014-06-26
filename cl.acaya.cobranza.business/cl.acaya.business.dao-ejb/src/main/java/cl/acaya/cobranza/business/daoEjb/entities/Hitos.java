package cl.acaya.cobranza.business.daoEjb.entities;

import cl.acaya.api.enums.EtapasDocumentoType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_hitos", schema = "dbo", catalog = "COBRANZA")
@NamedQueries({@NamedQuery(name = "Hitos.findByCliente", query = "from Hitos h left join fetch h.documento d " +
        "left join fetch h.usuario u left join fetch h.contacto cn left join fetch cn.cargo cr " +
        "where h.cliente.systemId = :idCliente"),
@NamedQuery(name = "Hitos.findDocumentos", query = "from Hitos  where documento.systemId in (:idDocumentos)")})
public class Hitos {

    private Integer systemId;
    private Documento documento;
    private Cliente Cliente;
    private EtapasDocumentoType etapa;
    private Usuario usuario;
    private ContactoCliente contacto;
    private Date fechaHito;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_hitos", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_hitos"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_hitos")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
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
        return Cliente;
    }

    public void setCliente(Cliente linkCliente) {
        this.Cliente = linkCliente;
    }

    @Column(name = "link_doc_etapa")
    public EtapasDocumentoType getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapasDocumentoType etapa) {
        this.etapa = etapa;
    }

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario linkUsuario) {
        this.usuario = linkUsuario;
    }


    @JoinColumn(name = "link_contacto", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)

    public ContactoCliente getContacto() {
        return contacto;
    }

    public void setContacto(ContactoCliente linkContacto) {
        this.contacto = linkContacto;
    }

    @Basic
    @Column(name = "fecha_hito")
    public Date getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Date fechaHito) {
        this.fechaHito = fechaHito;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hitos hitos = (Hitos) o;

        if (fechaHito != null ? !fechaHito.equals(hitos.fechaHito) : hitos.fechaHito != null) return false;
        if (Cliente != null ? !Cliente.equals(hitos.Cliente) : hitos.Cliente != null) return false;
        if (contacto != null ? !contacto.equals(hitos.contacto) : hitos.contacto != null) return false;
        if (etapa != null ? !etapa.equals(hitos.etapa) : hitos.etapa != null) return false;
        if (documento != null ? !documento.equals(hitos.documento) : hitos.documento != null)
            return false;
        if (usuario != null ? !usuario.equals(hitos.usuario) : hitos.usuario != null) return false;
        if (systemId != null ? !systemId.equals(hitos.systemId) : hitos.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (Cliente != null ? Cliente.hashCode() : 0);
        result = 31 * result + (etapa != null ? etapa.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contacto != null ? contacto.hashCode() : 0);
        result = 31 * result + (fechaHito != null ? fechaHito.hashCode() : 0);
        return result;
    }
}
