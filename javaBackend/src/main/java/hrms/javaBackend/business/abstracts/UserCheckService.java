package hrms.javaBackend.business.abstracts;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;


public interface UserCheckService {
	
    Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear);
}