package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_SOCIEDAD")
@NamedQueries({@NamedQuery(name="Sociedad.findAll",query = "Select cn From Sociedad cn")})
@SequenceGenerator(name = "SociedadSeq",
        sequenceName = "SEQ_Sociedad", allocationSize = 1, initialValue = 1)

public class Sociedad {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SociedadSeq")
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
