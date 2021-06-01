package hrms.javaBackend.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.dataAccess.abstracts.CandidateCvDao;
import hrms.javaBackend.entities.concretes.Candidate;

import hrms.javaBackend.entities.dtos.RegisterForCandidateDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();

	DataResult<List<Candidate>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Candidate>> getAllSorted();

	DataResult<List<Candidate>> findByIdentityNumberIs(String identificationNumber);

	DataResult<List<Candidate>> findByEmailIs(String email);

	Result add(Candidate candidate);
	
	Result register(RegisterForCandidateDto registerForCandidateDto);

	DataResult<Boolean> checkIfRealPerson(String nationalityId, String firstName, String lastName,
			LocalDate dateOfBirthYear);

	


}
