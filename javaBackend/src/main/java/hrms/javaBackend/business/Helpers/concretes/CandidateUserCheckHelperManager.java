package hrms.javaBackend.business.Helpers.concretes;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.Helpers.abstracts.CandidateUserCheckHelperService;
import hrms.javaBackend.entities.concretes.Candidate;

@Service
public class CandidateUserCheckHelperManager implements CandidateUserCheckHelperService {

	@Override
	public boolean allFieldsAreRequired(Candidate candidate) {
		 if (candidate.getEmail().trim().isEmpty()
	                || candidate.getPassword().trim().isEmpty()
	                || candidate.getFirstName().trim().isEmpty()
	                || candidate.getLastName().trim().isEmpty()
	                || candidate.getIdentityNumber().trim().isEmpty()
	                || candidate.getBirthDate().toString().trim().isEmpty())
	        {
	            return false;
	        }
	        return true;
	}

}
