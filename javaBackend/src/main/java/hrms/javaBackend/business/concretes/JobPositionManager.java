package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.JobPositionService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.JobPositionDao;
import hrms.javaBackend.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(
			this.jobPositionDao.findAll(),"İş Pozisyonları Listelendi"	
				);
		
	}


	@Override
	public Result add(JobPosition jopJobPosition) {
		this.jobPositionDao.save(jopJobPosition);
		return new SuccessResult("İş Pozisyonu Eklendi");
	}


	@Override
	public DataResult<JobPosition> getAllById(int jobPositionId) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.getAllById(jobPositionId));
	}

}
