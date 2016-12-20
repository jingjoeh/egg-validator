package com.eggdigital.android.eggvalidator.volidator.password;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatFlagsException;


/**
 * Created by komkrit.ban on 11/17/2016 AD.
 */

public class PasswordOption {

	public static final int BASIC = 11;

	public static final int REQUIRE_LETTER_N_NUMBER = 13;
	public static final int REQUIRE_LETTER_N_SPECIAL = 14;
	public static final int REQUIRE_LETTER_N_UPPER = 15;
	public static final int REQUIRE_LETTER_N_SPECIAL_N_UPPER = 16;
	public static final int REQUIRE_LETTER_N_NUMBER_N_SPECIAL = 17;
	public static final int REQUIRE_LETTER_N_NUMBER_N_SPECIAL_N_UPPER = 18;
	public static final int REQUIRE_NUMBER_N_SPECIAL = 19;
	public static final int REQUIRE_NUMBER_N_UPPER = 20;


	public static final int ONLY_LETTER = 41;
	public static final int ONLY_NUMBER = 42;
	public static final int ONLY_LETTER_N_NUMBER = 43;

	public static final Integer typeArr[] = {11, 13, 14, 15, 16, 41, 42, 43};

	private ArrayList<Character> excepts;
	private int minLength;
	private int maxLength;
	private int type;

	public PasswordOption(Builder builder) {
		this.excepts = builder.excepts;
		this.minLength = builder.minLength;
		this.maxLength = builder.maxLength;
		this.type = builder.type;
	}


	public ArrayList<Character> getExcepts() {
		return excepts;
	}

	public int getMinLength() {
		return minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public int getType() {
		return type;
	}

	public static class Builder {
		private ArrayList<Character> excepts;
		private int type = BASIC;
		private int minLength = 8;
		private int maxLength = 24;

		public Builder except(Character... except) {
			if (excepts == null)
				excepts = new ArrayList<>();
			for (Character character : except) {
				if (!excepts.contains(character))
					excepts.add(character);
			}
			return this;
		}

		public Builder minLength(int minLength) {

			if (minLength <= 0) {
				throw new IllegalStateException("min length must more than 0");
			}

			if (minLength > 0 && minLength > maxLength) {
				throw new IllegalStateException("min length must less than max length");
			}
			this.minLength = minLength;
			return this;

		}


		public Builder maxLength(int maxLength) {

			if (maxLength <= 0) {
				throw new IllegalStateException("max length must more than 0");
			}

			if (maxLength > 0 && minLength > maxLength) {
				throw new IllegalStateException("max length must more than min length");
			}
			this.maxLength = maxLength;

			return this;

		}

		public Builder type(int type) {
			if (!Arrays.asList(typeArr).contains(type))
				throw new IllegalFormatFlagsException("Type not found");
			this.type = type;
			return this;
		}


		public PasswordOption build() {
			return new PasswordOption(this);
		}
	}


}
