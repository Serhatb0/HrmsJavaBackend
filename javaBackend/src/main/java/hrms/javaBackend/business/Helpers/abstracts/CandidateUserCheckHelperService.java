package hrms.javaBackend.business.Helpers.abstracts;

import hrms.javaBackend.entities.concretes.Candidate;

public interface CandidateUserCheckHelperService {
	public boolean allFieldsAreRequired(Candidate candidate);
}
