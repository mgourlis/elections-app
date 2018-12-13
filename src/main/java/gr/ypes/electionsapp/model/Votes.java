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
@Table(name = "votes")
@AttributeOverride(name = "id", column = @Column(name = "votes_id", nullable = false, columnDefinition = "BIGINT"))
public class Votes extends BaseEntity{
    
    @Column(name = "votesCount", nullable = false)
    private int votesCount;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "electoralDepartment_id", nullable = false)
    private ElectoralDepartment electoralDepartment;
    
}
