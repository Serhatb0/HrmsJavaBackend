package hrms.javaBackend.business.abstracts;

import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.entities.concretes.User;

public interface EmailServiceBusiness {
	Result sendEmail(User user ,String email);
	public  boolean isValid(String email);
}
