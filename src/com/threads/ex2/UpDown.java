package com.threads.ex2;

/** Example from "Java Certification Exam Guide" by Barry Boone p 253
 Creating threads by subclassing Thread
 Bounces a ball up and down on the screen
 */

import java.awt.*;
import java.applet.Applet;

public class UpDown extends Applet {
	static int RADIUS = 20;

	static int X = 30;

	public int y = 30;

	public void init() {
		new BounceThread(this).start();
	}

	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.drawOval(X - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	}

}

class BounceThread extends Thread {
	UpDown applet;

	int yDir = +1;

	int incr = 10;

	int sleepFor = 100;

	BounceThread(UpDown a) {
		this.applet = a;
	}

	public void run() {
		while (true) {
			applet.y += (incr * yDir);
			applet.repaint();

			if (applet.y - UpDown.RADIUS < incr || applet.y + UpDown.RADIUS + incr > applet.getSize().height)
				yDir *= -1;

			try {
				sleep(sleepFor);
			} catch (InterruptedException e) {
			}
		} // end while
	}
}