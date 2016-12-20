package com.eggdigital.android.eggvalidator.volidator.phone;


import com.eggdigital.android.eggvalidator.BaseValidate;
import com.eggdigital.android.eggvalidator.interfaces.Validator;

import java.util.regex.Pattern;

/**
 * Created by komkrit.ban on 11/15/2016 AD.
 */

public class PhoneValidator extends BaseValidate implements Validator<PhoneOption, String> {

	private static final String PHONE_REGEX = "^[0][0-9]{9}$";

	@Override
	public boolean validate(PhoneOption option, String phoneNumber) {
		if (option != null) {
			return isValidPhoneNumber(option, phoneNumber);
		}

		return isValidPhoneNumber(phoneNumber);
	}

	@Override
	public boolean validate(String phoneNumber) {
		return isValidPhoneNumber(phoneNumber);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		if (!this.isEmpty(phoneNumber)) {
			Pattern pattern = Pattern.compile(PHONE_REGEX);
			return pattern.matcher(phoneNumber).matches();
		}
		return false;
	}

	private boolean isValidPhoneNumber(PhoneOption phoneOption, String phoneNumber) {

		if (!isValidPhoneNumber(phoneNumber))
			return false;

		if (phoneOption.getSecondDigits() != null && phoneOption.getSecondDigits().size() > 0) {
			String rex = "^[0][";
			if (phoneOption.isExcept()) {
				rex = "^[0][^";
			}

			for (int i = 0; i < phoneOption.getSecondDigits().size(); i++) {
				if (i == 0)
					rex = rex + phoneOption.getSecondDigits().get(i);
				else
					rex = rex + "|" + phoneOption.getSecondDigits().get(i);
			}

			rex += "][0-9]{8}$";
			Pattern pattern = Pattern.compile(rex);
			return pattern.matcher(phoneNumber).matches();
		} else {
			return isValidPhoneNumber(phoneNumber);
		}

	}
}
