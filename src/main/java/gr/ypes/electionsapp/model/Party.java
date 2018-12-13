package gr.ypes.electionsapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
 * @author myrgourlis
 */
@Entity
@Table(name = "party")
@AttributeOverride(name = "id", column = @Column(name = "party_id", nullable = false, columnDefinition = "BIGINT"))
public class Party extends BaseEntity{
    
    @Column(name = "code", unique = true, nullable = false)
    private int code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="greekPeriphery_id", nullable = true)
    private GreekPeriphery greekPeriphery;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ota_id", nullable = true)
    private Ota ota;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="electionType_id", nullable = false)
    private ElectionType electionType;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "party")
    private List<Votes> voteCountList = new ArrayList<>();
    
}
