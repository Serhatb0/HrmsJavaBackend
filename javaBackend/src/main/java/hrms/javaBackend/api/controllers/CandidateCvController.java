package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.CandidateCvService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.CandidateCv;



@RestController
@RequestMapping("/api/CandidateCv")
public class CandidateCvController {

	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCv>> getAll(){
		return this.candidateCvService.getAll();
	}
	
	
	
	
	
	@PostMapping("/add")
	public Result  add(CandidateCv candidateCv){
		return this.candidateCvService.add(candidateCv);
	}
	
	
	
}
