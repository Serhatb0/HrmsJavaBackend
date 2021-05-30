package hrms.javaBackend.business.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmailService;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.entities.concretes.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result sendEmail(User user) {
		return new SuccessResult("Email Göderildi : " +user.getEmail());
	}
	
	@Override
	public  boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}
