package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_SOCIEDAD")
@NamedQueries({@NamedQuery(name="Sociedad.findAll",query = "Select cn From Sociedad cn"),
@NamedQuery(name = "Sociedad.findByCodigo", query = "from Sociedad where codigoSociedad = :codigo")})
//@SequenceGenerator(name = "SociedadSeq",
//        sequenceName = "SEQ_Sociedad", allocationSize = 1, initialValue = 1)

public class Sociedad {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Sociedad", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_Sociedad"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Sociedad")
    private Long systemId;

    @Column(name = "cod_sociedad")
    private String codigoSociedad;

    @Column(name = "nom_sociedad")
    private String nombreSociedad;

    public Sociedad(){


    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoSociedad() {
        return codigoSociedad;
    }

    public void setCodigoSociedad(String codigoSociedad) {
        this.codigoSociedad = codigoSociedad;
    }

    public String getNombreSociedad() {
        return nombreSociedad;
    }

    public void setNombreSociedad(String nombreSociedad) {
        this.nombreSociedad = nombreSociedad;
    }
}
