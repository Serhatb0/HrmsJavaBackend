package hrms.javaBackend.business.concretes;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.JobPostingsDao;

import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.dtos.JobPostingsFilter;
import hrms.javaBackend.entities.dtos.ViewDtos.JobPostingsViewDto;
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
	public DataResult<List<JobPostingsViewDto>> getAll() {
		return new SuccessDataResult<List<JobPostingsViewDto>>(this.jobPostingsDao.findAll().stream().map(JobPostingsViewDto::of).collect(Collectors.toList()));
	}

	@Override
	public Result add(JobPostings jobPostings) {
		this.jobPostingsDao.save(jobPostings);
		return new SuccessResult("İş Kaydedildi");
	}

	@Override
	public DataResult<List<JobPostings>> getAllByEmployer(int employerId) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByEmployer_Id(employerId),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostings>> getAllByApplicationDeadlineLessThanEqual(LocalDate date) {
		return new SuccessDataResult<List<JobPostings>>(
				this.jobPostingsDao.getAllByApplicationDeadlineLessThanEqual(date), "Tarihe Göre Listelendi");
	}

	
	
	@Override
	public Result passiveAdvertisement(int jobPostingsId, int employerId) {
		JobPostings jobPostings = this.jobPostingsDao.getAllByjobPostingsIdAndEmployer_Id(jobPostingsId, employerId);
		if (this.jobPostingsDao.getAllByjobPostingsIdAndEmployer_Id(jobPostingsId, employerId) == null) {
			return new ErrorResult("İş İlanaı Yok");
		}
		if (jobPostings.getIsActive() == false) {
			return new ErrorResult("Zaten İş Kaydı Aktif Değil");
		}
		jobPostings.setIsActive(false);
		this.jobPostingsDao.save(jobPostings);
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.getAllByjobPostingsId(jobPostingsId),
				"İş Pasif Edildi ");

	}

	@Override
	public DataResult<List<JobPostings>> getAllByCity_cityName(String cityName) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByCity_cityName(cityName),
				"Data Listelendi");
	}

	
	@Override
	public DataResult<JobPostings> getAllByjobPostingsId(int jobPostingsId) {
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.getAllByjobPostingsId(jobPostingsId));
	}

	@Override
	public DataResult<List<JobPostings>> getMinSalaryAndMaxSalary(int minSalary, int maxSalary) {
		return new SuccessDataResult<List<JobPostings>>(
				this.jobPostingsDao.getMinSalaryAndMaxSalary(minSalary, maxSalary), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostings>> getAllPage(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<JobPostings>> findBycreatedDateLessThanEqual(Date currentDate) {

		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.findBycreatedDateLessThanEqual(currentDate),
				"Data Listelendi");
	}

	

	@Override
	public DataResult<List<JobPostings>> getDene(int min, int max, int cityId) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getDene(min, max, cityId),"Listelndi");
	}
	
	@Override
	public DataResult<List<JobPostings>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize,
			JobPostingsFilter jobPostingsFilter,int min,int max) {
		 Pageable pageable = PageRequest.of(pageNo -1, pageSize);
	        return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getByAllFilter(jobPostingsFilter, pageable , min, max).getContent(), this.jobPostingsDao.getByAllFilter(jobPostingsFilter,pageable, min, max).getTotalElements()+"");
	}

	@Override
	public DataResult<List<JobPostings>> getAllByisActive(Boolean isActive, int pageNo, int pageSize) {
		 Pageable pageable = PageRequest.of(pageNo -1, pageSize);
			return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByisActive(pageable,isActive).getContent(),this.jobPostingsDao.getAllByisActive(pageable, isActive).getTotalElements()+"");
	}
	
	@Override
	public DataResult<List<JobPostings>> getAllByisActiveIsNull(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByisActiveIsNull(pageable).getContent(),this.jobPostingsDao.getAllByisActiveIsNull(pageable).getTotalElements()+"");
	}


	


	

	

}
