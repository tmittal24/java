package com.threads.ex4;

/* Illustrating why a thread may not execute because it has yielded.

 The low priority thread runs after the higher priority thread has
 yielded. Example doesn't work that great as Win95 time slices
 
 */

class Yielding {
	public static void main(String[] args) {
		MyThread6 t1 = new MyThread6(1);
		MyThread6 t2 = new MyThread6(2);

		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY); // won't yield() for lower
												// priority
		t1.start();
		t2.start();
	}
}

class MyThread6 extends Thread {
	int id;

	MyThread6(int id) {
		this.id = id;
	}

	public synchronized void run() {
		for (int i = 0; i < 100; i++) {
			if (id == 1 && i == 30) {
				//yield(); TOTO check this stmt with latest JDK
			}
			System.out.println("My id is: " + id);
		}
	}
}