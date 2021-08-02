package hrms.javaBackend.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.business.abstracts.EducationService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.EducationDao;

import hrms.javaBackend.entities.concretes.Education;
import hrms.javaBackend.entities.dtos.CreateDtos.EducationCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.EducationViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.EducationUpdateDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	private CandidateService candidateService;

	@Autowired
	public EducationManager(EducationDao educationDao, CandidateService candidateService) {
		super();
		this.educationDao = educationDao;

		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<EducationViewDto>> getAll() {
		return new SuccessDataResult<List<EducationViewDto>>(
				this.educationDao.findAll().stream().map(EducationViewDto::of).collect(Collectors.toList()),
				"Data Listelendi");

	}

	@Override
	public Result add(EducationCreateDto educationCreateDto) {
		Education education = new Education(educationCreateDto.getSchoolName(), educationCreateDto.getEpisode(),
				educationCreateDto.getStartOfSchool(), educationCreateDto.getGraduationYear(),
				educationCreateDto.getSchoolStatus());

		education.setCreatedDate(new Date());
		education.setCandidate(this.candidateService.getAllById(educationCreateDto.getId()).getData());

		this.educationDao.save(education);

		return new SuccessResult("Education Kaydedildi");
	}

	@Override
	public DataResult<List<EducationViewDto>> getAllBycandidate_id(int id) {
		return new SuccessDataResult<List<EducationViewDto>>(this.educationDao.getAllBycandidate_id(id).stream()
				.map(EducationViewDto::of).collect(Collectors.toList()), "Data Listelendi");
	}

	@Override
	public Result update(int id, EducationUpdateDto educationUpdateDto) {
		Education education = this.educationDao.findByEducationId(id);

		education.setEpisode(educationUpdateDto.getEpisode());
		education.setGraduationYear(educationUpdateDto.getGraduationYear());
		education.setSchoolName(educationUpdateDto.getSchoolName());
		education.setSchoolStatus(educationUpdateDto.getSchoolStatus());
		education.setStartOfSchool(educationUpdateDto.getStartOfSchool());

		this.educationDao.save(education);
		return new SuccessResult("Education Güncellendi");

	}

	@Override
	public Result deleteEducation(int id) {
		final Education education = this.educationDao.findByEducationId(id);
		this.educationDao.deleteById(education.getEducationId());
		return new SuccessResult("Education Silindi");
	}

	@Override
	public DataResult<EducationViewDto> getAllById(int id) {
		Education education =this.educationDao.getAllByEducationId(id);
		return new SuccessDataResult<EducationViewDto>(EducationViewDto.of(education));
			
	}

}
