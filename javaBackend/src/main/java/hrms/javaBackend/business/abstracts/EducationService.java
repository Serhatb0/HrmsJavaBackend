package hrms.javaBackend.business.abstracts;

import java.util.List;



import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;

import hrms.javaBackend.entities.dtos.CreateDtos.EducationCreateDto;
import hrms.javaBackend.entities.dtos.ViewDtos.EducationViewDto;
import hrms.javaBackend.entities.dtos.updateDtos.EducationUpdateDto;

public interface EducationService {

	
	DataResult<List<EducationViewDto>> getAll();
	
	Result add(EducationCreateDto educationCreateDto);

	DataResult<List<EducationViewDto>> getAllBycandidate_id(int id);


	Result update( int id,EducationUpdateDto educationUpdateDto);

	Result deleteEducation(int id);

	DataResult<EducationViewDto> getAllById(int id);
}
