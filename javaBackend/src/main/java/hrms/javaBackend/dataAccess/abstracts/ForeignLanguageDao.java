package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hrms.javaBackend.entities.concretes.ForeignLanguage;


public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
	List<ForeignLanguage> getAllBycandidate_id(int id);
}
