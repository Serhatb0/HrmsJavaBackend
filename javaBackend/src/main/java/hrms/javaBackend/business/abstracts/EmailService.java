package hrms.javaBackend.business.abstracts;

import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.User;

public interface EmailService {
	Result sendEmail(User user);
	public  boolean isValid(String email);
}
