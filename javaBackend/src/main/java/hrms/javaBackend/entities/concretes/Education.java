package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;

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
@Table(name = "educations")
public class Education {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;

//	@Column(name="candidate_id")
//	private int candidateId;
	
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
	
	@ManyToOne()
	@JoinColumn(name ="candidate_id")
	private Candidate candidate;
	
}
