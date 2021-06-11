package hrms.javaBackend.api.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorDataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.JobPostings;

@RestController
@RequestMapping(value="/api/JobPostings")
@CrossOrigin
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
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPostings jobPostings) {
		return ResponseEntity.ok(this.jobPostingsService.add(jobPostings));
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
	
	
	
	
	
	@GetMapping("/getAllByCity")
	public DataResult<List<JobPostings>> getAllByCity(@RequestParam  String cityName){
		return this.jobPostingsService.getAllByCity_cityName(cityName);
	}
	
	@GetMapping("/getAllByNull")
	DataResult<List<JobPostings>> getAllByisActiveIsNull(){
		return this.jobPostingsService.getAllByisActiveIsNull();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
		
	}
	
	
	
}
