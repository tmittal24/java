package com.regexp.ex3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpSVB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegExpSVB obj = new RegExpSVB();
		obj.test();
	}

	private void test(){
		//String REGEX = "(^[0-9]{3}/[0-9]{7}$)|(^[0-9]{7}$)"; //(999/9999999 or 9999999)
		
		
		String REGEX = "^([\\d]{1,3})$";
		boolean validFormat = matchPattern(REGEX,"1f");
		System.out.println(validFormat);
	}
	
	private boolean matchPattern(String REGEX,String input) {
		Pattern p = Pattern.compile(REGEX);
		Matcher matcher =  p.matcher(input);
		
		boolean validFormat = false;
		while (matcher.find()) {            
		    validFormat = true;
		}
		return validFormat;
	}
}
