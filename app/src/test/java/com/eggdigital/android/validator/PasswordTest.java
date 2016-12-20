package com.eggdigital.android.validator;

import android.text.TextUtils;

import com.eggdigital.android.eggvalidator.EggValidator;
import com.eggdigital.android.eggvalidator.volidator.password.PasswordOption;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;

/**
 * Created by komkrit.ban on 11/22/2016 AD.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(TextUtils.class)
public class PasswordTest {

	@Test
	public void testPassword() {

		System.out.println("<<=========== Start test password. ==========>");

		String password;
		boolean isPassword;

		password = "1234567890";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "123456789_";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!123456789,;[]0";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!123456789,AB";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!1234";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789กดกด";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1,AB+/2345";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "password";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "12WSXC";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "abcd efghijk";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1234567890qazwsxedcrfvtgbyhnuj";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!@#$%^&*()";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!@#$%^&*()ง";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "12345678";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "welcome";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1qaz2wsx";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "qwertyuiop";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "passw0rd";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "starwars";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "princess";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3r";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3s";
		isPassword = EggValidator.isValidPassword(password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		System.out.println("<<============= End test password. =============>\n");

	}

	@Test
	public void testPasswordLength() {
		System.out.println("<<============= Start test password with length 4 - 8. =============>");

		String password;
		boolean isPassword;

		password = "1234567890";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "123456789_";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!123456789,;[]0";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789,AB";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1234";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!123456789กดกด";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1,AB+/2345";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "password";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "12WSXC";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "abcd efghijk";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1234567890qazwsxedcrfvtgbyhnuj";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!@#$%^&*()";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!@#$%^&*()ง";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "12345678";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "welcome";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "1qaz2wsx";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "qwertyuiop";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "passw0rd";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "starwars";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "princess";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3r";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "facebook-e3s";
		isPassword = EggValidator.isValidPassword(password, 4, 10);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		System.out.println("<============= End test password with length 4 - 8. =============>");
	}


	@Test
	public void testPasswordLengthAndExcept() {
		System.out.println("<<============= Start test password with length 6 - 24 and except \',\' =============>");

		String password;
		boolean isPassword;

		password = "1234567890";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "123456789_";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!123456789,;[]0";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789,AB";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1234";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789กดกด";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1,AB+/2345";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "password";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "12WSXC";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "abcd efghijk";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1234567890qazwsxedcrfvtgbyhnuj";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!@#$%^&*()";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!@#$%^&*()ง";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "12345678";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "welcome";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "1qaz2wsx";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "qwertyuiop";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "passw0rd";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "starwars";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "princess";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3r";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3s";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook,e3r";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "facebook,e3s";
		isPassword = EggValidator.isValidPassword(password, 6, 24, ',');
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		System.out.println("<============= End test password with length 4 - 8 and except ',' =============>");
	}


	@Test
	public void testPasswordLettNNum() {
		System.out.println("<<============= Start test password with REQUIRE_LETTER_N_NUMBER type \',\' =============>");

		String password;
		boolean isPassword;

		password = "1234567890";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "123456789_";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789,;[]0";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789,AB";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "!1234";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!123456789กดกด";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!1,AB+/2345";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "password";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "12WSXC";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "abcd efghijk";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1234567890qazwsxedcrfvtgbyhnuj";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!@#$%^&*()";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "!@#$%^&*()ง";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "12345678";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "welcome";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "1qaz2wsx";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "qwertyuiop";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "passw0rd";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "starwars";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "princess";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "baseball";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "facebook";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, false);

		password = "facebook-e3r";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook-e3s";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook,e3r";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		password = "facebook,e3s";
		isPassword = EggValidator.isValidPassword(PasswordOption.REQUIRE_LETTER_N_NUMBER, password);
		System.out.println("Result == " + isPassword + " (" + password + ") ");
		Assert.assertEquals(isPassword, true);

		System.out.println("<============= End test password with length 4 - 8 and except ',' =============>");
	}

	@Before
	public void setup() {
		PowerMockito.mockStatic(TextUtils.class);
		PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				CharSequence a = (CharSequence) invocation.getArguments()[0];
				return !(a != null && a.length() > 0);
			}
		});
	}
}
