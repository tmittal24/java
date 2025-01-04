package com.threads.ex7.v1;

import java.sql.Date;

public class Test {
	public static void main(String[] args) {
		ThreadLocalExample ex = new ThreadLocalExample();
		String str = ex.formatIt(new Date(System.currentTimeMillis()));
		System.out.println(str);
	}

}
