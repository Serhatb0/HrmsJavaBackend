package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_postings")
public class JobPostings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_postings_id")
	private int jobPostingsId;

	// @Column(name = "job_titles_id")
	// private int jobTitlesId;

	// @Column(name = "city_id")
	// private int cityId;

	@Column(name = "job_description")
	@NotBlank
	private String jobDescription;
	
	
	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name="types_of_works")
	private String typesOfWork;
	
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	
	@Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

	// @Column(name = "employers_id")
	// private int employersId;

	@Column(name = "is_active")
	private Boolean isActive;
	
	
	@OneToMany(mappedBy = "jobPostings")
	private List<EmployeeConfirmJobPosting> employeeConfirmJobPostings;
	

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	
	@ManyToOne()
	@JoinColumn(name = "employers_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name = "job_titles_id")
	private JobPosition jobPosition;

}
