package hrms.javaBackend.validator.abstracts;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


import hrms.javaBackend.validator.concretes.UniqueIdentityNumberValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueIdentityNumberValidator.class })
public @interface UniqueIdentityNumber {
	String message() default "{hrms.constraints.UniqueIdentityNumber.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
