package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Candidate;



public interface CandidateDao  extends JpaRepository<Candidate, Integer>{
	 List<Candidate> findByEmailIs(String email);
	 List<Candidate>  findByIdentityNumberIs(String identityNumber);

	
	
}


