package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.ViewCvService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.ViewCv;

@RestController
@RequestMapping("/api/ViewCv")
public class ViewCvController {
	
	private ViewCvService viewCvService;

	@Autowired
	public ViewCvController(ViewCvService viewCvService) {
		super();
		this.viewCvService = viewCvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ViewCv>> getAll(){
		return this.viewCvService.getAll();
	}
	
	
	@GetMapping("/getAllByEducationSchoolStatus")
	public DataResult<List<ViewCv>> getAllByeducation_schoolStatus(){
		return this.viewCvService.getAllByeducation_schoolStatus();
	}
	

	@GetMapping("/getAllByworkExperienceOperationTimeGreaterThan")
	public DataResult<List<ViewCv>> getAllByworkExperience_operationTimeGreaterThan(int number){
		return this.viewCvService.getAllByworkExperience_operationTimeGreaterThan(number);
	}
	
	

	@GetMapping("/getAllByworkExperienceWorkingStatusTrue")
	public DataResult<List<ViewCv>> getAllByworkExperience_workingStatusTrue(){
		return this.viewCvService.getAllByworkExperience_workingStatusTrue();
	}
	

	@GetMapping("/getAllByworkExperienceWorkingStatusFalse")
	public DataResult<List<ViewCv>> getAllByworkExperience_workingStatusFalse(){
		return this.viewCvService.getAllByworkExperience_workingStatusFalse();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ViewCv viewCv) {
		return this.viewCvService.add(viewCv);
	}
	
}
