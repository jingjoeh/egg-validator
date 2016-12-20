package com.eggdigital.android.eggvalidator.volidator.email;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.regex.Pattern;

/**
 * Created by komkrit.ban on 11/10/2016 AD.
 */

public class EmailOption {
	public static final String GMAIL = "gmail.com";
	public static final String HOTMAIL = "hotmail.com";
	public static final String OUTLOOK = "outlook.com";
	public static final String YAHOO = "yahoo.com";
	private static final String DOMAIN_REX = "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private ArrayList<String> type;
	private boolean isExcept = false;

	private EmailOption(EmailOption.Builder builder) {
		this.type = builder.strType;
		this.isExcept = builder.isExcept;
	}

	ArrayList<String> getType() {
		return type;
	}

	boolean isExcept() {
		return isExcept;
	}

	public static class Builder {
		private ArrayList<String> strType;
		private boolean isExcept = false;

		public Builder addType(String emailType) {
			if (strType == null) {
				strType = new ArrayList<>();
			}
			if (isDomainPattern(emailType))
				strType.add(emailType);
			else
				throw new IllegalArgumentException(emailType + "is not end of company domain.Please enter end of company domain name likes \"gmail.com,hotmail.com etc...\"");

			return this;
		}

		public Builder isExcept(boolean isExcept) {
			this.isExcept = isExcept;
			return this;
		}

		public EmailOption build() {
			return new EmailOption(this);
		}

		/**
		 * @param domain String do you want to to check,Is there is end of domain.
		 *               ex. google.com,hotmail.com..
		 * @return true or false of the input is end of domain.
		 */
		public boolean isDomainPattern(String domain) {

			if (TextUtils.isEmpty(domain)) return false;

			Pattern pattern = Pattern.compile(DOMAIN_REX);
			return pattern.matcher(domain).matches();
		}
	}


}
