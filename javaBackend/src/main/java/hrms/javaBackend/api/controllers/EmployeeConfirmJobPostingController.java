package hrms.javaBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployeeConfirmJobPostingService;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.EmployeeConfirmJobPosting;

@RestController
@RequestMapping("/api/EmployeeConfirmJobPosting")
public class EmployeeConfirmJobPostingController {
	
	private EmployeeConfirmJobPostingService employeeConfirmJobPostingService;

	
	@Autowired
	public EmployeeConfirmJobPostingController(EmployeeConfirmJobPostingService employeeConfirmJobPostingService) {
		super();
		this.employeeConfirmJobPostingService = employeeConfirmJobPostingService;
	}
	
	@GetMapping("/activeJobPosting")
	public Result activeJobPosting(int jobPostingId , EmployeeConfirmJobPosting employeeConfirmJobPosting,int employeeId) {
		return this.employeeConfirmJobPostingService.activeJobPosting(jobPostingId, employeeConfirmJobPosting,employeeId);
		
	}
	
	@GetMapping("/rejectJobPosting")
	public Result rejectJobPosting(int jobPostingId , EmployeeConfirmJobPosting employeeConfirmJobPosting ,int employeeId) {
		return this.employeeConfirmJobPostingService.rejectJobPosting(jobPostingId, employeeConfirmJobPosting,employeeId);
		
	}
	
	

}
