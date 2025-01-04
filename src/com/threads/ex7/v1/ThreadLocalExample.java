package com.threads.ex7.v1;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ThreadLocalExample {
	private static final ThreadLocal <SimpleDateFormat>formatter = new ThreadLocal <SimpleDateFormat>() {

		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public String formatIt(Date date) {
		return formatter.get().format(date);
	}

}
