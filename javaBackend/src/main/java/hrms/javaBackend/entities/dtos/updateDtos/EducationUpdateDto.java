package hrms.javaBackend.entities.dtos.updateDtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EducationUpdateDto  {
	
	@NotNull()
	@NotBlank
	private String schoolName;
	@NotNull()
	@NotBlank
	private String episode;
	@NotNull()
	private LocalDate startOfSchool;
	@NotNull()
	private LocalDate graduationYear;
	@NotNull()
	@NotBlank
	private Boolean schoolStatus;
	


}
