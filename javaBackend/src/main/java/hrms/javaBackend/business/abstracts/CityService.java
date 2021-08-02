package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.entities.concretes.City;

public interface CityService {
 
	
	DataResult<List<City>> getAll();

	DataResult<City> getAllBycityId(int cityId);
	
	
}
