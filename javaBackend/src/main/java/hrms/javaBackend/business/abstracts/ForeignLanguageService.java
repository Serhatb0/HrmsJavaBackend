package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.dtos.CreateDtos.ForeignLanguageCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.ForeignLanguageViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.ForeignLanguageUpdateDto;

public interface ForeignLanguageService {

	DataResult<List<ForeignLanguageViewDto>> getAll();
	
	Result add(ForeignLanguageCreateDto foreignLanguageCreateDto);
	
	Result update(int id,ForeignLanguageUpdateDto foreignLanguageUpdateDto);

	Result delete(int id);

	DataResult<List<ForeignLanguageViewDto>> getallByCandidateId(int id);
}
