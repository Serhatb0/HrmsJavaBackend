package hrms.javaBackend.validator.concretes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import hrms.javaBackend.dataAccess.abstracts.UserDao;
import hrms.javaBackend.validator.abstracts.UniqueEmail;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>  {

	private final UserDao userDao;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !userDao.existsUserByEmail(email);
	}
}
