package com.eggdigital.android.validator;

import android.text.TextUtils;

import com.eggdigital.android.eggvalidator.EggValidator;
import com.eggdigital.android.eggvalidator.volidator.email.EmailOption;

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
 * Created by komkrit.ban on 11/14/2016 AD.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(TextUtils.class)
public class TestIsEmail {

	@Test
	public void testEmailCheck() {
		boolean isValidEmail;
		String email;
		System.out.println("<<========>> Start test Email <<========>>");

		email = "komkrit.ban@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);


		email = "komkrit.ban@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		email = "komkrit.ban@.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkritbanascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@ascendcorp.c";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@gmail$.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit!123@banascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		email = "jingjoeh@hotmail@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh=@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		System.out.println("<<========>> End test Email <<========>>\n\n");

	}

	@Test
	public void testEmailCompany() {

		boolean isValidEmail;
		String email;
		System.out.println("<<========>> Start test email only gmail.com <<========>>");


		email = "komkrit.ban@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);


		email = "komkrit.ban@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		email = "komkrit.ban@.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkritbanascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@ascendcorp.c";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@gmail$.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit!123@banascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@hotmail@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh=@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		System.out.println("<<========>> End test email only gmail.com <<========>>\n");


	}

	@Test
	public void testEmailExceptCompany() {

		boolean isValidEmail;
		String email;
		System.out.println("<<========>> Start test email except gmail.com <<========>>");


		email = "komkrit.ban@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);


		email = "komkrit.ban@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkritbanascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@ascendcorp.c";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@gmail$.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit!123@banascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		email = "jingjoeh@hotmail@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh=@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, true, EmailOption.GMAIL);
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		System.out.println("<<========>> End test email except gmail.com <<========>>\n");

	}

	@Test
	public void testEmailCompanyII() {

		boolean isValidEmail;
		String email;
		System.out.println("<<========>> Start test email hotmail.com and  ascendcorp.com <<========>>");


		email = "komkrit.ban@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);


		email = "komkrit.ban@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkritbanascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@ascendcorp.c";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "@ascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit.ban@gmail$.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "komkrit!123@banascendcorp.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, true);

		email = "jingjoeh@hotmail@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh=@hotmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		email = "jingjoeh@gmail.com";
		isValidEmail = EggValidator.isValidEmail(email, EmailOption.HOTMAIL, "ascendcorp.com");
		System.out.println("Result == " + isValidEmail + " (" + email + ") ");
		Assert.assertEquals(isValidEmail, false);

		System.out.println("<<========>> End  test email hotmail.com and  ascendcorp.com <<========>>\n");


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
