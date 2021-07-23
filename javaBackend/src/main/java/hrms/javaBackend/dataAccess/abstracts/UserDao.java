package hrms.javaBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.javaBackend.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmailIgnoreCase(String emailId);

	boolean existsUserByEmail(String email);
}
