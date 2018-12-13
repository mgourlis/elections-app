package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "greekPeriphery")
@AttributeOverride(name = "id", column = @Column(name = "greekPeriphery_id", nullable = false, columnDefinition = "BIGINT"))
public class GreekPeriphery extends BaseEntity {

    @Column(name = "code", nullable = false, unique = true, length = 2)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "greekPeriphery", orphanRemoval = true)
    private List<PeripheryDistrict> peripheryDistricts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "greekPeriphery", orphanRemoval = true)
    private List<ElectoralPeriphery> electoralPeripheries = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "greekPeriphery")
    private List<Party> parties = new ArrayList<>();

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

    public List<PeripheryDistrict> getPeripheryDistricts() {
        return peripheryDistricts;
    }

    public void addPeripheryDistrict(PeripheryDistrict peripheryDistrict) {
        this.peripheryDistricts.add(peripheryDistrict);
        peripheryDistrict.setGreekPeriphery(this);
    }

    public void removePeripheryDistrict(PeripheryDistrict peripheryDistrict) {
        peripheryDistrict.setGreekPeriphery(null);
        this.peripheryDistricts.remove(peripheryDistrict);
        
    }

    public List<ElectoralPeriphery> getElectoralPeripheries() {
        return electoralPeripheries;
    }
    
    public void addElectoralPeriphery(ElectoralPeriphery electoralPeriphery) {
        this.electoralPeripheries.add(electoralPeriphery);
        electoralPeriphery.setGreekPeriphery(this);
    }

    public void removeElectoralPeriphery(ElectoralPeriphery electoralPeriphery) {
        electoralPeriphery.setGreekPeriphery(null);
        this.electoralPeripheries.remove(electoralPeriphery);
        
    }

    public List<Party> getParties() {
        return parties;
    }

    public void addParty(Party party){
        this.parties.add(party);
        party.setGreekPeriphery(this);
    }
    
    public void removeParty(Party party){
        party.setGreekPeriphery(null);
        this.parties.remove(party);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final GreekPeriphery other = (GreekPeriphery) obj;
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
        return "GreekPeriphery{" + "code=" + code + ", name=" + name + '}';
    }
    
}
