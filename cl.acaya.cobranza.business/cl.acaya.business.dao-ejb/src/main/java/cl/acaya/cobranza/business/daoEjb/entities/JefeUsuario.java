package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_jefe_usuario", schema = "dbo", catalog = "COBRANZA")
public class JefeUsuario {
    private Integer systemId;
    private Usuario linkUsuario;
    private JefeUsuario linkJefe;

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_jefeUsuario", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_jefeUsuario"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_jefeUsuario")
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    @JoinColumn(name = "link_usuario", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getLinkUsuario() {
        return linkUsuario;
    }

    public void setLinkUsuario(Usuario linkUsuario) {
        this.linkUsuario = linkUsuario;
    }

    @JoinColumn(name = "link_jefe", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne(fetch = FetchType.LAZY)
    public JefeUsuario getLinkJefe() {
        return linkJefe;
    }

    public void setLinkJefe(JefeUsuario linkJefe) {
        this.linkJefe = linkJefe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JefeUsuario that = (JefeUsuario) o;

        if (linkJefe != null ? !linkJefe.equals(that.linkJefe) : that.linkJefe != null) return false;
        if (linkUsuario != null ? !linkUsuario.equals(that.linkUsuario) : that.linkUsuario != null) return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (linkUsuario != null ? linkUsuario.hashCode() : 0);
        result = 31 * result + (linkJefe != null ? linkJefe.hashCode() : 0);
        return result;
    }
}
