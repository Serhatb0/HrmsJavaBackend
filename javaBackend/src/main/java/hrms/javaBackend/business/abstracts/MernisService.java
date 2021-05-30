package hrms.javaBackend.business.abstracts;

import hrms.javaBackend.entities.concretes.Candidate;

public interface MernisService {

	 boolean validate(Candidate candidate);
}
