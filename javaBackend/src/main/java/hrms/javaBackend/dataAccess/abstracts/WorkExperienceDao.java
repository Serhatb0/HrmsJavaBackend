package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	List<WorkExperience> getAllBycandidate_id(int id);
}
