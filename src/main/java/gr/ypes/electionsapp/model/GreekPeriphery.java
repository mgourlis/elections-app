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
/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "greekPeriphery")
@AttributeOverride(name = "id", column = @Column(name = "greekPeriphery_id", nullable = false, columnDefinition = "BIGINT"))
public class GreekPeriphery extends BaseEntity {

    @Column(name = "code", unique = true, length = 2, nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "greekPeriphery")
    private List<PeripheryDistrict> peripheryDistricts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "greekPeriphery")
    private List<ElectoralPeriphery> electoralPeripheries = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "greekPeriphery")
    private List<Party> parties = new ArrayList<>();

}
