package com.yogi.strings;

public class StringRef1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringRef1 a = new StringRef1();
		a.test1(new String("shammi"));
	}

	
	public void test1(String s1){
		String a1 = s1;
		test2(s1);
		System.out.println(a1);
	}
	public void test2(String s2){
		s2 = "test";
	}
}
