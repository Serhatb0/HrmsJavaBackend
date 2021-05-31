package hrms.javaBackend.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
	
	@Column(name="technology_names")
	private String technologyNames;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
//	@Column(name="candidate_id")
//	private int candidateId;
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
}
