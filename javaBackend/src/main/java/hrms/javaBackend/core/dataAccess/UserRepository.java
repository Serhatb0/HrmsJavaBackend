package hrms.javaBackend.core.dataAccess;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hrms.javaBackend.entities.concretes.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String> {

    User findByEmailIgnoreCase(String emailId);
}
