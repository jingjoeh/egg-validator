package com.eggdigital.android.eggvalidator.volidator.basic;

/**
 * Created by komkrit.ban on 11/11/2016 AD.
 */

public class BasicValidator {


	public static boolean isEqualLength(String string, int length) {
		return string.length() == length;
	}

	public static boolean isMaxLength(String string, int maxLength) {
		return string.length() <= maxLength;
	}

	public static boolean isMinLength(String string, int minLength) {
		return string.length() >= minLength;
	}

	public static boolean validate(String string, BasicOptions options) {
		boolean validated = true;
		if (options.getEqualLength() > 0) {
			validated = isEqualLength(string, options.getEqualLength());
		}
		if (options.getMinLength() > 0 && validated) {
			validated = isMinLength(string, options.getMinLength());
		}

		if (options.getMaxLength() > 0) {
			validated = validated && isMaxLength(string, options.getMaxLength());
		}

		return validated;
	}

}
