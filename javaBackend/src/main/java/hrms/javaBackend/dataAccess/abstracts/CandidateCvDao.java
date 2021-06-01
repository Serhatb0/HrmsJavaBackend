package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Candidate;
import hrms.javaBackend.entities.concretes.CandidateCv;
import hrms.javaBackend.entities.concretes.JobPostings;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	
}
