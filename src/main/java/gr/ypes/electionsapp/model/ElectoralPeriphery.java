package gr.ypes.electionsapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "electoralPeriphery")
@AttributeOverride(name = "id", column = @Column(name = "electoralPeriphery_id", nullable = false, columnDefinition = "BIGINT"))
public class ElectoralPeriphery extends BaseEntity{
    
    @Column(name = "code", nullable = false, unique = true, length = 2)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "isEforosAttended", nullable = false)
    private boolean isEforosAttended;
    
    @Column(name = "totalSubstitutes")
    private int totalSubstitutes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id")
    private GreekPeriphery greekPeriphery;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "electoralPeriphery_peripheryDistrict",
        joinColumns = @JoinColumn(name = "electoralPeriphery_id"),
        inverseJoinColumns = @JoinColumn(name = "peripheryDistrict_id")
    )
    private Set<PeripheryDistrict> peripheryDistricts = new HashSet<>();

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

    public boolean isIsEforosAttended() {
        return isEforosAttended;
    }

    public void setIsEforosAttended(boolean isEforosAttended) {
        this.isEforosAttended = isEforosAttended;
    }

    public int getTotalSubstitutes() {
        return totalSubstitutes;
    }

    public void setTotalSubstitutes(int totalSubstitutes) {
        this.totalSubstitutes = totalSubstitutes;
    }

    public GreekPeriphery getGreekPeriphery() {
        return greekPeriphery;
    }

    public void setGreekPeriphery(GreekPeriphery greekPeriphery) {
        this.greekPeriphery = greekPeriphery;
    }

    public Set<PeripheryDistrict> getPeripheryDistricts() {
        return peripheryDistricts;
    }
    
    public void addPeripheryDistrict(PeripheryDistrict peripheryDistrict){
        this.peripheryDistricts.add(peripheryDistrict);
    }

    public void removePeripheryDistrict(PeripheryDistrict peripheryDistrict){
        this.peripheryDistricts.remove(peripheryDistrict);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.code);
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final ElectoralPeriphery other = (ElectoralPeriphery) obj;
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
        return "ElectoralPeriphery{" + "code=" + code + ", name=" + name + ", isEforosAttended=" + isEforosAttended + ", totalSubstitutes=" + totalSubstitutes + '}';
    }
    
    
}
