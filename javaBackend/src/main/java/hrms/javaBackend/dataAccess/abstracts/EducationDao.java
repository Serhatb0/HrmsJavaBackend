package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	List<Education> getAllBycandidate_id(int id);
}
