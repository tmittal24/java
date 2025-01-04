package com.yogi.locale;

import java.util.Locale;

public class PrintLanguageFromLocale {
	public static void main(String[] args) {
		String lng = "en";
		Locale loc = new Locale(lng);
		String name = loc.getDisplayLanguage(loc); //English
		System.out.println(name);

		lng = "es";
		loc = new Locale(lng);
		printLanguage(loc);

		
		
		lng = "fr";
		loc = new Locale(lng);
		printLanguage(loc);
	}

	private static void printLanguage(Locale loc) {
		System.out.println("getISO3Language = " + loc.getISO3Language());
		System.out.println("getDisplayLanguage = " + loc.getDisplayLanguage());
		System.out.println("getDisplayName = " + loc.getDisplayName());
	}
}
