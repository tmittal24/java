package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchNumpattern {

	

	public static void main(String[] args) {
		
		testRegExpDate();
	}
	private static void testRegExpDate(){

		//String REGEX = "^([0-3][1-9])(\\.)?([0-1][1-9])(\\.)?(\\d{4})$"; //e.g 14.12.1975 
		String REGEX = "^([0-3][1-9])(\\.)?([0-1][1-9])(\\.)?(\\d{4})$"; //e.g 14.12.1975 
		//String REGEX = "^([0-3][1-9])(.)?([0-1][1-9])(.)?(\\d{4})$"; //141275
		//String REGEX = "^([0-9]{4})(\\.)?(1[0-2]|0[1-9])(\\.)?(3[0-1]|0[1-9]|[1-2][0-9])$"; //2008-08-30 or 20080830 i.e YYYY.MM.DD or YYYYMMDD
		
		//String REGEX = "^(3[0-1]|0[1-9]|[1-2][0-9])(\\.)?(1[0-2]|0[1-9])(\\.)?([0-9]{4})$";  //14-03-2008  or 14032008   i.e DD.MM.YYYY or DDMMYYYY
		
		String INPUT = "12.12.1234";
		
		
		Pattern p = Pattern.compile(REGEX);

		
		Matcher matcher =  p.matcher(INPUT);
		boolean found = false;
        while (matcher.find()) {            
            found = true;
            System.out.println("match found");
        }
        if(!found){
        	System.out.println("Sorry match not found");
        }	
	}


	/*
	 * Test testRegExp2
	 */	
	private static void testRegExp2() {

		String REGEX = "(^[0-9]+$)";
		String INPUT = "0";
		
		Pattern p = Pattern.compile(REGEX);

		
		Matcher matcher =  p.matcher(INPUT);
		boolean found = false;
        while (matcher.find()) {            
            found = true;
            System.out.println("match found");
        }
        if(!found){
        	System.out.println("Sorry match not found");
        }	
	}
	
	
	/*
	 * Test testRegExp1
	 */
	private static void testRegExp1() {
		//match the string 424/55555554
		//private static final String REGEX = "(^\\d{3}/\\d{7}$)|(^\\d{7}$)";
		String REGEX = "(^[0-9]{3}/[0-9]{7}$)|(^[0-9]{7}$)";
		//private static final String REGEX = "\\d{3}/\\d{7}|\\d{7}";
	    //private static final String INPUT = "444/5555555";
		
		
		String INPUT = "42a/5555554";

		Pattern p = Pattern.compile(REGEX);
//		String[] items = p.split(INPUT);
//		for (String s : items) {
//			System.out.println(s);
//		}
		
		Matcher matcher =  p.matcher(INPUT);
		boolean found = false;
        while (matcher.find()) {            
            found = true;
            System.out.println("match found");
        }
        if(!found){
        	System.out.println("Sorry match not found");
        }
	}

}
