package hrms.javaBackend.business.concretes;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.javaBackend.business.abstracts.PhotoService;
import hrms.javaBackend.core.adapters.concretes.CloudinaryService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.PhotoDao;
import hrms.javaBackend.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{

	@Autowired
	private CloudinaryService cloudinaryService;
	private PhotoDao photoDao;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	

	@Override
	public DataResult<List<Photo>> getAllByCandidate_Id(int candidateId) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getAllByCandidate_Id(candidateId),"Data Listelendi");
	}
	
	@Override
	public Result delete(int id) {
		this.photoDao.deleteById(id);
		return new SuccessResult("Resim silindi");
	}


	@Override
	public Result add(Photo photo, MultipartFile file) {
		
		if(cloudinaryService.uploadFile(file) == null) {
			return new ErrorResult("Resim Göderilemedi");
		}else {
			String url = cloudinaryService.uploadFile(file);
			photo.setPhotoUrl(url);
			photo.setName(file.getContentType());
			photo.setDeleteId(url.substring(61, 81));
			this.photoDao.save(photo);
			return new SuccessResult("Resim Eklendi");
		}
		
	}
	
	@Override
	public Boolean isExists(int id) {
		
		return this.photoDao.existsById(id);
	}



	@Override
	public DataResult<Optional<Photo>> getById(int id) {
		return new SuccessDataResult<Optional<Photo>>(this.photoDao.findById(id),"ürün başarıyla getirildi."); 
	}



	@Override
	public DataResult<List<Photo>> getAll() {
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(),"Data Listelendi");
	}

}
