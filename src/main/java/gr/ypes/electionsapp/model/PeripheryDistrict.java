package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "peripheryDistrict")
@AttributeOverride(name = "id", column = @Column(name = "peripheryDistrict_id", nullable = false, columnDefinition = "BIGINT"))
public class PeripheryDistrict extends BaseEntity {
    
    @Column(name = "code", unique = true, length = 4, nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "isCapital", nullable = false)
    private boolean isCapital;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id", nullable = false)
    private GreekPeriphery greekPeriphery;
    
    @ManyToMany(mappedBy = "peripheryDistricts")
    private Set<ElectoralPeriphery> electoralPeripheries = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "periferyDistrict")
    private List<Ota> otas = new ArrayList<>();

}
