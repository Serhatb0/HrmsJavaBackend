package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.JobPostings;
import hrms.javaBackend.entities.concretes.ViewCv;

public interface ViewCvDao extends JpaRepository<ViewCv, Integer> {
	
	List<ViewCv> getAllByeducation_schoolStatusTrue(); // Okul Durumu Aktif Olanları Gosterir
	
	List<ViewCv> getAllByeducation_schoolStatusFalse(); // Mezun Olanları Gosterir
	
	List<ViewCv> getAllByworkExperience_operationTimeGreaterThanEqual(int number); // Teçrubeye Gore Sıralama
	
	List<ViewCv> getAllByworkExperience_workingStatusTrue(); // Hala Aktif Çalışanları Gosterir
	
	List<ViewCv> getAllByworkExperience_workingStatusFalse(); // Çalışmayanları Gosterir
	
	
 }
