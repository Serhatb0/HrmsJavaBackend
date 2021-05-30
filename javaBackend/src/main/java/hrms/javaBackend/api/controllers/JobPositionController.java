package hrms.javaBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.javaBackend.business.abstracts.JobPositionService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionController {

	private JobPositionService job;
	
	@Autowired
	public JobPositionController(JobPositionService job) {
		super();
		this.job = job;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.job.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jopPosition) {
		return this.job.add(jopPosition);
	}
}
