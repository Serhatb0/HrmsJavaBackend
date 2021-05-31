package hrms.javaBackend.business.concretes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	private UserCheckService userCheckService;
	private CandidateUserCheckHelperService candidateUserCheckHelperService;
	private MernisCheckService mernisCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailServiceBusiness emailService, UserCheckService userCheckService,
			CandidateUserCheckHelperService candidateUserCheckHelperService, MernisCheckService mernisCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.emailService = emailService;
		this.userCheckService = userCheckService;
		this.candidateUserCheckHelperService = candidateUserCheckHelperService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Candidateler Listelendi");
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
	public DataResult<Boolean> checkIfRealPerson(String nationalityId, String firstName, String lastName,
			LocalDate dateOfBirthYear) {
		return new DataResult<>(
				this.userCheckService.checkIfRealPerson(nationalityId, firstName, lastName, dateOfBirthYear), true);

	}

	@Override
	public Result add(Candidate candidate) {

		boolean checkIdentityNumber = this.findByIdentityNumberIs(candidate.getIdentityNumber()).getData().size() != 0;
		boolean checkEmail = this.findByEmailIs(candidate.getEmail()).getData().size() != 0;
		boolean checkUserRealOrNot = !this.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate()).getData();
		boolean requiredField = !this.candidateUserCheckHelperService.allFieldsAreRequired(candidate);
		boolean mernis = this.mernisCheckService.checkIfRealPerson(candidate);

		if (emailService.isValid(candidate.getEmail()) == false) {
			return new ErrorResult("Email Fomratı Yanlış");
		}

		if (checkIdentityNumber || checkEmail || requiredField) {
			String errorMessage = "";

			if (checkIdentityNumber) {
				errorMessage = "Bu Tc No Zaten Kayıtlı";
			}
			if (checkEmail) {
				errorMessage = "Bu Email Zaten Var";
			}
			if (requiredField) {
				errorMessage = "Tüm Alanları Doldurunuz";
			}

			return new ErrorResult(errorMessage);

		}

		if (mernis == false) {
			return new ErrorResult("Bu Kişi Bulunamadı");
		} else {
			candidateDao.save(candidate);
			return new SuccessResult(emailService.sendEmail(candidate, candidate.getEmail()).getMessage());
		}

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
		Candidate candidate = new Candidate();
		
		candidate.setFirstName(registerForCandidateDto.getFirstName());
		candidate.setLastName(registerForCandidateDto.getLastName());
		candidate.setIdentityNumber(registerForCandidateDto.getIdentityNumber());
		candidate.setBirthDate(registerForCandidateDto.getBirthDate());
		candidate.setEmail(registerForCandidateDto.getEmail());
		candidate.setPassword(registerForCandidateDto.getPassword());
		
		Boolean bool = false;
		candidate.setActive(bool);

		boolean checkIdentityNumber = this.findByIdentityNumberIs(candidate.getIdentityNumber()).getData().size() != 0;
		boolean checkEmail = this.findByEmailIs(candidate.getEmail()).getData().size() != 0;
		// boolean checkUserRealOrNot =
		// !this.checkIfRealPerson(candidate.getIdentityNumber(),
		// candidate.getFirstName(), candidate.getLastName(),
		// candidate.getBirthDate()).getData();
		boolean requiredField = !this.candidateUserCheckHelperService.allFieldsAreRequired(candidate);
		boolean mernis = this.mernisCheckService.checkIfRealPerson(candidate);

		if (emailService.isValid(candidate.getEmail()) == false) {
			return new ErrorResult("Email Fomratı Yanlış");
		}

		if (checkIdentityNumber || checkEmail || requiredField) {
			String errorMessage = "";

			if (checkIdentityNumber) {
				errorMessage = "Bu Tc No Zaten Kayıtlı";
			}
			if (checkEmail) {
				errorMessage = "Bu Email Zaten Var";
			}
			if (requiredField) {
				errorMessage = "Tüm Alanları Doldurunuz";
			}

			return new ErrorResult(errorMessage);

		}

		if (mernis == false) {
			return new ErrorResult("Bu Kişi Bulunamadı");
		} else {
			this.candidateDao.save(candidate);
			return new SuccessResult(
					emailService.sendEmail(candidate, registerForCandidateDto.getEmail()).getMessage());
		}

	}

}
