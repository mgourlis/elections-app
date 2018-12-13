package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author myrgo
 */
@Entity
@Table(name = "electoralDistrict")
@AttributeOverride(name = "id", column = @Column(name = "electoralDistrict_id", nullable = false, columnDefinition = "BIGINT"))
public class ElectoralDistrict extends BaseEntity{
    
    @Column(name = "code", unique = true, length = 7, nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "synoikismosName", nullable = true)
    private String synoikismosName;
    
    @Column(name = "isMandatoryAddress", nullable = false)
    private boolean isMandatoryAddress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otaDistrict_id", nullable = false)
    private OtaDistrict otaDistrict;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralDistrict")
    private List<ElectoralDepartment> electoralDepartments = new ArrayList<>();
    
}
