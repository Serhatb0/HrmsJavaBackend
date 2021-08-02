package hrms.javaBackend.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.CandidateService;
import hrms.javaBackend.business.abstracts.ForeignLanguageService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessDataResult;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.dataAccess.abstracts.ForeignLanguageDao;
import hrms.javaBackend.entities.concretes.ForeignLanguage;
import hrms.javaBackend.entities.dtos.CreateDtos.ForeignLanguageCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.ForeignLanguageViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.ForeignLanguageUpdateDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDao;
	private ModelMapper modelMapper;
	private CandidateService candidateService;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao, ModelMapper modelMapper,
			CandidateService candidateService) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
		this.modelMapper = modelMapper;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<ForeignLanguageViewDto>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageViewDto>>(
				this.foreignLanguageDao.findAll().stream().map(ForeignLanguageViewDto::of).collect(Collectors.toList()),
				"Data Listelendi");
	}

	@Override
	public Result add(ForeignLanguageCreateDto foreignLanguageCreateDto) {
		ForeignLanguage foreignLanguage = modelMapper.map(foreignLanguageCreateDto, ForeignLanguage.class);

		foreignLanguage.setCreatedDate(new Date());
		foreignLanguage
				.setCandidate(this.candidateService.getAllById(foreignLanguageCreateDto.getCandidateId()).getData());

		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("ForeignLanguage Kaydedildi");
	}

	@Override
	public Result update(int id, ForeignLanguageUpdateDto foreignLanguageUpdateDto) {
		ForeignLanguage foreignLanguage = this.foreignLanguageDao.findAllByforeignLanguagesId(id);

		foreignLanguage.setLanguageName(foreignLanguageUpdateDto.getLanguageName());
		foreignLanguage.setLanguageLevel(foreignLanguageUpdateDto.getLanguageLevel());

		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Foreign Language Güncellendi");
	}

	@Override
	public Result delete(int id) {
		ForeignLanguage foreignLanguage = this.foreignLanguageDao.findAllByforeignLanguagesId(id);
		this.foreignLanguageDao.deleteById(foreignLanguage.getForeignLanguagesId());
		return new SuccessResult("ForeignLanguage Silindi");
	}

	@Override
	public DataResult<List<ForeignLanguageViewDto>> getallByCandidateId(int id) {
		return new SuccessDataResult<List<ForeignLanguageViewDto>>(this.foreignLanguageDao.getAllBycandidate_id(id)
				.stream().map(ForeignLanguageViewDto::of).collect(Collectors.toList()), "Data Listelendi");
	}

}
