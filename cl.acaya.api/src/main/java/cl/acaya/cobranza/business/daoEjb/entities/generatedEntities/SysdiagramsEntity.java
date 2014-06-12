package cl.acaya.cobranza.business.daoEjb.entities.generatedEntities;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by darkmoorx on 12-06-14.
 */
@Entity
@Table(name = "sysdiagrams", schema = "dbo", catalog = "COBRANZA")
public class SysdiagramsEntity {
    private String name;
    private Integer principalId;
    private Integer diagramId;
    private Integer version;
    private byte[] definition;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "principal_id")
    public Integer getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }

    @Id
    @Column(name = "diagram_id")
    public Integer getDiagramId() {
        return diagramId;
    }

    public void setDiagramId(Integer diagramId) {
        this.diagramId = diagramId;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "definition")
    public byte[] getDefinition() {
        return definition;
    }

    public void setDefinition(byte[] definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysdiagramsEntity that = (SysdiagramsEntity) o;

        if (!Arrays.equals(definition, that.definition)) return false;
        if (diagramId != null ? !diagramId.equals(that.diagramId) : that.diagramId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (principalId != null ? !principalId.equals(that.principalId) : that.principalId != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (principalId != null ? principalId.hashCode() : 0);
        result = 31 * result + (diagramId != null ? diagramId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (definition != null ? Arrays.hashCode(definition) : 0);
        return result;
    }
}
