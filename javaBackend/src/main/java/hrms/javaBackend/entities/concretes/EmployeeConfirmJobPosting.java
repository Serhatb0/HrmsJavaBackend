package hrms.javaBackend.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_confirms_jobPostings")
public class EmployeeConfirmJobPosting {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
	
//	@Column(name="employee_id")
//	private int EmployeeId;
//	
//	@Column(name="jobPostings_id")
//	private int jobPostingsId;
	
	@Column(name="is_confirmed")
	private Boolean isConfirmed;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobPostings_id")
	private JobPostings jobPostings;
}
