package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@Column(name = "education_id")
	private int educationId;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "episode")
	private String episode;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "start_of_school")
	private LocalDate startOfSchool;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "graduation_year")
	private LocalDate graduationYear;

	@Column(name = "school_status")
	private Boolean schoolStatus;
	

	

	@Column(name = "created_date")
    private Date createdDate = new Date();


//	@Column(name="candidate_id")
//	private int candidateId;

	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	


	

}
