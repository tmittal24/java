package com.threads.ex3;

import java.awt.*;

class SetOfLights extends Thread {

	private Canvas area;

	private int x;

	boolean walk = false;

	private static final int red = 0;

	boolean walkOn = false;

	SetOfLights(Canvas c, int x) {
		area = c;
		this.x = x;
	}

	public void run() {
		while (true) {
			for (int light = 0; light < 3; light++) {
				if (light == red & walk) {
					walkOn = false;
					for (int i = 0; i < 11; i++) {
						draw(light);
						try {
							sleep(500);
						} catch (InterruptedException e) {
						}
						walkOn = !walkOn;
					}
					walk = false;
				} else {
					draw(light);
					try {
						sleep(500);
					} catch (InterruptedException e) {
					}
				} // end if-else
			} // end for
		} // end while
	}

	public void draw(int light) {
		Graphics g = area.getGraphics();

		g.setColor(Color.black);
		g.drawOval(x - 8, 10, 30, 68);
		g.drawOval(x, 85, 15, 15);

		g.drawString("RED", x - 90, 28);
		g.drawString("YELLOW", x - 90, 48);
		g.drawString("GREEN", x - 90, 68);
		g.drawString("WALK", x - 90, 98);

		switch (light) {
		case 0:
			g.setColor(Color.red);
			g.fillOval(x, 15, 15, 15);
			g.setColor(Color.lightGray);
			g.fillOval(x, 35, 15, 15);
			g.fillOval(x, 55, 15, 15);
			break;

		case 1:
			g.setColor(Color.green);
			g.fillOval(x, 55, 15, 15);
			g.setColor(Color.lightGray);
			g.fillOval(x, 15, 15, 15);
			g.fillOval(x, 35, 15, 15);
			break;

		case 2:
			g.setColor(Color.yellow);
			g.fillOval(x, 35, 15, 15);
			g.setColor(Color.lightGray);
			g.fillOval(x, 15, 15, 15);
			g.fillOval(x, 55, 15, 15);
			break;
		}
	}
}