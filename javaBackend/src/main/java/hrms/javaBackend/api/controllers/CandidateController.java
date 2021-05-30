package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.dtos.RegisterForCandidateDto;

@RestController
@RequestMapping("/api/Candidates")

public class CandidateController {

	private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
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
	DataResult<List<Candidate>> getAll(int pageNo, int pageSize){
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
