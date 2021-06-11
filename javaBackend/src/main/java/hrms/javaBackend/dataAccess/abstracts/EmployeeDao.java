package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.Employee;
import hrms.javaBackend.entities.concretes.JobPostings;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	Employee getAllById(int id);
}
