package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getAllById(int id);
	
	
	
	List<Candidate> findByEmailIs(String email);

	List<Candidate> findByIdentityNumberIs(String identityNumber);

	List<Candidate> getAllByeducations_schoolStatusTrue(); // Okul Durumu Aktif Olanları Gosterir

	
	
	List<Candidate> getAllByeducations_schoolStatusFalse(); // Mezun Olanları Gosterir

	List<Candidate> getAllByworkExperiences_operationTimeGreaterThanEqual(int number); // Teçrubeye Gore Sıralama

	List<Candidate> getAllByworkExperiences_workingStatusTrue(); // Hala Aktif Çalışanları Gosterir

	List<Candidate> getAllByworkExperiences_workingStatusFalse(); // Çalışmayanları Gosterir



	boolean existsCandidateByIdentityNumber(String identityNumber);

}
