package com.threads.ex4;

/* Example from "Java Certification Exam Guide" by Barry Boone p276

 Illustrating why a thread may not execute because it is not the
 highest priority and cannot get CPU time

 The low priority thread doesn't execute until the high priority
 is nearly completed.
 */

class LowPriority {
	public static void main(String[] args) {
		MyThread t1 = new MyThread(1);
		MyThread t2 = new MyThread(2);

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		t1.start();
	}
}

class MyThread extends Thread {
	int id;

	MyThread(int id) {
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("My id is: " + id);
	}
}