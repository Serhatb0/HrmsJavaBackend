package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import hrms.javaBackend.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	List<Employer> findByEmailIs(String email);
	
	List<Employer> findBystaffApprovalIsNull();
	
	List<Employer> findBystaffApprovalFalse();
	
	List<Employer> findBystaffApprovalTrue();
	
	Employer findById(int employerId);
	
	Employer findBycompanyName(String companyName);
	
	
	@Transactional
	@Modifying
	@Query("update Employer e set e.companyName = :companyName,e.webAddress = :webAddress,e.email=:email where e.id = :id")
	void updateEmployer(@Param("id") int id, @Param("companyName") 
	String companyName,@Param("webAddress") String webAddressi,@Param("email") String email);
}

