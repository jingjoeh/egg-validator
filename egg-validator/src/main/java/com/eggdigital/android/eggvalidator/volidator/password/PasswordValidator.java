package com.eggdigital.android.eggvalidator.volidator.password;

import android.util.Log;

import com.eggdigital.android.eggvalidator.BaseValidate;
import com.eggdigital.android.eggvalidator.interfaces.Validator;

import java.util.regex.Pattern;

/**
 * Created by komkrit.ban on 11/17/2016 AD.
 */

public class PasswordValidator extends BaseValidate implements Validator<PasswordOption, String> {
	private static final String REQUIRE_LETTER = "(?=.*[A-Za-z])";
	private static final String REQUIRE_NUMBER = "(?=.*[0-9])";
	private static final String REQUIRE_SPECIAL = "(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~])";
	private static final String REQUIRE_UPPER = "(?=.*[A-Z])";


	private static final String EXCEPT_SPACE = "(?=\\S+$)";

	private static final String BASIC_REX = "[A-Za-z0-9!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]";
	private static final String NORMAL_REX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{1,}$";
	private static final String LETTER_ONLY_REX = "[A-Za-z]";
	private static final String NUMBER_ONLY_REX = "[0-9]";
	private static final String LETTER_N_NUMBER_ONLY = "[A-Za-z0-9]";


	@Override
	public boolean validate(PasswordOption option, String input) {

		if (option == null)
			return isValid(input);

		return isValid(option, input);
	}

	@Override
	public boolean validate(String input) {
		return isValid(input);
	}


	public boolean isValid(PasswordOption option, String input) {

		if (isEmpty(input)) return false;

		if (input.length() > option.getMaxLength() || input.length() < option.getMinLength())
			return false;

		if (option.getExcepts() != null && option.getExcepts().size() > 0) {

			for (Character exceptChar : option.getExcepts()) {
				if (input.contains(String.valueOf(exceptChar)))
					return false;
			}

		}

		String rex;
		switch (option.getType()) {
			case PasswordOption.BASIC:
				rex = BASIC_REX;
				break;
			case PasswordOption.REQUIRE_LETTER_N_NUMBER:
				rex = "^" + REQUIRE_LETTER + REQUIRE_NUMBER + EXCEPT_SPACE;
				break;
			case PasswordOption.REQUIRE_LETTER_N_SPECIAL:
				rex = "^" + REQUIRE_LETTER + REQUIRE_SPECIAL + EXCEPT_SPACE;
				break;

			case PasswordOption.REQUIRE_LETTER_N_UPPER:
				rex = "^" + REQUIRE_LETTER + REQUIRE_UPPER + EXCEPT_SPACE;
				break;

			case PasswordOption.REQUIRE_LETTER_N_SPECIAL_N_UPPER:
				rex = "^" + REQUIRE_LETTER + REQUIRE_SPECIAL + REQUIRE_UPPER + EXCEPT_SPACE;
				break;
			case PasswordOption.REQUIRE_LETTER_N_NUMBER_N_SPECIAL:
				rex = "^" + REQUIRE_LETTER + REQUIRE_NUMBER + REQUIRE_SPECIAL + EXCEPT_SPACE;
				break;
			case PasswordOption.REQUIRE_LETTER_N_NUMBER_N_SPECIAL_N_UPPER:
				rex = "^" + REQUIRE_LETTER + REQUIRE_NUMBER + REQUIRE_SPECIAL + REQUIRE_UPPER + EXCEPT_SPACE;
				break;
			case PasswordOption.REQUIRE_NUMBER_N_SPECIAL:
				rex = "^" + REQUIRE_NUMBER + REQUIRE_SPECIAL;
				break;
			case PasswordOption.REQUIRE_NUMBER_N_UPPER:
				rex = "^" + REQUIRE_NUMBER + REQUIRE_UPPER;
				break;
			case PasswordOption.ONLY_LETTER:
				rex = LETTER_ONLY_REX;
				break;
			case PasswordOption.ONLY_NUMBER:
				rex = NUMBER_ONLY_REX;
				break;
			case PasswordOption.ONLY_LETTER_N_NUMBER:
				rex = LETTER_N_NUMBER_ONLY;
				break;
			default:
				rex = BASIC_REX;
				break;
		}
		if (option.getType() != PasswordOption.BASIC)
			rex += BASIC_REX + "{" + option.getMinLength() + "," + option.getMaxLength() + "}$";
		else
			rex += "{" + option.getMinLength() + "," + option.getMaxLength() + "}$";
		Pattern pattern = Pattern.compile(rex);

		return pattern.matcher(input).matches();

	}

	public boolean isValid(String input) {
		if (isEmpty(input)) return false;

		String rex = BASIC_REX + "{" + 8 + "," + 24 + "}";
		Pattern pattern = Pattern.compile(rex);
		return pattern.matcher(input).matches();
	}
}
