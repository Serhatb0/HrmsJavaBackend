package hrms.javaBackend.entities.concretes;





import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeconfirmsEmployers"})
@Table(name="employees")
public class Employee extends User {
	
	
	
	@Column(name="first_name")
	private String fistName;
	

	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "employee")
	private List<EmployeeConfirmsEmployer> employeeconfirmsEmployers;
	
	@OneToMany(mappedBy = "employee")
	private List<EmployeeConfirmJobPosting> employeeConfirmJobPostings;

}
