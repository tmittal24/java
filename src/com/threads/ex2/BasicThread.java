package com.threads.ex2;

class BasicThread extends Thread {

	char c;

	BasicThread(char c) {
		this.c = c;
	}

	// override run() method in inherited by Thread via
	// the Runnable interface
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print(c);

			try {
				sleep((int) (Math.random() * 10));
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception caught");
			}
		}
	}

	public static void main(String[] args) {

		BasicThread bt = new BasicThread('!');
		BasicThread bt1 = new BasicThread('*');

		bt.start();
		bt1.start();
	}

}