package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hrms.javaBackend.entities.concretes.SocialMedia;


public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
	List<SocialMedia> getAllBycandidate_id(int id);
}
