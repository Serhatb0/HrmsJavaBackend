package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EducationService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EducationDao;
import hrms.javaBackend.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}


	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Education listelendi");
	}


	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education Kaydedildi");
	}


	@Override
	public DataResult<List<Education>> getAllBycandidate_id(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllBycandidate_id(id));
	}
	
	
	
	
	
	
}
