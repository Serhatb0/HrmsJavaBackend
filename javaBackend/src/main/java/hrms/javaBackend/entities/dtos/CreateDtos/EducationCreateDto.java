package hrms.javaBackend.entities.dtos.CreateDtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EducationCreateDto {

	@NotNull()
	private int id;
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
	private Boolean schoolStatus;

}
