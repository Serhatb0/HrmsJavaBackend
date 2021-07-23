package hrms.javaBackend.entities.dtos.CreateDtos;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import hrms.javaBackend.validator.abstracts.UniqueEmail;
import hrms.javaBackend.validator.abstracts.UniqueIdentityNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateCreateDto {
	
	@NotNull()
	@NotBlank
	private String firstName;
	@NotNull()
	@NotBlank
	private String lastName;
	@NotNull()
	@NotBlank
	@UniqueIdentityNumber
	private String IdentityNumber;
	@NotNull()
	private LocalDate birthDate;
	@NotNull()
	@NotBlank
	@Email
	@UniqueEmail
	private String email;
	@NotNull()
	@NotBlank
	@Size(min = 6, max=15)
	private String password;
	@NotNull()
	@NotBlank
	@Size(min = 6, max=15)
	private String passwordConfrim;
	
}
