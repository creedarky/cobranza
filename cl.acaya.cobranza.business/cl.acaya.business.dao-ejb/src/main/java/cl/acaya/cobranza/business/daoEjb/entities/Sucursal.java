package cl.acaya.cobranza.business.daoEjb.entities;

import cl.acaya.api.business.BusinessParameter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by darkmoorx on 19-05-14.
 */

@Entity
@Table(name = "TBL_SUCURSAL", schema = BusinessParameter.DB_SCHEMA)
@NamedQueries({@NamedQuery(name="Sucursal.findAll",query = "Select cn From Sucursal cn")})
//@SequenceGenerator(name = "SucursalSeq",
//        sequenceName = "SEQ_Sucursal", allocationSize = 1, initialValue = 1)


public class  Sucursal {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_Sucursal", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_Sucursal"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Sucursal")
    private Long systemId;

    @Column(name = "cod_sucursal")
    private String codigoSucursal;

    @Column(name = "nom_sucursal")
    private String nombreSucursal;

    @JoinColumn(name = "link_zona")  // COD_TIPO_NEGOCIO_PE_FK
    @ManyToOne
    private Zona zona;

    public Sucursal() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
