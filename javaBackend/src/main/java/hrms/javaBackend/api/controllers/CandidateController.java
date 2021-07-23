package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.CandidateService;



import hrms.javaBackend.core.utilities.results.DataResult;


import hrms.javaBackend.core.utilities.results.Result;



import hrms.javaBackend.entities.concretes.Candidate;

import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForCandidateCreateDto;

@RestController
@RequestMapping("/api/Candidates")

public class CandidateController {

	private final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();

		this.candidateService = candidateService;
	}

	@GetMapping("/getAllRegister")
	public DataResult<List<RegisterForCandidateCreateDto>> getAllRegister() {
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
	public ResponseEntity<?> addregister(@Valid @RequestBody RegisterForCandidateCreateDto registerForCandidateDto) {
		return ResponseEntity.ok(this.candidateService.register(registerForCandidateDto));
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
