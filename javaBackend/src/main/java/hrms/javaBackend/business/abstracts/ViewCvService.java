package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.ViewCv;

public interface ViewCvService {
	DataResult<List<ViewCv>> getAll();
	
	Result add(ViewCv viewCv );
	
	DataResult<List<ViewCv>> getAllByeducation_schoolStatus();
	
	DataResult<List<ViewCv>> getAllByworkExperience_operationTimeGreaterThan(int number);
	
	DataResult<List<ViewCv>> getAllByworkExperience_workingStatusTrue();
	
	DataResult<List<ViewCv>> getAllByworkExperience_workingStatusFalse();
}
