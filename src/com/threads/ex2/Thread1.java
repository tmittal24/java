package com.threads.ex2;

/* Example from "Java 2 Certification" by Jamie Jaworski p175

 Subclassing the Thread class
 Program displays the message "Java is hot, aromatic and invigorating"
 one word at a time with each thread displaying the same message.
 The output is interleaved.
 */

class Thread1 extends Thread {
	static String[] msg = { "Java", "is", "hot,", "aromatic,", "and", "invigorating." };

	public static void main(String[] args) {
		Thread1 t1 = new Thread1("t1: ");
		Thread1 t2 = new Thread1("t2: ");

		t1.start();
		t2.start();

		boolean t1IsAlive = true;
		boolean t2IsAlive = true;

		do {
			if (t1IsAlive && !t1.isAlive()) {
				t1IsAlive = false;
				System.out.println("t1 is dead.");
			}

			if (t2IsAlive && !t2.isAlive()) {
				t2IsAlive = false;
				System.out.println("t2 is dead.");
			}
		} while (t1IsAlive || t2IsAlive);
	}

	public Thread1(String id) {
		super(id);
	}

	public void run() {
		String name = getName();
		for (int i = 0; i < msg.length; i++) {
			randomWait();
			System.out.println(name + msg[i]);
		}
	}

	void randomWait() {
		try {
			sleep((long) (3000 * Math.random()));
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
}