package hrms.javaBackend.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.JobPostingsDao;

import hrms.javaBackend.entities.concretes.JobPostings;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobPostingsManager implements JobPostingsService {

	private JobPostingsDao jobPostingsDao;
	
	
	@Autowired
	public JobPostingsManager(JobPostingsDao jobPostingsDao) {
		super();
		this.jobPostingsDao = jobPostingsDao;
	}


	@Override
	public DataResult<List<JobPostings>> getAll() {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.findAll(),"İş Verenler Listelendi");
	}


	@Override
	public Result add(JobPostings jobPostings) {
		this.jobPostingsDao.save(jobPostings);
		return new SuccessResult("İş Kaydedildi");
	}


	@Override
	public DataResult<List<JobPostings>> getAllByEmployer(int employerId) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByEmployer_Id(employerId),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobPostings>> getAllByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByApplicationDeadlineLessThanEqual(date),"Tarihe Göre Listelendi");
	}


	@Override
	public DataResult<List<JobPostings>> getAllByisActive(Boolean isActive) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByisActive(isActive),"Aktif İş İlanları Listelendi");
	}


	@Override
	public Result passiveAdvertisement(int jobPostingsId, int employerId) {
		JobPostings jobPostings = this.jobPostingsDao.getAllByjobPostingsIdAndEmployer_Id(jobPostingsId,employerId);
		if(this.jobPostingsDao.getAllByjobPostingsIdAndEmployer_Id(jobPostingsId,employerId) == null) {
			return new ErrorResult("İş İlanaı Yok");
		}
		if(jobPostings.getIsActive() == false) {
			return new ErrorResult("Zaten İş Kaydı Aktif Değil");
		}
		jobPostings.setIsActive(false);
		this.jobPostingsDao.save(jobPostings);
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.getAllByjobPostingsId(jobPostingsId),"İş Pasif Edildi ");
		
	}


	@Override
	public DataResult<List<JobPostings>> getAllByCity_cityName(String cityName) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByCity_cityName(cityName),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobPostings>> getAllByisActiveIsNull() {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByisActiveIsNull());
	}


	@Override
	public DataResult<JobPostings> getAllByjobPostingsId(int jobPostingsId) {
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.getAllByjobPostingsId(jobPostingsId));
	}


	

	

}
