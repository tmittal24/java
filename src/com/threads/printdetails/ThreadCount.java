package com.threads.printdetails;

import java.lang.management.ManagementFactory;

public class ThreadCount {

	public static void main(String[] args) {
		long count = ManagementFactory.getThreadMXBean().getThreadCount();
		System.out.println("Threadcount =" + count);
		
		count = Thread.activeCount();
		System.out.println("Threadcount =" + count);
	}

}
