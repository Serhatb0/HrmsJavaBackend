package hrms.javaBackend.business.abstracts;


import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.dtos.JobPostingsFilter;
import hrms.javaBackend.entities.dtos.CreateDtos.JobPostingsCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.JobPostingsViewDto;

public interface JobPostingsService {

	DataResult<List<JobPostingsViewDto>> getAll();

	DataResult<List<JobPostings>> getAllByEmployer(int employerId);

	Result add(JobPostingsCreateDto jobPostingsCreateDto);

	DataResult<List<JobPostings>> getAllByisActive(Boolean isActive, int pageNo, int pageSize);

	Result passiveAdvertisement(int jobPostingsId, int employerId);

	DataResult<List<JobPostings>> getAllByisActiveIsNull(int pageNo, int pageSize);

	DataResult<JobPostingsViewDto> getAllByjobPostingsId(int jobPostingsId);
	
	DataResult<JobPostings> getAllByjobId(int jobPostingsId);

	DataResult<List<JobPostingsViewDto>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize,
			JobPostingsFilter jobPostingsFilter, int min, int max);

}
