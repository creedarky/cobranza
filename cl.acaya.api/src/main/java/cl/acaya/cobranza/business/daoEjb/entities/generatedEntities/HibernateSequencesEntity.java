package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.*;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "hibernate_sequences", schema = "dbo", catalog = "COBRANZA")
public class HibernateSequencesEntity {
    private String sequenceName;
    private Integer nextVal;

    @Id
    @Column(name = "sequence_name")
    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    @Basic
    @Column(name = "next_val")
    public Integer getNextVal() {
        return nextVal;
    }

    public void setNextVal(Integer nextVal) {
        this.nextVal = nextVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HibernateSequencesEntity that = (HibernateSequencesEntity) o;

        if (nextVal != null ? !nextVal.equals(that.nextVal) : that.nextVal != null) return false;
        if (sequenceName != null ? !sequenceName.equals(that.sequenceName) : that.sequenceName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequenceName != null ? sequenceName.hashCode() : 0;
        result = 31 * result + (nextVal != null ? nextVal.hashCode() : 0);
        return result;
    }
}
