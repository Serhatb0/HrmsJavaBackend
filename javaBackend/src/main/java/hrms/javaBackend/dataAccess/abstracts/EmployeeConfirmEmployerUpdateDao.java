package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.EmployeeConfirmEmployerUpdate;

public interface EmployeeConfirmEmployerUpdateDao extends JpaRepository<EmployeeConfirmEmployerUpdate, Integer>{

}
