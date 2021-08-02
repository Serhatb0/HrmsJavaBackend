package hrms.javaBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.TypesOfWorkService;
import hrms.javaBackend.entities.concretes.TypesOfWork;

@RestController
@RequestMapping(value="/api/TypesOfWorks")
public class TypesOfWorkController {
	
	private TypesOfWorkService typesOfWorkService;

	@Autowired
	public TypesOfWorkController(TypesOfWorkService typesOfWorkService) {
		super();
		this.typesOfWorkService = typesOfWorkService;
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
	 return ResponseEntity.ok(this.typesOfWorkService.getAll());
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(TypesOfWork typesOfWork){
	 return ResponseEntity.ok(this.typesOfWorkService.add(typesOfWork));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(TypesOfWork typesOfWork){
	 return ResponseEntity.ok(this.typesOfWorkService.update(typesOfWork));
	}
	
	 @DeleteMapping("/delete")
	public ResponseEntity<?> delete(TypesOfWork typesOfWork){
	 return ResponseEntity.ok(this.typesOfWorkService.delete(typesOfWork));
	}
	
	
	

}
