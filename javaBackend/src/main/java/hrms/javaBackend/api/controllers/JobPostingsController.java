package hrms.javaBackend.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.JobPostings;

@RestController
@RequestMapping("/api/JobPostings")
public class JobPostingsController {

	private JobPostingsService jobPostingsService;
	
	@Autowired
	public JobPostingsController(JobPostingsService jobPostingsService) {
		super();
		this.jobPostingsService = jobPostingsService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobPostings>> getAll(){
		return this.jobPostingsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPostings jobPostings) {
		return this.jobPostingsService.add(jobPostings);
	}
	
	@GetMapping("/getAllByEmployer")
	public DataResult<List<JobPostings>> getAllByEmployer(@RequestParam("employerId") int employerId){
		return this.jobPostingsService.getAllByEmployer(employerId);
	}
	
	@GetMapping("/getAllByapplicationDeadline")
	public DataResult<List<JobPostings>> getAllByapplicationDeadline(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
		return this.jobPostingsService.getAllByApplicationDeadlineLessThanEqual(date);
	}
	
	
	@GetMapping("/getAllByisActive")
	public DataResult<List<JobPostings>> getAllByisActive(@RequestParam  Boolean isActive){
		return this.jobPostingsService.getAllByisActive(isActive);
	}
	

	@GetMapping("/passiveAdvertisement")
	public Result  passiveAdvertisement(@RequestParam  int jobPostingsId, @RequestParam int employerId){
		return this.jobPostingsService.passiveAdvertisement(jobPostingsId,employerId);
	}
	
	
	
	
	
	
	
	
	
	
	
}
