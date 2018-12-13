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
@Table(name = "electoralDepartment")
@AttributeOverride(name = "id", column = @Column(name = "electoralDepartment_id", nullable = false, columnDefinition = "BIGINT"))
public class ElectoralDepartment extends BaseEntity{
    
    @Column(name = "tempDeptAA", nullable = true)
    private int tempDeptAA;
    
    @Column(name = "deptAA", nullable = true)
    private int deptAA;
    
    @Column(name = "fromAA", nullable = true)
    private int fromAA;
    
    @Column(name = "toAA", nullable = true)
    private int toAA;
    
    @Column(name = "fromSurname", nullable = true)
    private String fromSurname;
    
    @Column(name = "toSurname", nullable = true)
    private String toSurname;
    
    @Column(name = "isEtero", nullable = false)
    private boolean isEtero;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralDepartmentEteroType_id", nullable = true)
    private ElectoralDepartmentEteroType eteroType;
    
    @Column(name = "isEuro", nullable = false)
    private boolean isEuro;
    
    @Column(name = "isSpecial", nullable = false)
    private boolean isSpecial;
    
    @Column(name = "isOmytx", nullable = false)
    private boolean isOmytx;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralDistrict_id", nullable = true)
    private ElectoralDistrict electoralDistrict;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralPeriphery_id", nullable = false)
    private ElectoralPeriphery electoralPeriphery;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralDepartment")
    private List<ElectoralDepartmentResult> electoralDepartmentResults = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electoralDepartment")
    private List<Votes> voteCounList = new ArrayList<>();
    
}
