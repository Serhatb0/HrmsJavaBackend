package hrms.javaBackend.api.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import hrms.javaBackend.business.abstracts.PhotoService;
import hrms.javaBackend.core.adapters.concretes.CloudinaryService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.entities.concretes.Photo;

@RestController
@RequestMapping("/cloudinarys")
@CrossOrigin
public class CloudinaryController {

	
	private CloudinaryService cloudinaryService;
	private PhotoService PhotoService;

	
	@Autowired
	public CloudinaryController(CloudinaryService cloudinaryService,
			hrms.javaBackend.business.abstracts.PhotoService photoService) {
		super();
		this.cloudinaryService = cloudinaryService;
		PhotoService = photoService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Photo>> getAll(){
		return this.PhotoService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<Photo>> getAllByCandidate_Id(int id){
		return this.PhotoService.getAllByCandidate_Id(id);
	}
	
	
	

	@PostMapping("/upload")
	public Result uploadFile(@RequestParam("file") MultipartFile file, Photo photo) {
		return this.PhotoService.add(photo, file);

	}
	
	

	@DeleteMapping("/delete/{id}")
	public Result delete (@PathVariable("id") int id) throws IOException{
		if (!this.PhotoService.isExists(id)) {
			return new ErrorResult("Böyle bir resim Yok");
		}
		
		Photo image = this.PhotoService.getById(id).getData().get();
		Map result = cloudinaryService.delete(image.getDeleteId());
		this.PhotoService.delete(id);
		return new SuccessResult("Resim silindi.");
	}

}
