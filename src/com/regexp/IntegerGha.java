package com.regexp;

import java.util.regex.Pattern;

public class IntegerGha {
	public static void main(String[] args) {
		IntegerGha intGha = new IntegerGha();
		
		try {
			Object temp = intGha.asObject("-1");
			System.out.println(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	  /**
     * @param integer
     * @return
     */
    public String convertInteger( String value ) {

        if (value==null || "".equals( value )){
            return null;
        } else{
            boolean flag = matchInteger(value);
            if(flag==false){
                return null;
            } else{
                return value;
            }
        } 
    }

    public boolean matchInteger( String value ) {

        String NON_NEGATIVE_INTEGER_FIELD = "[\\d]+";
        String INTEGER_FIELD = "(-)?" + NON_NEGATIVE_INTEGER_FIELD;

        boolean b = false;
        b = Pattern.matches( INTEGER_FIELD, value );
        return b;
    }
    
    public Object asObject( String value ) throws Exception {
        String returnVal =  convertInteger(value);
        if(returnVal==null){
            //TODO change the error to proper message
            throw new Exception( "Invalid integer" );
        }
        return Integer.valueOf( returnVal );
    
    }

}
