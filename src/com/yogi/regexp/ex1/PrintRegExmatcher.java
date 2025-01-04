package com.yogi.regexp.ex1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintRegExmatcher {
	public static void main(String[] args) {
		 Pattern p1 = Pattern.compile("[A-Za-z][a-z]+");
	     
	     String line="Anshul";
	     
	   
	        Matcher m = p1.matcher(line);
	        while (m.find()) {
	           System.out.println(m.group(0));
	           int s1 = m.start(0);
	           int e1 = m.end(0);
	           System.out.println(line.substring(s1, e1));
	        }
	     }
	}


