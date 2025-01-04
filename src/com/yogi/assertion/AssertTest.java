package com.yogi.assertion;

public class AssertTest {
	public void m1(int value) {
		
		System.out.print("foo.m1( " + value + " ): ");
		assert 0 <= value : "value can't be greater than 0";
		System.out.println("OK");
	}

	public static void main(String[] args) {
		AssertTest foo = new AssertTest();
		
		foo.m1(1);
		
		foo.m1(-1);
		
		
		foo.m1(2);
	}
}
