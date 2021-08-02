package hrms.javaBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.EducationService;
import hrms.javaBackend.core.utilities.results.DataResult;

import hrms.javaBackend.entities.dtos.CreateDtos.EducationCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.EducationViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.EducationUpdateDto;

@RestController
@RequestMapping("/api/Educations")
@CrossOrigin
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getAll")
	public DataResult<List<EducationViewDto>> getAll() {
		return this.educationService.getAll();
	}

	@GetMapping("/getAllBycandidateId")
	public DataResult<List<EducationViewDto>> getAllBycandidate_id(int id) {
		return this.educationService.getAllBycandidate_id(id);
	}
	
	@GetMapping("/getAllById")
	public DataResult<EducationViewDto> getAllById(int id) {
		return this.educationService.getAllById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationCreateDto educationCreateDto) {
		return ResponseEntity.ok(this.educationService.add(educationCreateDto));
	}

	@PutMapping("/educationUpdate")
	public ResponseEntity<?> educationUpdate(@Valid @RequestParam int id,@RequestBody EducationUpdateDto educationUpdateDto) {
		return ResponseEntity.ok(this.educationService.update(id,educationUpdateDto));
	}
	
	@DeleteMapping("/educationDelete")
	public ResponseEntity<?> educationDelete(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.educationService.deleteEducation(id));
	}

}
