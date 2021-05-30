package hrms.javaBackend.business.Helpers.abstracts;

import hrms.javaBackend.entities.concretes.Employer;

public interface EmployerApprovalService {
	public boolean confirmEmployer(Employer employer);
	
}
