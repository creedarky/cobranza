package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */
@Entity
@Table(name = "TBL_ZONA")
@NamedQueries({@NamedQuery(name="Zona.findAll",query = "Select cn From Zona cn")})
@SequenceGenerator(name = "ZonaSeq",
        sequenceName = "SEQ_Zona", allocationSize = 1, initialValue = 1)


public class Zona {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ZonaSeq")
    private Long systemId;

    @Column(name = "cod_zona")
    private String codigoZona;

    @Column(name = "nom_zona")
    private String nombreZona;

    public Zona() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }
}
