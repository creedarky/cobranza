package cl.acaya.cobranza.business.daoEjb.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_TIPO_DOCUMENTO")
@NamedQueries({@NamedQuery(name="TipoDocumento.findAll",query = "Select cn From TipoDocumento cn")
        ,@NamedQuery(name="TipoDocumento.findByCodigo", query = "from TipoDocumento t where codigoTipo = :codigoTipo")
})
public class TipoDocumento {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_tipoDocumento", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @Parameter(name = "table_name", value = "hibernate_sequences"),
                    @Parameter(name = "segment_value", value = "SEQ_tipoDocumento"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "SEQ_tipoDocumento")
    private Long systemId;

    @Column(name = "cod_tipo")
    private String codigoTipo;

    @Column(name = "nom_tipo")
    private String nombreTipo;

    @Column(name = "ind")
    private String indicadorSentido;

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

    public String getIndicadorSentido() {
        return indicadorSentido;
    }

    public void setIndicadorSentido(String indicadorSentido) {
        this.indicadorSentido = indicadorSentido;
    }
}
