package com.eggdigital.android.validator;

import android.text.TextUtils;

import com.eggdigital.android.eggvalidator.EggValidator;

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
public class TestPhoneNumber {


	@Test
	public void testPhoneNumber() {

		System.out.println("<======== Start test phone number. ==========>");
		String phoneNumber;
		boolean isPhoneNumber;

		phoneNumber = "0805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "080-5137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080513773";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "+66805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0914053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "091-405-3344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0014053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0251689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0351689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0451689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0551689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0651689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0751689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0851689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0951689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "1051689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1125168987";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "2345678900";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "08066319800";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "phonenum";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "082456";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		System.out.println("<======== End test phone number. ==========>\n");
	}


	@Test
	public void testPhoneNumberWithSecondDigit() {

		System.out.println("<======== Start test phone number with second digit is only 8. ==========>");
		String phoneNumber;
		boolean isPhoneNumber;

		phoneNumber = "0805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "080-5137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080513773";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "+66805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0914053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "091-405-3344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0014053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0251689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0351689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0451689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0551689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0651689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0751689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0851689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0951689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1051689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1125168987";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "2345678900";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "08066319800";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "phonenum";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "082456";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		System.out.println("<======== End test phone number with second digit is only 8\n");
	}

	@Test
	public void testPhoneNumberExcept() {

		System.out.println("<======== Start test phone number with second digit is except 8. ==========>");
		String phoneNumber;
		boolean isPhoneNumber;

		phoneNumber = "0805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080-5137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080513773";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "+66805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0914053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "091-405-3344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0014053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0251689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0351689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0451689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0551689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0651689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0751689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0851689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0951689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "1051689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1125168987";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "2345678900";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "08066319800";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "phonenum";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "082456";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 8);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		System.out.println("<======== End test phone number with second digit is except 8\n");
	}

	@Test
	public void testPhoneNumberWithSecondDigitII() {

		System.out.println("<======== Start test phone number with second digit is only 2 and 9. ==========>");
		String phoneNumber;
		boolean isPhoneNumber;

		phoneNumber = "0805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080-5137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080513773";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "+66805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0914053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "091-405-3344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0014053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0251689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0351689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0451689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0551689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0651689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0751689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0851689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0951689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "1051689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1125168987";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "2345678900";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "08066319800";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "phonenum";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "082456";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		System.out.println("<======== End test phone number with second digit is only 9 and 2\n");
	}


	@Test
	public void testPhoneNumberExceptSecondDigitII() {

		System.out.println("<======== Start test phone number with second digit is except 2 and 9. ==========>");
		String phoneNumber;
		boolean isPhoneNumber;

		phoneNumber = "0805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "080-5137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "080513773";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "+66805137732";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0914053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "091-405-3344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "0014053344";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0251689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);


		phoneNumber = "0351689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0451689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0551689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0651689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);


		phoneNumber = "0751689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0851689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "0951689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, true);

		phoneNumber = "1051689874";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "1125168987";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "2345678900";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "08066319800";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "phonenum";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "6658903267";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		phoneNumber = "082456";
		isPhoneNumber = EggValidator.isValidPhone(phoneNumber, true, 9, 2);
		System.out.println("Result == " + isPhoneNumber + " (" + phoneNumber + ") ");
		Assert.assertEquals(isPhoneNumber, false);

		System.out.println("<======== End test phone number with second digit is except 9 and 2\n");
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
