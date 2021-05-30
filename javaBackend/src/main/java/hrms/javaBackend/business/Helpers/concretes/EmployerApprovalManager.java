package hrms.javaBackend.business.Helpers.concretes;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.EmployerApprovalService;
import hrms.javaBackend.entities.concretes.Employer;

@Service
public class EmployerApprovalManager implements EmployerApprovalService {

	@Override
	public boolean confirmEmployer(Employer employer) {
		return true;
	}

}
