package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.RegisterForEmployerDto;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	DataResult<List<Employer>> findByEmailIs(String email); 
	Result add(Employer employer);
	
	Result addRegister(RegisterForEmployerDto registerForEmployerDto);
}
