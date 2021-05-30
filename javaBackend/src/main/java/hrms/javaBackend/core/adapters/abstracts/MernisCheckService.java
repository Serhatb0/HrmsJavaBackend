package hrms.javaBackend.core.adapters.abstracts;

import org.springframework.stereotype.Service;

import hrms.javaBackend.entities.concretes.Candidate;

@Service
public interface MernisCheckService {
	public boolean checkIfRealPerson(Candidate candidate);
}
