package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

	List<Photo> getAllByCandidate_Id(int candidateId);
}
