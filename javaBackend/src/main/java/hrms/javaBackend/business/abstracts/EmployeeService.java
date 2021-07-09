package hrms.javaBackend.business.abstracts;

import java.util.List;



import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.dtos.RegisterForEmployeeDto;


public interface EmployeeService {

	DataResult<List<Employee>> getAll();

	Result add(Employee employee);

	DataResult<Employee> getAllById(int employeeId);

	Result updateEmployee(int id, String firstName, String lastName, String email);
	
	Result addRegister(RegisterForEmployeeDto registerForEmployeeDto);

}
