package hrms.javaBackend.entities.concretes;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeconfirmsEmployers"})
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "staff_approval")
	private Boolean staffApproval;
	
	@Column(name = "is_update")
	private Boolean isUpdate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobPostings> jobPostings;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployeeConfirmsEmployer> employeeconfirmsEmployers;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployeeConfirmEmployerUpdate>  employeeConfirmEmployerUpdates;

	

	
	

}
