package hrms.javaBackend.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDto {

		private String companyName;
		private String webAddress;
		private String email;
		private String password;
		private String passwordConfirm;
		
}
