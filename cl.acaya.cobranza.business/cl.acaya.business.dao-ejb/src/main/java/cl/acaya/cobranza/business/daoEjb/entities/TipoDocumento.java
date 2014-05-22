package cl.acaya.cobranza.business.daoEjb.entities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_TIPO_DOCUMENTO")
@NamedQueries({@NamedQuery(name="TipoDocumento.findAll",query = "Select cn From TipoDocumento cn")})
@SequenceGenerator(name = "TipoDocumentoSeq",
        sequenceName = "SEQ_TipoDocumento", allocationSize = 1, initialValue = 1)

public class TipoDocumento {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TipoDocumentoSeq")
    private Long systemId;

    @Column(name = "cod_tipo")
    private String codigoTipo;

    @Column(name = "nom_tipo")
    private String nombreTipo;

    public TipoDocumento(){

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
