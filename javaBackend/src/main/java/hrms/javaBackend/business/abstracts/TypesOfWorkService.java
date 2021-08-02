package hrms.javaBackend.business.abstracts;


import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.TypesOfWork;

public interface TypesOfWorkService {

	DataResult<List<TypesOfWork>> getAll();
	
	DataResult<TypesOfWork> getAllById(int id);

	Result add(TypesOfWork typesOfWork);

	Result update(TypesOfWork typesOfWork);

	Result delete(TypesOfWork typesOfWork);

}
