package hrms.javaBackend.business.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.UserCheckService;

@Service
public class FakeMernisManager implements UserCheckService {
	@Override
	public Boolean checkIfRealPerson(String nationalityId, String firstName, String lastName,
			LocalDate dateOfBirthYear) {
		return true;
	}
}
