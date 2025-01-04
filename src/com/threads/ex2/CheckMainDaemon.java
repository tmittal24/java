package com.threads.ex2;

/**
 * The main() daemon status is checked through the new Thread t which will
 * inherit main()'s status by default
 */
class CheckMainDaemon {

	public static void main(String[] args) {

		Thread t = new Thread();
		String msg = "Daemon status based on main() daemon status: ";
		// Main is user thread.when the last user thread completes any daemon
		// threads are stopped and the application stops
		System.out.println(msg + t.isDaemon());
	}
}