package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jopJobPosition);
}
