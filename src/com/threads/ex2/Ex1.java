package com.threads.ex2;

/*  Exercise 12.1 from "Java Certification Exam Guide" by Barry Boone p 256
 Following is written by extending the Thread class
 Re-write using 'implement Runnable'

 The applet continually displays numbers in blue, one number per second.
 If the number is a prime, the number is displayed in red.
 */

import java.awt.*;
import java.applet.Applet;

public class Ex1 extends Applet {
	Color color = Color.red;

	int candidate = 3;

	PrimeThread prime;

	public void init() {
		prime = new PrimeThread(this);
		prime.start();
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.drawString(new Integer(candidate).toString(), 30, 40);
	}
}

class PrimeThread extends Thread {
	Ex1 target;

	PrimeThread(Ex1 target) {
		this.target = target;
	}

	public void run() {
		int candidate;
		for (candidate = 3;; candidate++) {
			if (isPrime(candidate))
				target.color = Color.red;
			else
				target.color = Color.blue;

			target.candidate = candidate;
			target.repaint();

			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		} // end for
	}

	public boolean isPrime(int number) {
		boolean isPrime = true;

		for (int i = 2; i < number - 1 && isPrime; i++) {
			if ((number % i) == 0)
				isPrime = false;
		}
		return isPrime;
	}
}
