package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.AttributeOverride;
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
@Table(name = "ota")
@AttributeOverride(name = "id", column = @Column(name = "ota_id", nullable = false, columnDefinition = "BIGINT"))
public class Ota extends BaseEntity{
    
    @Column(name = "code", unique = true, length = 4, nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="peripheryDistrict_id", nullable = false)
    private PeripheryDistrict peripheryDistrict;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="electoralPeriphery_id", nullable = false)
    private ElectoralPeriphery electoralPeriphery;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ota")
    private List<OtaDistrict> otaDistricts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ota")
    private List<Party> parties = new ArrayList<>();
}
