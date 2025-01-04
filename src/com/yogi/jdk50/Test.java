package com.yogi.jdk50;

import java.util.Set;
import java.util.TreeSet;

public class Test implements Comparable {

	enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public enum SimpleMeal {
		BREAKFAST, LUNCH, DINNER
	}

	public static void main(String[] a) {
		int x = 9;
		// byte b= x;

		Integer i = 7;
		Integer K = new Integer(5);
		int j = i;
		byte b = 7;
		int ii = 7; // byte b = i;

		Set<Test> set = new TreeSet<Test>();
		set.add(new Test());
		set.add(new Test());
		set.add(new Test());
		System.out.println(set.size());
	}

	public double fourthRoot(double d) {
		double result = 0.0;
		if (d >= 0) {
			result = Math.sqrt(Math.sqrt(d));
		}
		return result;
	}

	public int compareTo(Object o) {
		return 1;
	}
}
