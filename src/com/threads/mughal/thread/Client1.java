package com.threads.mughal.thread;

class Counter implements Runnable {

	private int currentValue;

	private Thread worker;
	
	Counter(){
		
	}

	public Counter(String threadName) {
		currentValue = 0;
		worker = new Thread(this, threadName); // (1) Create a new thread.
		System.out.println(worker);
		worker.start(); // (2) Start the thread.
	}

	public int  getValue() {
		return currentValue;
	}
	
	static long  getValue1() {
		return 3;
	}

	public void run() { // (3) Thread entry point
		try {
			while (currentValue < 5) {
				//System.out.println(worker.getName() + ": " + (currentValue++));
				Thread.sleep(250); // (4) Current thread sleeps.
			}
		} catch (InterruptedException e) {
			System.out.println(worker.getName() + " interrupted.");
		}
		System.out.println("Exit from thread: " + worker.getName());
	}
}

public class Client1 {
	public static void main(String[] args) {
		Counter counterA = new Counter("Counter A"); // (5) Create a thread.

		try {
			int val;
			do {
				val = counterA.getValue(); // (6) Access the counter value.
				System.out.println("Counter value read by main thread: " + val);
				Thread.sleep(1000); // (7) Current thread sleeps.
			} while (val < 50);
		} catch (InterruptedException e) {
			System.out.println("main thread interrupted.");
		}

		System.out.println("Exit from main() method.");
	}
}
