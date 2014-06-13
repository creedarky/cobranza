package cl.acaya.cobranza.business.daoEjb.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_TIPO_CONTINGENCIA")
@NamedQueries({@NamedQuery(name="TipoContingencia.findAll",query = "Select cn From TipoContingencia cn")
})
public class TipoContingencia {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_tipoDocumento", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @Parameter(name = "table_name", value = "hibernate_sequences"),
                    @Parameter(name = "segment_value", value = "SEQ_tipoDocumento"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")})
    @GeneratedValue(generator = "SEQ_tipoDocumento")
    private Long systemId;


    @Column(name = "tipo_contingencia")
    private String tipo;


    public TipoContingencia() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
