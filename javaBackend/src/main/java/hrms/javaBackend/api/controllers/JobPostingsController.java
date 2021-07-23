package hrms.javaBackend.api.controllers;

import java.time.LocalDate;
import java.util.Date;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

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
import hrms.javaBackend.entities.dtos.JobPostingsFilter;
import hrms.javaBackend.entities.dtos.ViewDtos.JobPostingsViewDto;

@RestController
@RequestMapping(value = "/api/JobPostings")
@CrossOrigin
public class JobPostingsController {

	private JobPostingsService jobPostingsService;

	@Autowired
	public JobPostingsController(JobPostingsService jobPostingsService) {
		super();
		this.jobPostingsService = jobPostingsService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPostingsViewDto>> getAll() {
		return this.jobPostingsService.getAll();
	}

	@GetMapping("/findBycreatedDateLessThanEqual")
	public DataResult<List<JobPostings>> findBycreatedDateLessThanEqual(Date currentDate) {

		return this.jobPostingsService.findBycreatedDateLessThanEqual(currentDate);
	}

	@GetMapping("/getallPage")
	public DataResult<List<JobPostings>> getAllPage(int pageNo, int pageSize) {
		return this.jobPostingsService.getAllPage(pageNo, pageSize);
	}

	@GetMapping("/getMinSalaryAndMaxSalary")
	public DataResult<List<JobPostings>> getMinSalaryAndMaxSalary(int minSalary, int maxSalary) {
		return this.jobPostingsService.getMinSalaryAndMaxSalary(minSalary, maxSalary);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPostings jobPostings) {
		return ResponseEntity.ok(this.jobPostingsService.add(jobPostings));
	}

	@GetMapping("/getAllByEmployer")
	public DataResult<List<JobPostings>> getAllByEmployer(@RequestParam("employerId") int employerId) {
		return this.jobPostingsService.getAllByEmployer(employerId);
	}

	@GetMapping("/getAllByapplicationDeadline")
	public DataResult<List<JobPostings>> getAllByapplicationDeadline(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return this.jobPostingsService.getAllByApplicationDeadlineLessThanEqual(date);
	}

	@GetMapping("/getAllByisActive")
	public DataResult<List<JobPostings>> getAllByisActive(@RequestParam Boolean isActive, @RequestParam int pageNo,
			@RequestParam int pageSize) {
		return this.jobPostingsService.getAllByisActive(isActive, pageNo, pageSize);
	}

	@GetMapping("/passiveAdvertisement")
	public Result passiveAdvertisement(@RequestParam int jobPostingsId, @RequestParam int employerId) {
		return this.jobPostingsService.passiveAdvertisement(jobPostingsId, employerId);
	}

	@GetMapping("/getAllByjobPostingsId")
	DataResult<JobPostings> getAllByjobPostingsId(int jobPostingsId) {
		return this.jobPostingsService.getAllByjobPostingsId(jobPostingsId);
	}

	@GetMapping("/getAllByCity")
	public DataResult<List<JobPostings>> getAllByCity(@RequestParam String cityName) {
		return this.jobPostingsService.getAllByCity_cityName(cityName);
	}

	@GetMapping("/getAllByNull")
	DataResult<List<JobPostings>> getAllByisActiveIsNull(@RequestParam int pageNo, @RequestParam int pageSize) {
		return this.jobPostingsService.getAllByisActiveIsNull(pageNo, pageSize);
	}

	@PostMapping("/getByActiveAndFilter")
	public Result getByActiveAndFilter(@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestBody JobPostingsFilter jobPostingsFilter, @RequestParam(defaultValue = "0") int min,
			@RequestParam(defaultValue = "99999") int max) {
		return jobPostingsService.getByIsActiveAndPageNumberAndFilter(pageNo, pageSize, jobPostingsFilter, min, max);
	}

}
