package cl.acaya.cobranza.business.daoEjb.entities;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Parameter;
import javax.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_agenda", schema = "dbo", catalog = "COBRANZA")
public class Agenda {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_AGENDA", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_AGENDA"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "SEQ_AGENDA")
    private Integer systemId;

    @JoinColumn(name = "link_usuario")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "link_cliente")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "link_contacto")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private ContactoCliente contacto;

    @Column(name = "fec_agenda")
    private Date fecAgenda;

    @Column(name = "realizada")
    private Boolean realizada;

    @Column(name = "comentario")
    private String comentario;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="tbl_agenda_docs",
            joinColumns={@JoinColumn(name="link_agenda")},
            inverseJoinColumns={@JoinColumn(name="link_documento")})
    private Set<Documento> documentos = new HashSet<Documento>();


    public Agenda() {
        realizada = Boolean.FALSE;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecAgenda() {
        return fecAgenda;
    }

    public void setFecAgenda(Date fecAgenda) {
        this.fecAgenda = fecAgenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ContactoCliente getContacto() {
        return contacto;
    }

    public void setContacto(ContactoCliente contacto) {
        this.contacto = contacto;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Set<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Set<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agenda agenda = (Agenda) o;

        if (systemId != null ? !systemId.equals(agenda.systemId) : agenda.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (fecAgenda != null ? fecAgenda.hashCode() : 0);
        result = 31 * result + (realizada != null ? realizada.hashCode() : 0);
        return result;
    }
}
