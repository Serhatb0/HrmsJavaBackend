package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.concretes.EmployeeConfirmJobPosting;


public interface EmployeeConfirmJobPostingService {
		
	DataResult<List<EmployeeConfirmJobPosting>> getAll();

	Result activeJobPosting(int jobPostingsId, EmployeeConfirmJobPosting employeeConfirmJobPosting,int employeeId);

	Result rejectJobPosting(int jobPostingsId, EmployeeConfirmJobPosting employeeConfirmJobPosting,int employeeId);

	
	DataResult<EmployeeConfirmJobPosting> findByjobPostings_jobPostingsId(int jobPostingsId);
}
