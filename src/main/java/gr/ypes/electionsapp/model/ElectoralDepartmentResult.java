package gr.ypes.electionsapp.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author myrgo
 */
@Entity
@Table(name = "electoralDepartmentResult")
@AttributeOverride(name = "id", column = @Column(name = "electoralDepartmentResult_id", nullable = false, columnDefinition = "BIGINT"))
public class ElectoralDepartmentResult extends BaseEntity{
    
    @Column(name = "totalElectors", nullable = false)
    private int totalElectors;
    
    @Column(name = "votedCount", nullable = false)
    private int votedCount;
    
    @Column(name = "invalidVotes", nullable = false)
    private int invalidVotes;
    
    @Column(name = "blankVotes", nullable = false)
    private int blankVotes;
    
    @Column(name = "validVotes", nullable = false)
    private int validVotes;
    
    @Column(name = "invalidBlankVotes", nullable = false)
    private int invalidBlankVotes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralDepartment_id", nullable = false)
    private ElectoralDepartment electoralDepartment;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electionType_id", nullable = false)
    private ElectionType electionType;
    
}
