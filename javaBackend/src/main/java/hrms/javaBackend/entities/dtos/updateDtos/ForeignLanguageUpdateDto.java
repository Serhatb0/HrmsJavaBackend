package hrms.javaBackend.entities.dtos.updateDtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ForeignLanguageUpdateDto {


	
	

	@NotNull()
	@NotBlank
	private String languageName;
	

	@NotNull()
	private int languageLevel;

	
	
}
