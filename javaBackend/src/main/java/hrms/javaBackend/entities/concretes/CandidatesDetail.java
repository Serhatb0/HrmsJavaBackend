package hrms.javaBackend.entities.concretes;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "candidates_details")
public class CandidatesDetail {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="candidates_details_id")
	private int candidatesDetailsId;
	
	@Column(name="technology_name")
	private String technologyName;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

	
//	@Column(name="candidate_id")
//	private int candidateId;


	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
}
