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
@Table(name = "otaDistrict")
@AttributeOverride(name = "id", column = @Column(name = "otaDistrict_id", nullable = false, columnDefinition = "BIGINT"))
public class OtaDistrict extends BaseEntity{
    
    @Column(name = "code", unique = true, length = 4, nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "isCapital", nullable = false)
    private boolean isCapital;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "otaDistrictType_id", nullable = false)
    private OtaDistrictType otaDistrictType;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralPeriphery_id", nullable = false)
    private ElectoralPeriphery electoralPeriphery;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "otaDistrict")
    private List<ElectoralDistrict> electoralDistricts = new ArrayList<>();
    
}
