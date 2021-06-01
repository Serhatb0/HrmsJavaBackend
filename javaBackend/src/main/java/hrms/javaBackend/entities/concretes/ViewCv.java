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
@Table(name="view_cv")
public class ViewCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
//	@Column(name="candidate_cv_id")
//	private int candidateCvId;
//	@Column(name="candidates_details_id")
//	private int candidatesDetailsId;
//	@Column(name="education_id")
//	private int educationId;
//	@Column(name="foreign_languages_id")
//	private int foreignLanguagesId;
	
//	@Column(name="candidate_id")
//	private int candidateId;
//	
//	@Column(name="social_media_id")
//	private int socialMediaId;
//	
//	@Column(name="work_experiences_id")
//	private int workExperiencesId;
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
	
	@ManyToOne()
	@JoinColumn(name ="social_media_id")
	private SocialMedia socialMedia;
	
	@ManyToOne()
	@JoinColumn(name ="work_experiences_id")
	private WorkExperience workExperience;
	
	
	
	@ManyToOne()
	@JoinColumn(name ="candidate_cv_id")
	private CandidateCv candidateCv;
	
	@ManyToOne()
	@JoinColumn(name ="candidates_details_id")
	private CandidatesDetail candidatesDetail;
	
	@ManyToOne()
	@JoinColumn(name ="education_id")
	private Education education;
	
	@ManyToOne()
	@JoinColumn(name ="foreign_languages_id")
	private ForeignLanguage foreignLanguage;
	
}
