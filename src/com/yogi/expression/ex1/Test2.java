package com.yogi.expression.ex1;
public class Test2 {
	public static void main(String[] args) {

		Boolean flag = new Boolean(null);

		Test2 test = new Test2();
		try {
			test.test1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {
		String a = this.getClass().getSimpleName();
		System.out.println(a);
	}

	public boolean test1() {
		Boolean flag = null;

		if (true)
			flag = null;

		return flag;

	}

	public void test(char x, int aa) {
	}

	public void test(char x, double aa) {
	}

	public void test(char x, float aa) {
	}

}
