package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.CandidatesDetail;


public interface CandidatesDetailDao extends JpaRepository<CandidatesDetail, Integer> {
	List<CandidatesDetail> getAllBycandidate_id(int id);
}
