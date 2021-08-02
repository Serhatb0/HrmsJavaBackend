package hrms.javaBackend.entities.dtos.CreateDtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class JobPostingsCreateDto {

	@NotNull()
	private int emloyerId;
	@NotNull()
	@NotBlank
	private String jobDescription;
	@NotNull()
	private int minSalary;
	@NotNull()
	private int maxSalary;
	@NotNull()
	private LocalDate applicationDeadline;
	@NotNull()
	private int numberOfOpenPositions;
	@NotNull()
	private int cityId;
	@NotNull()
	private int jobPositionId;
	@NotNull()
	private int typesOfWorkId;


}
