package com.regexp.ex2;

import java.util.ArrayList;
import java.util.List;

public class TutorialEx1 {

	public static void main(String[] args) {
		
		TutorialEx1 ex1 = new TutorialEx1();
		ex1.processRegX2();
		//ex1.processRegX3();

	}
	
	/**
	 * 	
	 * https://regex101.com/
	 * http://www.regexe.com/
	 * http://www.regexr.com/
	 * 
	   1) ---------------Character Classes
	    \d	Any digit, short for [0-9]
		\D	A non-digit, short for [^0-9]
		\s	A whitespace character, short for [ \t\n\x0b\r\f]
		\S	A non-whitespace character, short for [^\s]
		\w	A word character, short for [a-zA-Z_0-9]
		\W	A non-word character [^\w]
		\S+	Several non-whitespace characters
		\b	Matches a word boundary where a word character is [a-zA-Z0-9_].
	
	  	2) ---------------All Quantifiers as below
		Repetitions
		* - Repeat any number of times
		+ - Repeat one or more times
		? - Repeat zero or one time
		{n} - Repeat n times
		{n,m} - Repeat at least n, but no more than m times
		{n,} - Repeat at least n times
				
		3) ---------------Meta-characters
		\   	Escape the next meta-character (it becomes a normal/literal character)
		^   	Match the beginning of the line
		.   	Match any character (except newline)
		$   	Match the end of the line (or before newline at the end)
		|   	Alternation (‘or’ statement)
		()  	Grouping
		[]  	Custom character class
		
		
		4) -----------Escaped characters
		A problem occurs if you actually want to match one of the special characters, like "^" or "$". 
		Use the backslash to remove the special meaning. 
		Thus, "\^", "\.", and "\\", match the literal characters "^", ".", and "\", respectively.
		
	 */
	
	/**
	 *  ------------- Examples --------------
	 	a) \b\w{5,6}\b Find all five and six letter words
		b) \b\d{3}\s\d{3}-\d{4} Find ten digit phone numbers
		c) \d{3}-\d{2}-\d{4} Social security number
		d) ^\w* The first word in the line or in the text
	 */
	
	/**
	 * ---------- Grouping --------------
	  Parentheses may be used to delimit a subexpression to allow repetition or other special treatment. 
	  For example:	(\d{1,3}\.){3}\d{1,3} A simple IP address finder
	  The first part of the expression searches for a one to three digit number followed by a literal period "\.". 
	  This is enclosed in parentheses and repeated three times using the "{3}" quantifier, followed by the same expression without the trailing period.
	 */
	
	
	
	private void processRegX1(){
		
		//
        // Define regex that will search characters 't' or 'T'
        //
        String regex_1 = "[t|T]";
		
		String myString1 = "This is yogi's beautiful , world";
		System.out.println("Start processRegX1");
		
		/**
		 * // Removes whitespace between a word character and . or ,
		 */
		String pattern = "(\\w)(\\s+)([\\.,])";
		System.out.println(myString1.replaceAll(pattern, "$1$3"));
		
		// replace all whitespace with tabs
	    System.out.println(myString1.replaceAll("\\s+", "\t"));
		
		System.out.println("End processRegX1");
		
	}
	
	private void processRegX2() {
		List<String> input = new ArrayList<String>();
		input.add("Elapsed Time=740ms");
		input.add("Elapsed Time=9876740ms");
		input.add("Elapsed Time=9740ms");
		input.add("Elapsed Time=1ms");
		input.add("Elapsed Time=000001ms");
		input.add("Elapsed Time=0031ms");
		input.add("Elapsed Time=00355551ms");
		input.add("Elapsed Time=0000ms");
		input.add("Elapsed Time=1000ms");
		input.add("Elapsed Time=1000+ms");
		input.add("Elapsed Time=10000ms");
		input.add("Elapsed Time=2000ms");
		input.add("Elapsed Time=0250ms");
		input.add("Elapsed Time=1500ms");
		input.add("Elapsed Time=001250ms");
		input.add("Elapsed Time=000150ms");

		System.out.println("-------Yogi Example---------------------");
		//Find all the request taking time more than 1 sec
		for (String time : input) {
			//if (time.matches("(\\d{4,}$|^[1-9]\\d{2}$|^2[5-9]\\d)(ms)*")) {
			if (time.matches("Elapsed Time=0*[1-9]\\d{3,}ms")) {
				/**
				 * 0* means - any number of leading zeros greter than zero
				 * [1-9] - means next char can be anything between 1-9
				 * \\d{3,} -  \d means 0-9 and "{3,}" following the "\d" means "repeat the preceding character three times or more
				 */
				System.out.println("Time greater than 1 sec= " + time);
			}
		}
		
		System.out.println("--------Mark Ex1--------------------");
		for (String time : input) {
			if (time.matches("Elapsed Time=1[0-9][0-9][0-9]\\+ms")) {
				System.out.println("Time greater than 1 sec= " + time);
			}	
		}
		
		System.out.println("--------Mark Ex2--------------------");
		for (String time : input) {
			if (time.matches("Elapsed Time=1[0-9][0-9][0-9][0-9’]*ms")) {
				System.out.println("Time greater than 1 sec= " + time);
			}
		}
		
		System.out.println("--------Mark Ex3--------------------");
		for (String time : input) {
			if (time.matches("Elapsed Time=1[0-9]\\{3,\\}ms")) {
				System.out.println("Time greater than 1 sec= " + time);
			}
		}
	}
	
	private void processRegX3() {

		//
		// Define regex that will search characters 't' or 'T'
		//
		String regex_1 = "[t|T]";

		String myString1 = "This is yogi beautiful , world";
		System.out.println("Start processRegX1");

		System.out.println(myString1.matches(regex_1));

	}
	
	private void validatePhoneNumber(){
		/**
		 * Determining the Validity of Phone Numbers

			Suppose your web page collects a customer's seven-digit phone number and you want to verify that the phone number is in the correct format, 
			"xxx-xxxx", where each "x" is a digit. The following expression will search through text looking for such a string:
			
			A. \b\d\d\d-\d\d\d\d Find seven-digit phone number
			Each "\d" means "match any single digit". The "-" has no special meaning and is interpreted literally, matching a hyphen. 
			To avoid the annoying repetition, we can use a shorthand notation that means the same thing:
			
			B. \b\d{3}-\d{4} Find seven-digit phone number a better way
			The "{3}" following the "\d" means "repeat the preceding character three times".
		 */
	}
	
	private void validateIPAddress(){
		/**
		 * (\d{1,3}\.){3}\d{1,3} A simple IP address finder
		 * The first part of the expression searches for a one to three digit number followed by a literal period "\.".
		 *  This is enclosed in parentheses and repeated three times using the "{3}" quantifier, 
		 *  followed by the same expression without the trailing period.
		 */

		
	}
	
	
	private void countWords(){
		String regex = "\\bybr\\w*\\b";
		String testStr = "ybr is quoted ybr two times";
		
		if (testStr.matches(regex)) {
			System.out.println("success");
		}
	}




}
