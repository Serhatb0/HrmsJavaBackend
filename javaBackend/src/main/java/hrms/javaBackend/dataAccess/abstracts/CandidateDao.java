package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.concretes.User;
import hrms.javaBackend.entities.dtos.RegisterForCandidateDto;


public interface CandidateDao  extends JpaRepository<Candidate, Integer>{
	 List<Candidate> findByEmailIs(String email);
	 List<Candidate>  findByIdentityNumberIs(String identityNumber);
	 
	
	 

}


