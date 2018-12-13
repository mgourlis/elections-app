package gr.ypes.electionsapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "peripheryDistrict")
@AttributeOverride(name = "id", column = @Column(name = "peripheryDistrict_id", nullable = false, columnDefinition = "BIGINT"))
public class PeripheryDistrict extends BaseEntity {
    
    @Column(name = "code", nullable = false, unique = true, length = 4)
    private String code;
    
    @Column(name = "name",nullable = false)
    private String name;
    
    @Column(name = "isCapital")
    @NotNull
    private boolean isCapital;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id")
    private GreekPeriphery greekPeriphery;
    
    @ManyToMany(mappedBy = "peripheryDistricts")
    private Set<ElectoralPeriphery> electoralPeripheries = new HashSet<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsCapital() {
        return isCapital;
    }

    public void setIsCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }

    public GreekPeriphery getGreekPeriphery() {
        return greekPeriphery;
    }

    public void setGreekPeriphery(GreekPeriphery greekPeriphery) {
        this.greekPeriphery = greekPeriphery;
    }
    
    public Set<ElectoralPeriphery> getElectoralPeripheries() {
        return electoralPeripheries;
    }
    
    public void addElectoralPeriphery(ElectoralPeriphery electoralPeriphery){
        this.electoralPeripheries.add(electoralPeriphery);
    }

    public void removeElectoralPeriphery(ElectoralPeriphery electoralPeriphery){
        this.electoralPeripheries.remove(electoralPeriphery);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.code);
        hash = 19 * hash + Objects.hashCode(this.name);
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
        final PeripheryDistrict other = (PeripheryDistrict) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PeripheryDistrict{" + "code=" + code + ", name=" + name + ", isCapital=" + isCapital + '}';
    }

}
