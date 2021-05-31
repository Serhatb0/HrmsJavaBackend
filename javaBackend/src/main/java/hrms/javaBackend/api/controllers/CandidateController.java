package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private UserDao userdao;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailService emailService;

	private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result registerUser(Candidate candidate) {

		candidateDao.save(candidate);

		ConfirmationToken confirmationToken = new ConfirmationToken(candidate);

		confirmationTokenRepository.save(confirmationToken);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(candidate.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom("YOUR EMAIL ADDRESS");
		mailMessage.setText("To confirm your account, please click here : "
				+ "http://localhost:8080/api/Candidates/confirm-account?token=" + confirmationToken.getConfirmationToken());

		emailService.sendEmail(mailMessage);
		return this.candidateService.add(candidate);

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

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		return this.candidateService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	@GetMapping("/getAllByPage")
	DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		return this.candidateService.getAll(pageNo, pageSize);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Candidate>> getAllSorted() {
		return this.candidateService.getAllSorted();
	}

	@PostMapping("/addregister")
	public Result addregister(@RequestBody RegisterForCandidateDto registerForCandidateDto) {
		return this.candidateService.register(registerForCandidateDto);
	}
}
