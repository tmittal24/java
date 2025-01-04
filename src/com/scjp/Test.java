package com.scjp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Test {

	int a;
	int b = 0;
	static int c;

	public void m() {
		int d;
		int e = 0;
		// (1) INSERT CODE HERE.
		a++;
		b++;
		c++;
		// d++;
		e++;
	}

	public void execute() {
		LinkedList<Number> a = new LinkedList<Number>();
		List<Number> l = new LinkedList<Number>();

		Collection<?> c = new ArrayList<String>();
		// c.add(new String());

	}

	public static void main(String[] args) {
		Test test = new Test();
		test.m();
	}

}
