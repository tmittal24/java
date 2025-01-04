package com.yogi.strings;

public class StringBufferRef {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBufferRef a = new StringBufferRef();
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
