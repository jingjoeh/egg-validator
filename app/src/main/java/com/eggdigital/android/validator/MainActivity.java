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

		boolean isEmail = EggValidator.isValidEmail("jj@yahoo.com", true, EmailOption.GMAIL, EmailOption.HOTMAIL);
		Log.e("jj@gmail.com", isEmail + " ");

//		EggValidator.wow("AAA", "BBB", "CCC", "DDD");


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
