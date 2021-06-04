package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Education;

public interface EducationService {

	
	DataResult<List<Education>> getAll();
	
	Result add(Education education);
	
	DataResult<List<Education>> getAllBycandidate_id(int id);
}
