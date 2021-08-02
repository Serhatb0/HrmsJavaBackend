package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.ForeignLanguageService;
import hrms.javaBackend.core.utilities.results.DataResult;

import hrms.javaBackend.entities.dtos.CreateDtos.ForeignLanguageCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.ForeignLanguageViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.ForeignLanguageUpdateDto;

@RestController
@RequestMapping(value="/api/ForeignLanguages")
public class ForeignLanguageController {

	
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}
	
	@GetMapping(value="/getall")
	public DataResult<List<ForeignLanguageViewDto>> getAll(){
		return this.foreignLanguageService.getAll();	
	}
	
	@GetMapping(value="/getallById")
	public DataResult<List<ForeignLanguageViewDto>> getallByCandidateId(int candidateId){
		return this.foreignLanguageService.getallByCandidateId(candidateId);	
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguageCreateDto foreignLanguageCreateDto) {
		return  ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguageCreateDto));
		
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody ForeignLanguageUpdateDto foreignLanguageUpdataDto ,@RequestParam int id) {
		return  ResponseEntity.ok(this.foreignLanguageService.update(id,foreignLanguageUpdataDto));
		
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return  ResponseEntity.ok(this.foreignLanguageService.delete(id));
		
	}
	
	
}
