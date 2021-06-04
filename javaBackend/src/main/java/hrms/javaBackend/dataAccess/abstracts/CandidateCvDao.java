package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hrms.javaBackend.entities.concretes.CandidateCv;


public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	List<CandidateCv> getAllBycandidate_id(int id);
}
