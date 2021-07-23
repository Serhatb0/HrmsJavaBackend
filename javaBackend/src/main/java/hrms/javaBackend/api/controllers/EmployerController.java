package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EmployerService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Employer;
import hrms.javaBackend.entities.dtos.CreateDtos.RegisterForEmployerCreateDto;

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
	
	@GetMapping("/findById")
	public DataResult<Employer> findById(int employerId){
		return this.employerService.findById(employerId);
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
	public ResponseEntity<?> addRegister(@Valid @RequestBody RegisterForEmployerCreateDto registerForEmployerDto) {
		return ResponseEntity.ok(this.employerService.addRegister(registerForEmployerDto));
	}
	
	
	@PostMapping("/updateEmployer")
	public Result updateEmployer(@RequestParam int id ,@RequestParam String companyName,@RequestParam  String webAddress,@RequestParam String email) {
		return this.employerService.updateEmployer(id, companyName,webAddress,email);
	}
	
	
	
	
}
