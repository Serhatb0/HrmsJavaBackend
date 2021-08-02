package hrms.javaBackend.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.business.abstracts.EmailServiceBusiness;

import hrms.javaBackend.core.adapters.abstracts.MernisCheckService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;

import hrms.javaBackend.dataAccess.abstracts.CandidateDao;
import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForCandidateCreateDto;

@Service

public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailServiceBusiness emailService;
	private MernisCheckService mernisCheckService;
	private ModelMapper modelMapper;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailServiceBusiness emailService,
			MernisCheckService mernisCheckService, ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.emailService = emailService;
		this.mernisCheckService = mernisCheckService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<RegisterForCandidateCreateDto>> getAllRegister() {
		List<Candidate> candidates = this.candidateDao.findAll();
		List<RegisterForCandidateCreateDto> dtos = candidates.stream()
				.map(candidate -> modelMapper.map(candidate, RegisterForCandidateCreateDto.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<RegisterForCandidateCreateDto>>(dtos, "Candidateler Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> findByEmailIs(String email) {
		return new SuccessDataResult<>(this.candidateDao.findByEmailIs(email));
	}

	@Override
	public DataResult<List<Candidate>> findByIdentityNumberIs(String identityNumber) {
		return new SuccessDataResult<>(this.candidateDao.findByIdentityNumberIs(identityNumber));
	}

	@Override
	public DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(pageable).getContent());

	}

	@Override
	public DataResult<List<Candidate>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(sort));
	}

	@Override
	public Result register(RegisterForCandidateCreateDto registerForCandidateDto) {
		Candidate candidate = modelMapper.map(registerForCandidateDto, Candidate.class);

		boolean mernis = this.mernisCheckService.checkIfRealPerson(candidate);

		if (mernis == false) {
			return new ErrorResult("Bu Kişi Bulunamadı");
		} else {
			modelMapper.map(this.candidateDao.save(candidate), RegisterForCandidateCreateDto.class);
			return new SuccessResult(
					emailService.sendEmail(candidate, registerForCandidateDto.getEmail()).getMessage());
		}

	}

	@Override
	public DataResult<List<Candidate>> getAllByeducation_schoolStatus() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getAllByeducations_schoolStatusTrue(),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> getAllByworkExperience_operationTimeGreaterThan(int number) {
		return new SuccessDataResult<List<Candidate>>(
				this.candidateDao.getAllByworkExperiences_operationTimeGreaterThanEqual(number), "Data Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> getAllByworkExperience_workingStatusTrue() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getAllByworkExperiences_workingStatusTrue(),
				"Aktif Çalışanlar Listelendi");
	}

	@Override
	public DataResult<List<Candidate>> getAllByworkExperience_workingStatusFalse() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getAllByworkExperiences_workingStatusFalse(),
				"Çalışmayanlar Listelendi");

	}

	@Override
	public DataResult<Candidate> getAllById(int id) {

		return new SuccessDataResult<Candidate>(this.candidateDao.getAllById(id), " listelendi");

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result addCv(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Cv Eklend");
	}

	

}
