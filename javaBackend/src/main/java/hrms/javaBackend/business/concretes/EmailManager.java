package hrms.javaBackend.business.concretes;

import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import hrms.javaBackend.business.abstracts.EmailServiceBusiness;
import hrms.javaBackend.core.EmailService;
import hrms.javaBackend.core.adapters.concretes.CloudinaryService;
import hrms.javaBackend.core.dataAccess.ConfirmationTokenRepository;
import hrms.javaBackend.core.entities.ConfirmationToken;
import hrms.javaBackend.core.entities.UploadFileResponse;
import hrms.javaBackend.core.utilities.results.Result;
import hrms.javaBackend.core.utilities.results.SuccessResult;
import hrms.javaBackend.entities.concretes.User;

@Service
public class EmailManager implements EmailServiceBusiness {
	
	
	private JavaMailSender mailSender;
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	@Autowired
	public EmailManager(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}
	
	@Autowired
	private EmailService emailService;

	@Override
	public Result sendEmail(User user, String email) {

		ConfirmationToken confirmationToken = new ConfirmationToken(user);

		confirmationTokenRepository.save(confirmationToken);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Konu");
		mailMessage.setFrom(email);
		mailMessage.setText("Aktivasyon Linki : "
				+ "http://localhost:8080/api/Users/confirm-account?token=" + confirmationToken.getConfirmationToken());

		emailService.sendEmail(mailMessage);
		
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
