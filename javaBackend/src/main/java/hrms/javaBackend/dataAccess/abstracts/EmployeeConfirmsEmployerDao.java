package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.EmployeeConfirmsEmployer;


public interface EmployeeConfirmsEmployerDao extends JpaRepository<EmployeeConfirmsEmployer, Integer>{
	EmployeeConfirmsEmployer findByemployer_companyName(String companyName);
}
