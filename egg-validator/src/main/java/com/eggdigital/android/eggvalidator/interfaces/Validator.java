package com.eggdigital.android.eggvalidator.interfaces;

/**
 * Created by komkrit.ban on 11/14/2016 AD.
 */

public interface Validator<O, I> {

	boolean validate(O option, I input);

	boolean validate(I input);
}
