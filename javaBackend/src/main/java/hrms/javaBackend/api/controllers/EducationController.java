package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EducationService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Education;

@RestController
@RequestMapping("/api/Educations")
@CrossOrigin
public class EducationController {
	
	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("/getAllBycandidateId")
	public DataResult<List<Education>> getAllBycandidate_id(int id){
		return this.educationService.getAllBycandidate_id(id);
	}
	
	
	@PostMapping("/add")
	public Result add(Education education) {
		return this.educationService.add(education);
	}
	
	

}
