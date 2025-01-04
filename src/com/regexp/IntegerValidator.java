package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidator {
	
	private static final String NON_NEGATIVE_INTEGER_FIELD = "[\\d.]+";
	private static final String INTEGER_FIELD = "(-)?" + NON_NEGATIVE_INTEGER_FIELD;

	public static void main(String[] args) {
		match2("22");
		
		replace("");
	}

	public static boolean match(String value) {
		
		String regEx = INTEGER_FIELD;
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(value);
		boolean b = false;
		
		b= Pattern.matches(regEx, value);
		System.out.println("Pattern match=" + b);
		return b;
	}
	
	
	public static boolean match2( String value ) {

	        String NON_NEGATIVE_INTEGER_FIELD = "[\\d]+";
	        String INTEGER_FIELD = "(-)?" + NON_NEGATIVE_INTEGER_FIELD;

	        boolean b = false;

	        b = Pattern.matches( INTEGER_FIELD, value );
	        System.out.println("Pattern match2=" + b);
	        return b;
	    }
	
	public static void replace(String value) {
        /**
         * replace '.' char from the input
         */
        CharSequence inputStr = "12345.678.98.98 ";
        String patternStr = "[.]";
        String replacementStr = "";
        
        // Compile regular expression
        Pattern pattern = Pattern.compile(patternStr);
        
        // Replace all occurrences of pattern in input
        Matcher matcher = pattern.matcher(inputStr);
        String output = matcher.replaceAll(replacementStr);
        
        System.out.println("output=" +output);
    }


}
