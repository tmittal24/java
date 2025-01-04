package com.threads.y1;

class Extender extends Thread {
	public Extender() {
	}

	public Extender(Runnable runnable) {
		super(runnable);
	}

	public void run() {
		System.out.print("|Extender|");
	}
}

public class Implementer implements Runnable {
	public void run() {
		System.out.print("|Implementer|");
	}

	public static void main(String[] args) {
		new Extender(new Implementer()).start(); // (1)
		new Extender().start(); // (2)
		new Thread(new Implementer()).start(); // (3)
	}
}