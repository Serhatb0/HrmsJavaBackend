package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.SocialMedia;

public interface SocialMediaService {

	
	DataResult<List<SocialMedia>> getAll();
	
	Result add(SocialMedia socialMedia);
}
