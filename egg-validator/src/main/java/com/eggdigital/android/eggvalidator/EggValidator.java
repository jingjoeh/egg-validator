package com.eggdigital.android.eggvalidator;

import com.eggdigital.android.eggvalidator.volidator.ThaiIdValidator;
import com.eggdigital.android.eggvalidator.volidator.email.EmailValidator;
import com.eggdigital.android.eggvalidator.volidator.email.EmailOption;
import com.eggdigital.android.eggvalidator.volidator.password.PasswordOption;
import com.eggdigital.android.eggvalidator.volidator.password.PasswordValidator;
import com.eggdigital.android.eggvalidator.volidator.phone.PhoneOption;
import com.eggdigital.android.eggvalidator.volidator.phone.PhoneValidator;

/**
 * Created by komkrit.ban on 11/14/2016 AD.
 */

public class EggValidator {

	public static boolean isValidEmail(String email) {

		EmailValidator emailValidator = new EmailValidator();
		return emailValidator.validate(email);
	}

	public static boolean isValidEmail(String email, String... emailCompany) {
		EmailOption.Builder builder = new EmailOption.Builder();

		for (String type : emailCompany) {
			builder.addType(type);
		}

		EmailValidator emailValidator = new EmailValidator();
		return emailValidator.validate(builder.build(), email);
	}

	public static boolean isValidEmail(String email, boolean isExcept, String... emailCompany) {

		EmailOption.Builder builder = new EmailOption.Builder();
		for (String type : emailCompany) {
			builder.addType(type);
		}
		builder.isExcept(isExcept);

		EmailValidator emailValidator = new EmailValidator();
		return emailValidator.validate(builder.build(), email);
	}


	public static boolean isValidPhone(String phoneNumber) {
		return new PhoneValidator().validate(phoneNumber);
	}

	public static boolean isValidPhone(String phoneNumber, int... secondDigit) {

		PhoneOption.Builder builder = new PhoneOption.Builder();
		for (int digit : secondDigit) {
			builder.secondDigit(digit);
		}
		return new PhoneValidator().validate(builder.build(), phoneNumber);
	}


	public static boolean isValidPhone(String phoneNumber, boolean isExcept, int... secondDigit) {

		PhoneOption.Builder builder = new PhoneOption.Builder();
		builder.except(isExcept);
		for (int digit : secondDigit) {
			builder.secondDigit(digit);
		}
		return new PhoneValidator().validate(builder.build(), phoneNumber);
	}

	public static boolean isValidThaiId(String thaiId) {
		return new ThaiIdValidator().validate(null, thaiId);
	}


	public static boolean isValidPassword(String password) {
		return new PasswordValidator().isValid(password);
	}


	public static boolean isValidPassword(String password, int minLength, int maxLength) {
		PasswordOption option = new PasswordOption.Builder().minLength(minLength).maxLength(maxLength).build();
		return new PasswordValidator().isValid(option, password);
	}

	public static boolean isValidPassword(String password, int minLength, int maxLength, Character... except) {
		PasswordOption option = new PasswordOption.Builder().minLength(minLength).maxLength(maxLength).except(except).build();
		return new PasswordValidator().isValid(option, password);
	}

	public static boolean isValidPassword(int passwordOptionType, String password) {
		PasswordOption option = new PasswordOption.Builder().type(passwordOptionType).build();
		return new PasswordValidator().isValid(option, password);
	}

	public static boolean isValidPassword(int passwordOptionType, String password, int minLength, int maxLength) {
		PasswordOption option = new PasswordOption.Builder().type(passwordOptionType).minLength(minLength).maxLength(maxLength).build();
		return new PasswordValidator().isValid(option, password);
	}

	public static boolean isValidPassword(int passwordOptionType, String password, Character... exceptCharacters) {
		PasswordOption option = new PasswordOption.Builder().type(passwordOptionType).except(exceptCharacters).build();
		return new PasswordValidator().isValid(option, password);
	}

	public static boolean isValidPassword(int passwordOptionType, String password, int minLength, int maxLength, Character... exceptChactors) {
		PasswordOption option = new PasswordOption.Builder().type(passwordOptionType).minLength(minLength).maxLength(maxLength).except(exceptChactors).build();
		return new PasswordValidator().isValid(option, password);
	}


}
