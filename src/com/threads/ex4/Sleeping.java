package com.threads.ex4;

/* Example from "Java Certification Exam Guide" by Barry Boone p276

 Illustrating why a thread may not execute because it has been put
 to sleep.

 The low priority thread runs while the higher priority thread is
 sleeping.

 */

class Sleeping {
	public static void main(String[] args) {
		MyThread11 t1 = new MyThread11(1);
		MyThread11 t2 = new MyThread11(2);

		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}

class MyThread11 extends Thread {
	int id;

	MyThread11(int id) {
		this.id = id;
	}

	public void run() {
		final int temp = 0;
		for (int i = 0; i < 10; i++) {
			if (id == 1 && i == 5) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("My id is: " + id);
		}
	}
}