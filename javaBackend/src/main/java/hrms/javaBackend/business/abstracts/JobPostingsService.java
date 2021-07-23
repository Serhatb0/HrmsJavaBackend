package hrms.javaBackend.business.abstracts;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.dtos.JobPostingsFilter;
import hrms.javaBackend.entities.dtos.ViewDtos.JobPostingsViewDto;

public interface JobPostingsService {

	DataResult<List<JobPostingsViewDto>> getAll();

	DataResult<List<JobPostings>> getAllByEmployer(int employerId);

	Result add(JobPostings jobPostings);

	DataResult<List<JobPostings>> getAllByApplicationDeadlineLessThanEqual(LocalDate date);

	DataResult<List<JobPostings>> getAllByisActive(Boolean isActive,int pageNo, int pageSize);

	DataResult<List<JobPostings>> getAllPage(int pageNo, int pageSize);

	Result passiveAdvertisement(int jobPostingsId, int employerId);

	DataResult<List<JobPostings>> getAllByCity_cityName(String cityName);

	DataResult<List<JobPostings>> getAllByisActiveIsNull(int pageNo, int pageSize);

	DataResult<List<JobPostings>> findBycreatedDateLessThanEqual(Date currentDate);

	DataResult<JobPostings> getAllByjobPostingsId(int jobPostingsId);

	DataResult<List<JobPostings>> getMinSalaryAndMaxSalary(int minSalary, int maxSalary);
	
	 DataResult<List<JobPostings>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize, JobPostingsFilter jobPostingsFilter,int min,int max);
	 
	 DataResult<List<JobPostings>> getDene(int min,  int max, int cityId);

}
