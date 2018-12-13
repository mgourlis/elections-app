package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author myrgourlis
 */
@Entity
@Table(name = "electoralPeriphery")
@AttributeOverride(name = "id", column = @Column(name = "electoralPeriphery_id", nullable = false, columnDefinition = "BIGINT"))
public class ElectoralPeriphery extends BaseEntity{
    
    @Column(name = "code", unique = true, length = 2, nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id", nullable = false)
    private GreekPeriphery greekPeriphery;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "electoralPeriphery_peripheryDistrict",
        joinColumns = @JoinColumn(name = "electoralPeriphery_id"),
        inverseJoinColumns = @JoinColumn(name = "peripheryDistrict_id")
    )
    private Set<PeripheryDistrict> peripheryDistricts = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralPeriphery")
    private List<Ota> otas = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralPeriphery")
    private List<OtaDistrict> otaDistricts = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralPeriphery")
    private List<ElectoralDepartment> electoralDepartments = new ArrayList<>();

}
