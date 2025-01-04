package com.yogi.strings;

public class StringBufferRef1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBufferRef1 a = new StringBufferRef1();
		StringBuffer x = new StringBuffer("shammi");
		a.test1(x);
	}

	
	public void test1(StringBuffer s1){
		StringBuffer a1 = s1;
		test2(s1);
		System.out.println(a1);
	}
	public void test2(StringBuffer s2){
		s2 = new StringBuffer("test");
	}
}
