package hrms.javaBackend.entities.dtos.ViewDtos;

import java.io.Serializable;


import hrms.javaBackend.entities.concretes.ForeignLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ForeignLanguageViewDto implements Serializable {

	private static final long serialVersionUID = 1L;


	private int foreignLanguagesId;
	
	
	private String languageName;
	

	private int languageLevel;
	
	
	public static ForeignLanguageViewDto of(ForeignLanguage foreignLanguage) {

		return new ForeignLanguageViewDto(foreignLanguage.getForeignLanguagesId(),foreignLanguage.getLanguageName(),foreignLanguage.getLanguageLevel());

	}


}
