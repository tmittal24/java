package com.regexp;

import java.util.regex.*;

public class IntegerGha1 {

	public static void main(String[] args) {
		IntegerGha1 obj = new IntegerGha1();
		obj.asObject("1234343v4");

	}

	public Object convertInteger(String value) {

		if (value == null || "".equals(value)) {
			return null;
		} else {
			checkInteger(value);
			return Integer.valueOf(value);

		}
	}

	public void checkInteger(String value) {

		String NON_NEGATIVE_INTEGER_FIELD = "[\\d]+";
		String INTEGER_FIELD = "(-)?" + NON_NEGATIVE_INTEGER_FIELD;
		
		if (!Pattern.matches( INTEGER_FIELD, value )) {
			//throw new ZCheckDataException("Die Integer aus dem Attribut" " invalid integer value");
			//throw new Exception();
			System.out.println("invalid integer");
		}
	}

	public Object asObject(String value) {
		return convertInteger(value);
	}

}
