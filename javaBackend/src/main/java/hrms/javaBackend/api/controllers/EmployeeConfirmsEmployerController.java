package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployeeConfirmsEmployerService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.concretes.EmployeeConfirmsEmployer;

@RestController
@RequestMapping("/api/EmployeeConfirmsEmployer")
public class EmployeeConfirmsEmployerController {

	private EmployeeConfirmsEmployerService employeeConfirmsEmployerService;

	@Autowired
	public EmployeeConfirmsEmployerController(EmployeeConfirmsEmployerService employeeConfirmsEmployerService) {
		super();
		this.employeeConfirmsEmployerService = employeeConfirmsEmployerService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmployeeConfirmsEmployer>> getAll() {
		return this.employeeConfirmsEmployerService.getAll();
	}

	@GetMapping("/activeEmployer")
	public Result activeEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer,
			int employeeId) {
		return this.employeeConfirmsEmployerService.activeEmployer(companyName, employeeConfirmsEmployer, employeeId);
	}

	@GetMapping("/rejectEmployer")
	public Result rejectEmployer(String companyName, EmployeeConfirmsEmployer employeeConfirmsEmployer,
			int employeeId) {
		return this.employeeConfirmsEmployerService.rejectEmployer(companyName, employeeConfirmsEmployer, employeeId);
	}
}
