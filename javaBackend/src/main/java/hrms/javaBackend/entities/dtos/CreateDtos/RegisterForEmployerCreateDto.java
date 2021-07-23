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
public class RegisterForEmployerCreateDto {
		
		@NotNull()
		@NotBlank
		private String companyName;
		@NotNull()
		@NotBlank
		private String webAddress;
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
		private String passwordConfirm;
		
}
