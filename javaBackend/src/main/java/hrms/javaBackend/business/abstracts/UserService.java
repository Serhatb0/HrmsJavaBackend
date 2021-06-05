package hrms.javaBackend.business.abstracts;

import java.util.List;

import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	DataResult<User> findByEmailIgnoreCase(String emailId);
}
