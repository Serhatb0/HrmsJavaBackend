package hrms.javaBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployeeConfirmEmployerUpdateService;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.EmployeeConfirmEmployerUpdate;

@RestController
@RequestMapping("/api/EmployeeConfirmEmployerUpdate")
public class EmployeeConfirmEmployerUpdateController {
	
	private EmployeeConfirmEmployerUpdateService employeeConfirmEmployerUpdateService;

	@Autowired
	public EmployeeConfirmEmployerUpdateController(
			EmployeeConfirmEmployerUpdateService employeeConfirmEmployerUpdateService) {
		super();
		this.employeeConfirmEmployerUpdateService = employeeConfirmEmployerUpdateService;
	}
	
	@GetMapping("/activeUpdateEmployer")
	public Result activeUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate ,int employeeId) {
		return this.employeeConfirmEmployerUpdateService.activeUpdateEmployer(employerId, employeeConfirmEmployerUpdate, employeeId);
	}
	
	@GetMapping("/rejectUpdateEmployer")
	public Result rejecyUpdateEmployer(int employerId, EmployeeConfirmEmployerUpdate employeeConfirmEmployerUpdate ,int employeeId) {
		return this.employeeConfirmEmployerUpdateService.rejectUpdateEmployer(employerId, employeeConfirmEmployerUpdate, employeeId);
	}
	
	
	

}
