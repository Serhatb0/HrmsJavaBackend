package hrms.javaBackend.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDto {
	
	private String firstName;
	private String lastName;
	private String IdentityNumber;
	private LocalDate birthDate;
	private String email;
	private String password;
	private String passwordConfrim;
	private Date createdDate;
}
