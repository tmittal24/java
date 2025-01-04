package com.date.ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange {

	public static void main(String[] args) {
		//testDateRange();
		
		example1();
	}

	private static void testDateRange() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		{
			Date birthdate = new Date();
			try {
				birthdate = formatter.parse("1959-01-01");
				System.out.println(birthdate);
			} catch (ParseException e) {
				// error while parsing the date
			}
			// Calculating date
			long age = new Date().getTime() - birthdate.getTime();
			System.out.println(age);
			Date d = new Date(age);
			System.out.println(d);
			int yearsBetween = (int) (age / 3.156e+10);
			System.out.println(yearsBetween);
		}
	}

	public static void example1() {
		Date d = new Date(1405058400000l);

		System.out.println(d);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date birthdate = new Date();

		try		{
			birthdate = formatter.parse("2014-07-11");
		} catch (ParseException e) {
			// error while parsing the date
		}

		System.out.println(birthdate);
		System.out.println(birthdate.getTime());

	}

}
