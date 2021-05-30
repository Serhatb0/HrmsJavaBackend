package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
