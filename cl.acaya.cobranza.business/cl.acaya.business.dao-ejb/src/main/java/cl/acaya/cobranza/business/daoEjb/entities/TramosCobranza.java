package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */


@Entity
@Table(name = "TBL_TRAMOS_COB")
@NamedQueries({@NamedQuery(name="TramosCobranza.findAll",query = "Select cn From TramosCobranza cn")})
//@SequenceGenerator(name = "TramosCobranzaSeq",
//        sequenceName = "SEQ_TramosCobranza", allocationSize = 1, initialValue = 1)


public class TramosCobranza {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_TramosCobranza", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_TramosCobranza"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TramosCobranza")    private Long systemId;

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
