package hrms.javaBackend.business.abstracts;

import java.util.List;



import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForEmployerCreateDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();

	DataResult<List<Employer>> findByEmailIs(String email);

	Result addRegister(RegisterForEmployerCreateDto registerForEmployerDto);

	DataResult<List<Employer>> findBystaffApprovalIsNull();

	DataResult<List<Employer>> findBystaffApprovalFalse();

	DataResult<List<Employer>> findBystaffApprovalTrue();
	
	DataResult<Employer> findBycompanyName(String companyName);
	
	Result updateEmployer(int id, String companyName,String webAddress,String email);
	
	DataResult<Employer> findById(int employerId);
	
	
}
