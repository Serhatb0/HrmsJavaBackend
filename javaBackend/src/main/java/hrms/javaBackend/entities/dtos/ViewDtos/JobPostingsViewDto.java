package hrms.javaBackend.entities.dtos.ViewDtos;

import java.io.Serializable;
import java.time.LocalDate;

import hrms.javaBackend.entities.concretes.JobPostings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingsViewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String jobDescription;

	private int minSalary;

	private int maxSalary;

	private String cityName;
	
	private String companyName;
	
	private String webAddress;
	
	private int numberOfOpenPositions;
	
	private LocalDate applicationDeadline;
	
	private String typesOfWorkName;
	
	private String positionName;
	
	

	public static JobPostingsViewDto of(JobPostings jobPostings) {

		return new JobPostingsViewDto(jobPostings.getJobDescription(), jobPostings.getMinSalary(),
				jobPostings.getMaxSalary(), jobPostings.getCity().getCityName(),jobPostings.getEmployer().getCompanyName()
				,jobPostings.getEmployer().getWebAddress(),jobPostings.getNumberOfOpenPositions(),jobPostings.getApplicationDeadline(),
				jobPostings.getTypesOfWork().getTypesOfWorkName(),jobPostings.getJobPosition().getPositionName()
				);

	}

}