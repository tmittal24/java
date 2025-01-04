package com.yogi.assertion;

public class AA {

	public static void assertBounds(int low, int high, int value) {
		assert (value > low ? (value < high) : false) : (value < high ? "too low" : "too high");
	}

	public static void main(String[] args) {
		assertBounds(100, 200, 150);
	}

}
