package com.eggdigital.android.eggvalidator.volidator.phone;

import android.nfc.FormatException;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;

/**
 * Created by komkrit.ban on 11/15/2016 AD.
 */

public class PhoneOption {

	private ArrayList<Integer> secondDigits;
	private boolean isExcept = false;

	private PhoneOption(Builder builder) {
		this.isExcept = builder.isExcept;
		this.secondDigits = builder.secondDigits;
	}

	public ArrayList<Integer> getSecondDigits() {
		return secondDigits;
	}

	public boolean isExcept() {
		return isExcept;
	}

	public static class Builder {
		private ArrayList<Integer> secondDigits;
		private boolean isExcept = false;

		public Builder secondDigit(int secondDigit) {
			if (this.secondDigits == null)
				this.secondDigits = new ArrayList<>();

			if (isOneDigit(secondDigit))
				this.secondDigits.add(secondDigit);

			return this;
		}

		public Builder except(boolean isExcept) {
			this.isExcept = isExcept;
			return this;
		}

		public PhoneOption build() {
			return new PhoneOption(this);
		}


		private boolean isOneDigit(int input) {
			if (input > 9 || input < 0) {
				throw new IllegalArgumentException("Second digit must be only \'0-9\'");
			}
			return true;
		}
	}


}
