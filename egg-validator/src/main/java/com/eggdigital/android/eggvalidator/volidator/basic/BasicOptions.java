package com.eggdigital.android.eggvalidator.volidator.basic;

/**
 * Created by komkrit.ban on 11/10/2016 AD.
 */

public class BasicOptions {
	private int maxLength;
	private int minLength;
	private int equalLength;

	public int getMaxLength() {
		return maxLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public int getEqualLength() {
		return equalLength;
	}

	private BasicOptions(Builder builder) {
		this.maxLength = builder.maxLength;
		this.minLength = builder.minLength;
		this.equalLength = builder.equalLength;
	}

	public static class Builder {
		private int maxLength;
		private int minLength;
		private int equalLength;

		public Builder maxLength(int maxLength) {
			if (equalLength > 0) {
				throw new IllegalStateException("maxLength can not be use after call equalLength");
			}
			this.maxLength = maxLength;
			return this;
		}


		public Builder minLength(int minLength) {
			if (equalLength > 0) {
				throw new IllegalStateException("minLength can not be use after call equalLength");
			}
			this.minLength = minLength;
			return this;
		}


		public Builder equalLength(int equalLength) {

			if (minLength > 0) {
				throw new IllegalStateException("equalLength can not be use after call minLength");
			}

			if (maxLength > 0) {
				throw new IllegalStateException("equalLength can not be use after call maxLength");
			}
			this.equalLength = equalLength;
			return this;
		}


		public BasicOptions build() {
			return new BasicOptions(this);
		}
	}
}
