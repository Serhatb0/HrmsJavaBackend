package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.core.EmailService;
import hrms.javaBackend.core.dataAccess.ConfirmationTokenRepository;

import hrms.javaBackend.core.entities.ConfirmationToken;
import hrms.javaBackend.core.utilities.results.DataResult;

import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;

import hrms.javaBackend.dataAccess.abstracts.CandidateDao;
import hrms.javaBackend.dataAccess.abstracts.UserDao;
import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.concretes.User;

import hrms.javaBackend.entities.dtos.RegisterForCandidateDto;

@RestController
@RequestMapping("/api/Candidates")

public class CandidateController {

	private UserDao userdao;

	private ConfirmationTokenRepository confirmationTokenRepository;

	private final CandidateService candidateService;

	
	
	@Autowired
	public CandidateController(UserDao userdao, ConfirmationTokenRepository confirmationTokenRepository,
			CandidateService candidateService) {
		super();
		this.userdao = userdao;
		this.confirmationTokenRepository = confirmationTokenRepository;
		this.candidateService = candidateService;
	}

	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public Result confirmUserAccount(@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userdao.findByEmailIgnoreCase(token.getUser().getEmail());
			user.setActive(true);
			userdao.save(user);
			return new SuccessResult("Aktif edildi");
		}
		return new ErrorResult("Aktif edilemedi");

	}

	@GetMapping("/getAllRegister")
	public DataResult<List<RegisterForCandidateDto>> getAllRegister() {
		return this.candidateService.getAllRegister();
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}
	



	@GetMapping("/getAllById")
	public DataResult<List<Candidate>> getAllById(@RequestParam int id) {
		return this.candidateService.getAllById(id);
	}

	@GetMapping("/getAllByPage")
	DataResult<List<Candidate>> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.candidateService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Candidate>> getAllSorted() {
		return this.candidateService.getAllSorted();
	}

	@PostMapping(value = "/addregister")
	public Result addregister( @RequestBody RegisterForCandidateDto registerForCandidateDto) {
		return this.candidateService.register(registerForCandidateDto);
	}
	
	@PostMapping(value = "/addCv")
	public Result addCv(@RequestBody Candidate Candidate) {
		return this.candidateService.addCv(Candidate);
	}

	@GetMapping("/getAllByEducationSchoolStatus")
	public DataResult<List<Candidate>> getAllByeducation_schoolStatus() {
		return this.candidateService.getAllByeducation_schoolStatus();
	}

	@GetMapping("/getAllByworkExperienceOperationTimeGreaterThan")
	public DataResult<List<Candidate>> getAllByworkExperience_operationTimeGreaterThan(int number) {
		return this.candidateService.getAllByworkExperience_operationTimeGreaterThan(number);
	}

	@GetMapping("/getAllByworkExperienceWorkingStatusTrue")
	public DataResult<List<Candidate>> getAllByworkExperience_workingStatusTrue() {
		return this.candidateService.getAllByworkExperience_workingStatusTrue();
	}

	@GetMapping("/getAllByworkExperienceWorkingStatusFalse")
	public DataResult<List<Candidate>> getAllByworkExperience_workingStatusFalse() {
		return this.candidateService.getAllByworkExperience_workingStatusFalse();
	}

}
