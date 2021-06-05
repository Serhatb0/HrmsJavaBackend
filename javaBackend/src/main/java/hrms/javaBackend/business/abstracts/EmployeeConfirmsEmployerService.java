package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.EmployeeConfirmsEmployer;

public interface EmployeeConfirmsEmployerService {

	DataResult<List<EmployeeConfirmsEmployer>> getAll();

	Result activeEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer);

	Result rejectEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer);

	DataResult<EmployeeConfirmsEmployer> findByemployer_companyName(String companyName);
}
