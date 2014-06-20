package cl.acaya.cobranza.business.daoEjb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by darkmoorx on 20-05-14.
 */

@Entity
@Table(name = "TBL_CARGO_CONTACTO")
@NamedQueries({@NamedQuery(name="CargoContacto.findAll",query = "Select cn From CargoContacto cn"),
        @NamedQuery(name="CargoContacto.findByIdSAP",query = "Select cn From CargoContacto cn where cn.pafkt = :idSAP")})
//@SequenceGenerator(name = "CargoContactoSeq",
//        sequenceName = "SEQ_CargoContacto", allocationSize = 1, initialValue = 1)


public class CargoContacto {

    @Id
    @Basic(optional = false)
    @Column(name = "system_id")
    @GenericGenerator(name = "SEQ_CargoContacto", strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "table_name", value = "hibernate_sequences"),
                    @org.hibernate.annotations.Parameter(name = "segment_value", value = "SEQ_CargoContacto"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CargoContacto")
    private Long systemId;

    @Column(name = "cargo")
    private String cargoContacto;

    @Column(name = "mandato")
    private String mandato;

    @Column(name = "spras")
    private String spras;

    @Column(name = "pafkt")
    private String pafkt;

    public CargoContacto(){

    }




    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
    }

    public String getMandato() {
        return mandato;
    }

    public void setMandato(String mandato) {
        this.mandato = mandato;
    }

    public String getSpras() {
        return spras;
    }

    public void setSpras(String spras) {
        this.spras = spras;
    }

    public String getPafkt() {
        return pafkt;
    }

    public void setPafkt(String pafkt) {
        this.pafkt = pafkt;
    }
}
