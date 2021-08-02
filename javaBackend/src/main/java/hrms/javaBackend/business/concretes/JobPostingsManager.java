package hrms.javaBackend.business.concretes;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.CityService;
import hrms.javaBackend.business.abstracts.EmployerService;
import hrms.javaBackend.business.abstracts.JobPositionService;
import hrms.javaBackend.business.abstracts.JobPostingsService;
import hrms.javaBackend.business.abstracts.TypesOfWorkService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.ErrorResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.JobPostingsDao;

import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.dtos.JobPostingsFilter;
import hrms.javaBackend.entities.dtos.CreateDtos.JobPostingsCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.JobPostingsViewDto;

@Service
public class JobPostingsManager implements JobPostingsService {

	private JobPostingsDao jobPostingsDao;
	private ModelMapper modelMapper;
	private CityService cityService;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	private TypesOfWorkService typesOfWorkService;

	@Autowired
	public JobPostingsManager(JobPostingsDao jobPostingsDao, ModelMapper modelMapper, CityService cityService,
			JobPositionService jobPositionService, EmployerService employerService,
			TypesOfWorkService typesOfWorkService) {
		super();
		this.jobPostingsDao = jobPostingsDao;
		this.modelMapper = modelMapper;
		this.cityService = cityService;
		this.jobPositionService = jobPositionService;
		this.employerService = employerService;
		this.typesOfWorkService = typesOfWorkService;
	}

	@Override
	public DataResult<List<JobPostingsViewDto>> getAll() {
		return new SuccessDataResult<List<JobPostingsViewDto>>(
				this.jobPostingsDao.findAll().stream().map(JobPostingsViewDto::of).collect(Collectors.toList()));
	}

	@Override
	public DataResult<List<JobPostingsViewDto>> getByIsActiveAndPageNumberAndFilter(int pageNo, int pageSize,
			JobPostingsFilter jobPostingsFilter, int min, int max) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPostingsViewDto>>(
				this.jobPostingsDao.getByAllFilter(jobPostingsFilter, pageable, min, max).stream()
						.map(JobPostingsViewDto::of).collect(Collectors.toList()),
				this.jobPostingsDao.getByAllFilter(jobPostingsFilter, pageable, min, max).getTotalElements() + "");
	}
	
	@Override
	public DataResult<JobPostingsViewDto> getAllByjobPostingsId(int jobPostingsId) {
		 JobPostings jobPostings = this.jobPostingsDao.getAllByjobPostingsId(jobPostingsId);
		 
		 return new SuccessDataResult<JobPostingsViewDto>(JobPostingsViewDto.of(jobPostings)); 
	}

	@Override
	public Result add(JobPostingsCreateDto jobPostingsCreateDto) {
		JobPostings jobPostings = modelMapper.map(jobPostingsCreateDto, JobPostings.class);

		jobPostings.setCreatedDate(new Date());
		jobPostings.setEmployer(this.employerService.findById(jobPostingsCreateDto.getEmloyerId()).getData());
		jobPostings.setCity(this.cityService.getAllBycityId(jobPostingsCreateDto.getCityId()).getData());
		jobPostings
				.setJobPosition(this.jobPositionService.getAllById(jobPostingsCreateDto.getJobPositionId()).getData());
		jobPostings
				.setTypesOfWork(this.typesOfWorkService.getAllById(jobPostingsCreateDto.getTypesOfWorkId()).getData());
		this.jobPostingsDao.save(jobPostings);
		return new SuccessResult("İş Kaydedildi");
	}

	@Override
	public DataResult<List<JobPostings>> getAllByEmployer(int employerId) {
		return new SuccessDataResult<List<JobPostings>>(this.jobPostingsDao.getAllByEmployer_Id(employerId),
				"Data Listelendi");
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
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.findByjobPostingsId(jobPostingsId),
				"İş Pasif Edildi ");
	

	}

	

	@Override
	public DataResult<List<JobPostings>> getAllByisActive(Boolean isActive, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPostings>>(
				this.jobPostingsDao.getAllByisActive(pageable, isActive).getContent(),
				this.jobPostingsDao.getAllByisActive(pageable, isActive).getTotalElements() + "");
	}

	@Override
	public DataResult<List<JobPostings>> getAllByisActiveIsNull(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobPostings>>(
				this.jobPostingsDao.getAllByisActiveIsNull(pageable).getContent(),
				this.jobPostingsDao.getAllByisActiveIsNull(pageable).getTotalElements() + "");
	}

	@Override
	public DataResult<JobPostings> getAllByjobId(int jobPostingsId) {
		return new SuccessDataResult<JobPostings>(this.jobPostingsDao.findByjobPostingsId(jobPostingsId));
	}

}
