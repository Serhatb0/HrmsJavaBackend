package hrms.javaBackend.business.Helpers.abstracts;

import hrms.javaBackend.entities.concretes.Employer;

public interface EmployerUserCheckHelperService {
	public boolean allFieldsAreRequired(Employer employer);
}
