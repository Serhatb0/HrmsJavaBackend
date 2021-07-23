package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	Employee getAllById(int id);



	@Transactional
	@Modifying
	@Query("update Employee e set e.firstName = :firstName,e.lastName = :lastName,e.email=:email where e.id = :id")
	void updateEmployee(@Param("id") int id, @Param("firstName") 
	String firstName,@Param("lastName") String lastName,@Param("email") String email);








}
