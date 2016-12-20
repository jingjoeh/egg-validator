package com.eggdigital.android.eggvalidator.volidator;

import android.support.annotation.Nullable;
import com.eggdigital.android.eggvalidator.BaseValidate;
import com.eggdigital.android.eggvalidator.interfaces.Validator;

/**
 * Created by komkrit.ban on 11/16/2016 AD.
 */

public class ThaiIdValidator extends BaseValidate implements Validator<Nullable, String> {


	@Override
	public boolean validate(Nullable nullable, String input) {
		return isValid(input);
	}

	@Override
	public boolean validate(String input) {
		return isValid(input);
	}


	private boolean isValid(String thaiId) {
		if (isEmpty(thaiId)) return false;

		if (thaiId.length() != 13) return false;

		if (!isNumber(thaiId)) return false;

		if (String.valueOf(thaiId.charAt(0)).equals("0") || String.valueOf(thaiId.charAt(0)).equals("9"))
			return false;

		int sum = 0;
		int multiplier = 13;
		for (int i = 0; i < 12; i++) {
			sum += castToInt(thaiId.charAt(i)) * multiplier;
			multiplier--;
		}

		if ((11 - (sum % 11)) >= 10)
			return ((11 - (sum % 11)) % 10) == castToInt(thaiId.charAt(12));
		else return (11 - (sum % 11)) == castToInt(thaiId.charAt(12));

	}

	private boolean isNumber(String thaiId) {
		try {
			return Long.parseLong(thaiId) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private int castToInt(char input) {
		try {
			return Integer.parseInt(String.valueOf(input));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
