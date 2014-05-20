package cl.acaya.cobranza.business.dao.entity.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */


@Entity
@Table(name = "TBL_TRAMOS_COB")
@NamedQueries({@NamedQuery(name="TramosCobranza.findAll",query = "Select cn From TramosCobranza cn")})
@SequenceGenerator(name = "TramosCobranzaSeq",
        sequenceName = "SEQ_TramosCobranza", allocationSize = 1, initialValue = 1)


public class TramosCobranza {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TramosCobranzaSeq")
    private Long systemId;

    @Column(name = "nom_tramo")
    private String nombreTramo;

    @Column(name = "dias_tramo")
    private String diasTramo;

    public Long getSystemId() {
        return systemId;
    }

    public TramosCobranza(){


    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getNombreTramo() {
        return nombreTramo;
    }

    public void setNombreTramo(String nombreTramo) {
        this.nombreTramo = nombreTramo;
    }

    public String getDiasTramo() {
        return diasTramo;
    }

    public void setDiasTramo(String diasTramo) {
        this.diasTramo = diasTramo;
    }
}
