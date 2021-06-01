package hrms.javaBackend.business.abstracts;

import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.Photo;

public interface PhotoService {

	DataResult<List<Photo>> getAllByCandidate_Id(int candidateId);
	
	DataResult<List<Photo>> getAll();

	Result delete(int id);

	DataResult<Optional<Photo>> getById(int id);

	Result add(Photo photo, MultipartFile file);

	Boolean isExists(int id);
}
