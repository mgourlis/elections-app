package gr.ypes.electionsapp.model;

import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "party")
@AttributeOverride(name = "id", column = @Column(name = "party_id", nullable = false, columnDefinition = "BIGINT"))
public class Party extends BaseEntity{
    
    @Column(name = "code", nullable = false, unique = true)
    private int code;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id")
    private GreekPeriphery greekPeriphery;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="electionType_id")
    private ElectionType electionType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GreekPeriphery getGreekPeriphery() {
        return greekPeriphery;
    }

    public void setGreekPeriphery(GreekPeriphery greekPeriphery) {
        this.greekPeriphery = greekPeriphery;
    }

    public ElectionType getElectionType() {
        return electionType;
    }

    public void setElectionType(ElectionType electionType) {
        this.electionType = electionType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.code;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Party other = (Party) obj;
        if (this.code != other.code) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Party{" + "code=" + code + ", name=" + name + '}';
    }
    
}
