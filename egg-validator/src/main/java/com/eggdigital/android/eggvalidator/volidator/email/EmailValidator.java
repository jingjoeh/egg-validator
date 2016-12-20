package com.eggdigital.android.eggvalidator.volidator.email;


import com.eggdigital.android.eggvalidator.BaseValidate;
import com.eggdigital.android.eggvalidator.interfaces.Validator;

import java.util.regex.Pattern;


/**
 * Created by komkrit.ban on 11/14/2016 AD.
 */

public class EmailValidator extends BaseValidate implements Validator<EmailOption, String> {

	private static final String EMAIL_REGEX =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String EMAIL_NAME_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@";

	@Override
	public boolean validate(EmailOption option, String email) {

		if (option == null)
			return isValid(email);

		return isValid(option, email);

	}

	@Override
	public boolean validate(String email) {
		return isValid(email);
	}


	/**
	 * @param email string input do you want to validate.
	 * @return boolean
	 */
	private boolean isValid(String email) {

		if (this.isEmpty(email))
			return false;

		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		return pattern.matcher(email).matches();

	}

	/**
	 * @param option EmailOption
	 * @param email  string input do you want to validate.
	 * @return boolean
	 */

	private boolean isValid(EmailOption option, String email) {

		if (!isValid(email))
			return false;

		String rex = EMAIL_NAME_PATTERN;
		if (option.getType() != null && option.getType().size() > 0) {
			rex += "(";
			for (int i = 0; i < option.getType().size(); i++) {
				if (i == 0)
					rex = rex + option.getType().get(i);
				else
					rex = rex + "|" + option.getType().get(i);
			}
			rex += ")";

//			rex = EMAIL_NAME_PATTERN + "(gmail.com|hotmail.com|yahoo.com)";

			Pattern pattern = Pattern.compile(rex);
			return option.isExcept() ? (isValid(email) && !pattern.matcher(email).matches()) : pattern.matcher(email).matches();

		} else {
			return isValid(email);
		}

	}


}
