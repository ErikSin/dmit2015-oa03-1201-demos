package common.security.model;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, LoginUser> {

	@Override
	public boolean isValid(LoginUser user, ConstraintValidatorContext context) {
		if (user == null) {
			return true;
		}
		
		if ( StringUtils.isBlank(user.getPlainTextPassword()) || StringUtils.isBlank(user.getConfirmedPlainTextPassword()) ) {
			return false;
		}

		return user.getPlainTextPassword().equals(user.getConfirmedPlainTextPassword());
	}

}