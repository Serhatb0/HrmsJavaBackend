package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;
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
@Table(name = "candidate_cv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","viewCvs"})
public class CandidateCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="candidate_cv_id")
	private int candidateCvId;


	
	@Column(name="military_status")
	private Boolean militaryStatus;
	
	@Column(name="driver_license_status")
	private Boolean driverLicenseStatus;
	
	@Column(name="areas_of_interest")
	private String AreasOfInterest;
	

	

	@OneToMany(mappedBy = "candidateCv")
	private List<ViewCv> viewCvs;

}
