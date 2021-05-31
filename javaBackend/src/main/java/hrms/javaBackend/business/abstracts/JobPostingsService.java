package hrms.javaBackend.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.JobPostings;

public interface JobPostingsService {

	DataResult<List<JobPostings>> getAll();

	DataResult<List<JobPostings>> getAllByEmployer(int employerId);

	Result add(JobPostings jobPostings);
	
	DataResult<List<JobPostings>> getAllByApplicationDeadlineLessThanEqual(LocalDate date);
	
	DataResult<List<JobPostings>> getAllByisActive(Boolean isActive);
	
	Result  passiveAdvertisement(int jobPostingsId ,int employerId);
	
	DataResult<List<JobPostings>> getAllByCity_cityName(String cityName);
}
