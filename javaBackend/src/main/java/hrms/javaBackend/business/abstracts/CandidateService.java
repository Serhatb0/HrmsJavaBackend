package hrms.javaBackend.business.abstracts;


import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForCandidateCreateDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();

	Result addCv(Candidate candidate);

	DataResult<List<RegisterForCandidateCreateDto>> getAllRegister();

	DataResult<List<Candidate>> getAll(int pageNo, int pageSize);

	DataResult<List<Candidate>> getAllSorted();

	DataResult<List<Candidate>> findByIdentityNumberIs(String identificationNumber);

	DataResult<List<Candidate>> findByEmailIs(String email);

	Result register(RegisterForCandidateCreateDto registerForCandidateDto);

	DataResult<List<Candidate>> getAllByeducation_schoolStatus();

	DataResult<List<Candidate>> getAllByworkExperience_operationTimeGreaterThan(int number);

	DataResult<List<Candidate>> getAllByworkExperience_workingStatusTrue();

	DataResult<List<Candidate>> getAllByworkExperience_workingStatusFalse();

	DataResult<Candidate> getAllById(int id);


}
