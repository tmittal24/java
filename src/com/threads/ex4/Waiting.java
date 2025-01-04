package com.threads.ex4;

/* Example from "Java Certification Exam Guide" by Barry Boone p276

 Illustrating why a thread may not execute because it is waiting.

 The low priority thread runs while the higher priority thread is
 waiting.

 */

class Waiting {
	public static void main(String[] args) {
		MyThread5 t1 = new MyThread5(1);
		MyThread5 t2 = new MyThread5(2);

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}

class MyThread5 extends Thread {
	int id;

	MyThread5(int id) {
		this.id = id;
		this.setDaemon(false);
	}

	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			if (id == 1 && i == 5) {
				try {
					wait(1000);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("My id is: " + id + " === " + this.isDaemon());
		}
	}
}
