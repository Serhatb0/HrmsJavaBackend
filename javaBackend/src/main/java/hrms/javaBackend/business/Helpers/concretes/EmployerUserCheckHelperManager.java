package hrms.javaBackend.business.Helpers.concretes;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.EmployerUserCheckHelperService;
import hrms.javaBackend.entities.concretes.Employer;

@Service
public class EmployerUserCheckHelperManager implements EmployerUserCheckHelperService {

	@Override
	public boolean allFieldsAreRequired(Employer employer) {
		  if (employer.getEmail().isEmpty()
	                || employer.getPassword().trim().isEmpty()
	                || employer.getCompanyName().trim().isEmpty()
	                || employer.getWebAddress().trim().isEmpty())
	        {
	            return false;
	        }
	        return true;
	}

}
