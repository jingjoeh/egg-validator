package com.eggdigital.android.eggvalidator;

import android.text.TextUtils;

/**
 * Created by komkrit.ban on 11/14/2016 AD.
 */

public abstract class BaseValidate {
	/**
	 * Method to check string empty
	 *
	 * @param string string do you want to check it's empty or not
	 * @return boolean that string is empty or not
	 */
	protected boolean isEmpty(String string) {
		return TextUtils.isEmpty(string);
	}

}
