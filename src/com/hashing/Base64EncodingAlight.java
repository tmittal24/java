package com.hashing;

import java.util.Base64;

public class Base64EncodingAlight {

	public static void main(String[] args) {
		//System.out.println("------------ Encoding ------------------ ");
		//processEncoding();
		
		System.out.println("------------ Decoding ------------------ ");
		processDeecoding();
	}
	
	public static void processEncoding() 
    { 
		//https://bitlb01-tomcat.hewitt.com/TomiWeb/Value/Options.do
		
       
        
		//QC & QA
		
		
		
		//PU
        String sample = "QG9oYlYlXnR6aWlKZ1VNNjp5S29fRXR1VUFsbFJDWV5lcUow";
  
        // print actual String 
        System.out.println("Sample String= " + sample); 
  
        // Encode into Base64 format 
        String BasicBase64format = Base64.getEncoder() 
                  .encodeToString(sample.getBytes()); 
  
        // print encoded String 
        System.out.println("Encoded String= " + BasicBase64format); 
    } 

	
	public static void processDeecoding() 
    { 
  
		// 1) DV and TU
        // String encoded = "JHhAbVFpJm9aJmc0OlN+b0xMJXhPejk="; 
        // String encoded = "$x@mQi&oZ&g4:S~oLL%xOz9";  
        
		// 2) QA & QC
		String encoded = "NkdxJHMlNSp2UDp+VW91ejlyeVBp";
        //6Gq$s%5*vP:~Uouz9ryPi
		
		
        // 3) PU
        // String encoded = "QG9oYlYlXnR6aWlKZ1VNNjp5S29fRXR1VUFsbFJDWV5lcUow";
        // @ohbV%^tziiJgUM6:yKo_EtuUAllRCY^eqJ0
        
        
        // print encoded String 
        System.out.println("Encoded String= " + encoded); 
  
        // decode into String from encoded format 
        byte[] actualByte = Base64.getDecoder().decode(encoded); 
  
        String actualString = new String(actualByte); 
  
        // print actual String 
        System.out.println("actual String = " + actualString); 
    } 
}
