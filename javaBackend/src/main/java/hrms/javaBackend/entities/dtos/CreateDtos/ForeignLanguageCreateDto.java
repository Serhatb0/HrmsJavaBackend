package hrms.javaBackend.entities.dtos.CreateDtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.Data;


@Data
public class ForeignLanguageCreateDto {

	
	
	@NotNull()
	private int candidateId;

	@NotNull()
	@NotBlank
	private String languageName;
	

	@NotNull()
	private int languageLevel;

}
