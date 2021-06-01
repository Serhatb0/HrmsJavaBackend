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
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","viewCvs"})
public class Education {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;


	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="episode")
	private String episode;
	
	@Column(name="start_of_school")
	private LocalDate startOfSchool;
	
	@Column(name="graduation_year")
	private LocalDate  graduationYear;
	
	@Column(name="school_status")
	private Boolean schoolStatus;
	


	
	@OneToMany(mappedBy = "education")
	private List<ViewCv> viewCvs;
	
}
