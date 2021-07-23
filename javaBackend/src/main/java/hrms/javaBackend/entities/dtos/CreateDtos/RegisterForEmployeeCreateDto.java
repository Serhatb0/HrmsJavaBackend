package hrms.javaBackend.entities.dtos.CreateDtos;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import hrms.javaBackend.validator.abstracts.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployeeCreateDto {
	
	@NotNull()
	@NotBlank
	@Size(min = 3, max=20)
	private String firstName;
	@NotNull()
	@NotBlank
	@Size(min = 3, max=20)
	private String lastName;
	@NotNull()
	@NotBlank
	@Email
	@UniqueEmail
	private String email;
	@NotNull()
	@NotBlank
	@Size(min = 6, max=15)
	private String password;
}
