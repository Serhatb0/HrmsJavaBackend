package hrms.javaBackend.business.abstracts;

import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.EmployeeConfirmEmployerUpdate;


public interface EmployeeConfirmEmployerUpdateService {
	
	Result activeUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate ,int employeeId);

	Result rejectUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate,int employeeId);
}
