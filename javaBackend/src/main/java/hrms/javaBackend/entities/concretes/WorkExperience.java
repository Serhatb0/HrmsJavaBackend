package hrms.javaBackend.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Table(name = "work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","viewCvs"})
public class WorkExperience {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_experiences_id")
	private int workExperiencesId;

	@Column(name = "workplace_Name")
	private String workplaceName;

	@Column(name = "job_position")
	private String jobPosition;



	@Column(name = "job_start_date")
	private LocalDate jobStartDate;

	@Column(name = "job_end_Date")
	private LocalDate jobEndDate;

	@Column(name = "working_status")
	private Boolean workingStatus;

	@Column(name = "operation_time")
	private int operationTime;
	

	
	@OneToMany(mappedBy = "workExperience")
	private List<ViewCv> viewCvs;

}
