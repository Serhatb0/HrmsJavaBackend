package hrms.javaBackend.business.abstracts;

import java.time.LocalDate;




public interface UserCheckService {
	
    Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName, LocalDate dateOfBirthYear);
}