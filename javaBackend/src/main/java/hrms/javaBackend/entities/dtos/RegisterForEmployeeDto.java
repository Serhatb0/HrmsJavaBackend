package hrms.javaBackend.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployeeDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
