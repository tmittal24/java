package com.yogi.helper;

import java.math.BigDecimal;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Date;

public class Helper {
	public static void main(String[] args) {

	}

	/**
	 * Mask intended chars from input
	 * @param input
	 * @return
	 */
	public static String escapeDB2Chars(String input) {

		if (input == null) {
			return null;
		}

		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator inputIterator = new StringCharacterIterator(
				input);
		char current = inputIterator.current();

		while (current != CharacterIterator.DONE) {

			switch (current) {
			case '&':
			case '%':
			case '\'':
			case '\\':
			case '*':
				// eat it...
				break;

			default:
				result.append(current);
				break;
			}

			current = inputIterator.next();
		}

		String r = result.toString();
		return (r.length() > 0) ? r : null;
	}

	
	  public static boolean areEqual( String a, String b ) {
	        if ( a == null && b == null ) {
	            return true;
	        } else if ( a == null || b == null ) {
	            return false;
	        } else {
	            return a.equals( b );
	        }
	    }


	    public static boolean notEqual( String a, String b ) {
	        return !areEqual( a, b );
	    }


	    public static boolean areEqual( Date a, Date b ) {
	        if ( a == null && b == null ) {
	            return true;
	        } else if ( a == null || b == null ) {
	            return false;
	        } else {
	            return a.equals( b );
	        }
	    }


	    public static boolean notEqual( Date a, Date b ) {
	        return !areEqual( a, b );
	    }



	    public static boolean areEqual( BigDecimal a, BigDecimal b ) {
	        if ( a == null && b == null ) {
	            return true;
	        } else if ( a == null || b == null ) {
	            return false;
	        } else {
	            return a.equals( b );
	        }
	    }
}
