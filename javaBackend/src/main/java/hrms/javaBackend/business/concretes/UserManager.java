package hrms.javaBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.UserService;
import hrms.javaBackend.core.utilities.results.DataResult;
import hrms.javaBackend.dataAccess.abstracts.UserDao;
import hrms.javaBackend.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> findByEmailIgnoreCase(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
