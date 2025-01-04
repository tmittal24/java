package com.date.simpledateformatter.ex1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class DateFormatPerformanceComparison1 {
	private static final int MYTHREADS = 30;

	public static void main(String args[]) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);

		for (int i = 0; i < 20; i++) {

			Runnable worker = new MyRunnable();
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}
		System.out.println("\nFinished all threads");
	}

	public static class MyRunnable implements Runnable {

		MyRunnable() {

		}

		//@Override
		public void run() {
			try {
				Date configDate = new Date();
				long startTime = System.currentTimeMillis();
				String dtFmt = "yyyy-MM-dd";
				for (int i = 0; i < 200000; i++) {

					SimpleDateFormat dtFormat = new SimpleDateFormat(dtFmt);
					configDate = dtFormat.parse(dtFormat.format(configDate));
				}
				long endTime = System.currentTimeMillis();
				long result = endTime - startTime;
				System.out.println("SimpleDateFormat timetaken is " + result);
			} catch (ParseException prseEx) {

			}

			try {
				long startTime = System.currentTimeMillis();
				for (int i = 0; i < 200000; i++) {
					Date configDate = new Date();
					DateTime dateTime = new DateTime(configDate);
					DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
					String str = dtf.print(dateTime);
					DateTime jodatime = dtf.parseDateTime(str);
					configDate = jodatime.toDate();
				}
				long endTime = System.currentTimeMillis();
				long result = endTime - startTime;
				System.out.println("Joda timetaken is " + result);
			} catch (Exception ex) {

			}

			try {
				long startTime = System.currentTimeMillis();

				for (int i = 0; i <= 200000; i++) {
					Date configDate = new Date();
					configDate = new SimpleDateFormatThreadLocal().convertStringToDate(configDate);
				}
				long endTime = System.currentTimeMillis();
				long result = endTime - startTime;
				System.out.println("ThreadLocal timetaken is " + result);
			} catch (Exception ex) {

			}
		}
	}
}