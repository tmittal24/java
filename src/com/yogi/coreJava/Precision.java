package com.yogi.coreJava;

import java.util.Locale;

public class Precision {
	public static void main(String[] args) {
		// precisionTest();
		lowerCaseTest();
	}

	private static void puzzle() {
		System.out.println("Hi Guys!");
		/** Character myChar = new Character(' '); */
		// this line will not work with single line comment
	}

	private static void precisionTest() {
		double d = 0.0d;
		for (int i = 0; i < 10; i++) {
			d = d + 0.1d;
		}
		System.out.println(d);
	}

	public void javapapers() {
		System.out.println("java");
		return;
		// System.out.println("papers");
	}

	public static void lowerCaseTest() {
		Locale.setDefault(new Locale("lt")); // setting Lithuanian as locale
		String str = "\u00cc";
		System.out.println("Before case conversion is " + str + " and length is " + str.length());// Ì
		String lowerCaseStr = str.toLowerCase();
		System.out.println("Lower case is " + lowerCaseStr + " and length is " + lowerCaseStr.length());// i?`
	}
}
