package hrms.javaBackend.business.concretes;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.CandidateUserCheckHelperService;
import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.business.abstracts.EmailServiceBusiness;

import hrms.javaBackend.business.abstracts.UserCheckService;
import hrms.javaBackend.core.adapters.abstracts.MernisCheckService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;

import hrms.javaBackend.dataAccess.abstracts.CandidateDao;
import hrms.javaBackend.entities.concretes.Candidate;

import hrms.javaBackend.entities.dtos.RegisterForCandidateDto;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailServiceBusiness emailService;
	private CandidateUserCheckHelperService candidateUserCheckHelperService;
	private MernisCheckService mernisCheckService;
	private ModelMapper modelMapper;

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailServiceBusiness emailService,
			CandidateUserCheckHelperService candidateUserCheckHelperService, MernisCheckService mernisCheckService,
			ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.emailService = emailService;
		this.candidateUserCheckHelperService = candidateUserCheckHelperService;
		this.mernisCheckService = mernisCheckService;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<RegisterForCandidateDto>> getAllRegister() {
		List<Candidate> candidates = this.candidateDao.findAll();		
		List<RegisterForCandidateDto> dtos =candidates.stream().map(candidate -> modelMapper.map(candidate,RegisterForCandidateDto.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<RegisterForCandidateDto>>(dtos, "Candidateler Listelendi");
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
	public Result register(RegisterForCandidateDto registerForCandidateDto) {
		Candidate candidate = modelMapper.map(registerForCandidateDto, Candidate.class);

		boolean checkIdentityNumber = this.findByIdentityNumberIs(candidate.getIdentityNumber()).getData().size() != 0;
		boolean checkEmail = this.findByEmailIs(candidate.getEmail()).getData().size() != 0;
		boolean requiredField = !this.candidateUserCheckHelperService.allFieldsAreRequired(candidate);
		boolean mernis = this.mernisCheckService.checkIfRealPerson(candidate);

		if (emailService.isValid(candidate.getEmail()) == false) {
			return new ErrorResult("Email Fomratı Yanlış");
		}

		if (checkIdentityNumber || checkEmail) {
			String errorMessage = "";

			if (checkIdentityNumber) {
				errorMessage = "Bu Tc No Zaten Kayıtlı";
			}
			if (checkEmail) {
				errorMessage = "Bu Email Zaten Var";
			}
			

			return new ErrorResult(errorMessage);

		}

		if (mernis == false) {
			return new ErrorResult("Bu Kişi Bulunamadı");
		} else {
			modelMapper.map(this.candidateDao.save(candidate), RegisterForCandidateDto.class);
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
	public DataResult<List<Candidate>> getAllById(int id) {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getAllById(id), "Data listelendi");

	}
	
	 

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result addCv(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Cv Eklend");
	}

	

}
