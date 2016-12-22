package com.eggdigital.android.validator;

import com.eggdigital.android.eggvalidator.EggValidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.eggdigital.android.eggvalidator.volidator.email.EmailOption;
import com.eggdigital.android.eggvalidator.volidator.password.PasswordOption;
import com.eggdigital.android.eggvalidator.volidator.password.PasswordValidator;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		boolean isEmail = EggValidator.isValidEmail("simple@gmail.com", EmailOption.GMAIL);
		Log.d("simple@gmail.com", isEmail + " ");
		boolean isEmail2 = EggValidator.isValidEmail("jj@yahoo.com", true, EmailOption.GMAIL, EmailOption.HOTMAIL);
		Log.d("jj@gmail.com", isEmail2 + " ");

		boolean phone1 = EggValidator.isValidPhone("0800560032", 8);
		boolean phone2 = EggValidator.isValidPhone("0600560032", 8);
		Log.d("0800560032", phone1 + " ");
		Log.d("0600560032", phone2 + " ");

		Log.d("Tahiid", EggValidator.isValidThaiId("1234567890124") + "");
		Log.d("Tahiid", EggValidator.isValidThaiId("1629900233665") + "");

		Log.d("Tahiid", EggValidator.isValidThaiId("1234567890121") + "");
		Log.d("Tahiid", EggValidator.isValidThaiId("1234567890122") + "");


		Log.d("Password 1234567890", EggValidator.isValidPassword("1234567890" + "") + "");
		Log.d("Password 1234567890", EggValidator.isValidPassword("หหหหหห") + "");
		Log.d("Password 1234567890", EggValidator.isValidPassword("123thisisthenewusernamela") + "");
		Log.d("Password 1234567890", EggValidator.isValidPassword("Nartra$123") + "");
	}
}
