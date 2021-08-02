package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.TypesOfWorkService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.dataAccess.abstracts.TypesOfWorkDao;
import hrms.javaBackend.entities.concretes.TypesOfWork;

@Service
public class TypesOfWorkManager implements TypesOfWorkService {

	private TypesOfWorkDao typesOfWorkDao;
	
	
	@Autowired
	public TypesOfWorkManager(TypesOfWorkDao typesOfWorkDao) {
		super();
		this.typesOfWorkDao = typesOfWorkDao;
	}

	@Override
	public DataResult<List<TypesOfWork>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(TypesOfWork typesOfWork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(TypesOfWork typesOfWork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(TypesOfWork typesOfWork) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<TypesOfWork> getAllById(int id) {
		return new SuccessDataResult<TypesOfWork>(this.typesOfWorkDao.findAllById(id));
	}

}
