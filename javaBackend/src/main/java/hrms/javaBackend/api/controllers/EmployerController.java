package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployerService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("/api/Employers")
@CrossOrigin
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/findBystaffApprovalIsNull")
	public DataResult<List<Employer>> findBystaffApprovalIsNull(){
		return this.employerService.findBystaffApprovalIsNull();
	}
	
	@GetMapping("/findBystaffApprovalFalse")
	public DataResult<List<Employer>> findBystaffApprovalFalse(){
		return this.employerService.findBystaffApprovalFalse();
	}
	
	@GetMapping("/findBystaffApprovalTrue")
	public DataResult<List<Employer>> findBystaffApprovalTrue(){
		return this.employerService.findBystaffApprovalTrue();
	}
	@GetMapping("/findBycompanyName")
	public Result findBycompanyName(String name) {
		return this.employerService.findBycompanyName(name);
	}
	
	
	@PostMapping("/addRegister")
	public Result addRegister(@RequestBody RegisterForEmployerDto registerForEmployerDto) {
		return this.employerService.addRegister(registerForEmployerDto);
	}
	
	

	
	
}
