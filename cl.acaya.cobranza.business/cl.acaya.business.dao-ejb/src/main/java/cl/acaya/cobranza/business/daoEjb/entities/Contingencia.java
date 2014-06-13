package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "tbl_contingencia", schema = "dbo", catalog = "COBRANZA")
@NamedQueries({@NamedQuery(name="Contingencia.findAll",query = "Select cn From Contingencia cn order by cn.contingencia asc")})
public class Contingencia {
    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_contingencia", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_contingencia"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_contingencia")
    private Integer systemId;

    @Basic
    @Column(name = "contingencia")
    private String contingencia;

    @JoinColumn(name = "link_tipo_contig", referencedColumnName = "system_id")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private TipoContingencia tipoContingencia;

    @Basic
    @Column(name = "tipo")
    private String tipo;


    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }


    public String getContingencia() {
        return contingencia;
    }

    public void setContingencia(String contingencia) {
        this.contingencia = contingencia;
    }


    public TipoContingencia getTipoContingencia() {
        return tipoContingencia;
    }

    public void setTipoContingencia(TipoContingencia linkTipoContig) {
        this.tipoContingencia = linkTipoContig;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contingencia that = (Contingencia) o;

        if (contingencia != null ? !contingencia.equals(that.contingencia) : that.contingencia != null) return false;
        if (tipoContingencia != null ? !tipoContingencia.equals(that.tipoContingencia) : that.tipoContingencia != null)
            return false;
        if (systemId != null ? !systemId.equals(that.systemId) : that.systemId != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (contingencia != null ? contingencia.hashCode() : 0);
        result = 31 * result + (tipoContingencia != null ? tipoContingencia.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
