package com.threads.ex4;

/* Example from "Java Certification Exam Guide" by Barry Boone p276

 Illustrating why a thread may not execute because there are other
 threads with the same priority and the CPU is switching between
 them.

 The output jumps back and forth between the two threads.

 */

class SamePriority {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2(1);
		MyThread2 t2 = new MyThread2(2);

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}

class MyThread2 extends Thread {
	int id;

	MyThread2(int id) {
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 100; i++)
			System.out.println("My id is: " + id);
	}
}