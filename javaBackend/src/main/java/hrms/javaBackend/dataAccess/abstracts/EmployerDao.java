package hrms.javaBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	List<Employer> findByEmailIs(String email);
}
