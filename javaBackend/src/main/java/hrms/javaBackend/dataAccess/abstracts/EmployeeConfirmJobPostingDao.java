package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.EmployeeConfirmJobPosting;


public interface EmployeeConfirmJobPostingDao extends JpaRepository<EmployeeConfirmJobPosting, Integer> {
	
	EmployeeConfirmJobPosting findByjobPostings_jobPostingsId(int jobPostingsId);
}	
