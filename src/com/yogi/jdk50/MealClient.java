package com.yogi.jdk50;

public class MealClient {
	public static void main(String[] args) {
		for (Meal meal : Meal.values())
			System.out.println(meal 
					+ " served at " + meal.getHour() 
					+ ":" 
					+ meal.getMins() 
					+ ", has the ordinal value " 
					+ meal.ordinal());
	}
}