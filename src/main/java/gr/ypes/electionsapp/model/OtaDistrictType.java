package gr.ypes.electionsapp.model;

import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author myrgo
 */
@Entity
@Table(name = "otaDistrictType")
@AttributeOverride(name = "id", column = @Column(name = "otaDistrictType_id", nullable = false, columnDefinition = "BIGINT"))
public class OtaDistrictType extends BaseEntity{
    
    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final OtaDistrictType other = (OtaDistrictType) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OtaDistrictType{" + "name=" + name + '}';
    }
    
}
