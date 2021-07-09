package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployeeService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.dtos.RegisterForEmployeeDto;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
	@PostMapping("/addRegister")
	public Result addRegsiter(@RequestBody RegisterForEmployeeDto registerForEmployeeDto) {
		return this.employeeService.addRegister(registerForEmployeeDto);
	}
	
	@PostMapping("/employeeUpdate")
	public Result  updateEmployee(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,@RequestParam String email) {
		return this.employeeService.updateEmployee(id, firstName, lastName, email);
	}

}
