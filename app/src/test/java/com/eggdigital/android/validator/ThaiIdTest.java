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
public class ThaiIdTest {


	@Test
	public void testThId() {

		System.out.println("<======== Start test Thai Id. ==========>");
		String thaiId;
		boolean isThId;

		thaiId = "4820725100686";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, true);

		thaiId = "4820725100687";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "4820725100689";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);


		thaiId = "4820725100680";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "48207251006867";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);


		thaiId = "48207251006";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "aertfghwddfgg";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "4-8207-25100-68-6";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "8313662706124";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, true);


		thaiId = "0313662706124";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		thaiId = "9313662706124";
		isThId = EggValidator.isValidThaiId(thaiId);
		System.out.println("Result == " + isThId + " (" + thaiId + ") ");
		Assert.assertEquals(isThId, false);

		System.out.println("<======== End test Thai Id. ==========>");
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


