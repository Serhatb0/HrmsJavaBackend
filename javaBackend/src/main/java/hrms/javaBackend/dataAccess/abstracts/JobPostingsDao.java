package hrms.javaBackend.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.JobPostings;

public interface JobPostingsDao extends JpaRepository<JobPostings, Integer> {
	List<JobPostings> getAllByEmployer_Id(int employerId); // Sistemde bir firmaya ait tüm İş İlanları Gosterir

	JobPostings getAllByjobPostingsIdAndEmployer_Id(int jobPostingsId,int employerId);

	List<JobPostings> getAllByApplicationDeadlineLessThanEqual(LocalDate date); // Sistemdeki tüm aktif iş ilanları tarihe göre listeler.
	
	List<JobPostings> getAllByisActive(Boolean isActive); // Sistemdeki tüm aktif iş ilanları Gosterir 
	
	JobPostings getAllByjobPostingsId(int jobPostingsId);
	

}
