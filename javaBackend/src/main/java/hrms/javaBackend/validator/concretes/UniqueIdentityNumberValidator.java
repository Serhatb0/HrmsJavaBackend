package hrms.javaBackend.validator.concretes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import hrms.javaBackend.dataAccess.abstracts.CandidateDao;
import hrms.javaBackend.validator.abstracts.UniqueIdentityNumber;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueIdentityNumberValidator implements ConstraintValidator<UniqueIdentityNumber, String> {

	private final CandidateDao candidateDao;

	@Override
	public boolean isValid(String identityNumber, ConstraintValidatorContext context) {
		return !candidateDao.existsCandidateByIdentityNumber(identityNumber);
	}
	
	
	
}
