package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

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
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForEmployeeCreateDto;

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
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(this.employeeService.add(employee));
	}

	@PostMapping("/addRegister")
	public ResponseEntity<?> addRegsiter(@Valid @RequestBody RegisterForEmployeeCreateDto registerForEmployeeDto) {

		return ResponseEntity.ok(this.employeeService.addRegister(registerForEmployeeDto));

	}

	@PostMapping("/employeeUpdate")
	public Result updateEmployee(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email) {
		return this.employeeService.updateEmployee(id, firstName, lastName, email);
	}

}
