package hrms.javaBackend.business.concretes;

import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmailService;
import hrms.javaBackend.core.dataAccess.ConfirmationTokenRepository;
import hrms.javaBackend.core.entities.UploadFileResponse;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.entities.concretes.User;

@Service
public class EmailManager implements EmailService {
	
	private JavaMailSender mailSender;
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	@Autowired
	public EmailManager(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	@Override
	public Result sendEmail(User user, String email) {
		 MimeMessage mimeMessage = mailSender.createMimeMessage();
	     MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

	        try {
	            messageHelper.setTo(email);
	            messageHelper.setText("Email Göderildi");
	            messageHelper.setSubject("Deneme");
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	        mailSender.send(mimeMessage);
	        
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
