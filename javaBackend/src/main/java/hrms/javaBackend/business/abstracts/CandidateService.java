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

	Result addCv(Candidate candidate);

	DataResult<List<RegisterForCandidateDto>> getAllRegister();

	DataResult<List<Candidate>> getAll(int pageNo, int pageSize);

	DataResult<List<Candidate>> getAllSorted();

	DataResult<List<Candidate>> findByIdentityNumberIs(String identificationNumber);

	DataResult<List<Candidate>> findByEmailIs(String email);

	Result register(RegisterForCandidateDto registerForCandidateDto);

	DataResult<List<Candidate>> getAllByeducation_schoolStatus();

	DataResult<List<Candidate>> getAllByworkExperience_operationTimeGreaterThan(int number);

	DataResult<List<Candidate>> getAllByworkExperience_workingStatusTrue();

	DataResult<List<Candidate>> getAllByworkExperience_workingStatusFalse();

	DataResult<List<Candidate>> getAllById(int id);

}
