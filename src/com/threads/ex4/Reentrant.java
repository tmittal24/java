package com.threads.ex4;

/** Based on example from Sun Thread tutorial */

class Reentrant1 {

	public synchronized void a() {
		b();
		System.out.println("here I am, in a()");
	}

	public synchronized void b() {
		System.out.println("here I am, in b()");
	}
}

class Reentrant {
	public static void main(String[] args) {
		Reentrant1 r = new Reentrant1();
		r.a();
	}
}