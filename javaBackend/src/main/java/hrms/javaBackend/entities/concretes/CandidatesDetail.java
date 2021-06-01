package hrms.javaBackend.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","viewCvs"})
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
	

	
	@OneToMany(mappedBy = "candidatesDetail")
	private List<ViewCv> viewCvs;
}
