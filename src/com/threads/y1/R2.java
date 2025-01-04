package com.threads.y1;

class R1 implements Runnable {
	public void run() {
		System.out.print(Thread.currentThread().getName());
	}
}

public class R2 implements Runnable {
	public void run() {
		new Thread(new R1(), "|R1a|").run();
		new Thread(new R1(), "|R1b|").start();
		System.out.print(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		new Thread(new R2(), "|R2|").start();
	}
}