package com.regexp;

import java.util.regex.Pattern;

public class LongGha {
	public static void main(String[] args) {
		LongGha obj = new LongGha();
		obj.asObject("12121.2");
	}

	public Object convertLong(String value) {

		if (value == null || "".equals(value)) {
			return null;
		} else {
			checkLong(value);
			return Integer.valueOf(value);

		}
	}

	public void checkLong(String value) {

		String NON_NEGATIVE_LONG_FIELD = "[\\d]+";
		String LONG_FIELD = "(-)?" + NON_NEGATIVE_LONG_FIELD;

		if (!Pattern.matches(LONG_FIELD, value)) {
			// throw new ZCheckDataException( "Die Long aus dem Attribut"
			// + " invalid long value" );
		}
	}

	public Object asObject(String value) {
		return convertLong(value);
	}
}
