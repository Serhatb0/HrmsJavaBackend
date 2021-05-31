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
@Table(name = "social_medias")
public class SocialMedia {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "social_media_id")
	private int socialMediaId;

//	@Column(name = "candidate_id")
//	private int candidateId;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
}
