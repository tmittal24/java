package com.threads.ex3;

/** The Traffic light program from 'Java Gently' by JM Bishop,1996
 Displays a representation of traffic lights
 in preparation for a simulation.
 Illustrates panels and canvases and the BorderLayout Manager
 */

import java.awt.*;

public class Traffic extends Frame {

	private Canvas area;

	private int lightsPosition = 105;

	private static final int lightsWidth = 150;

	private SetOfLights[] lights = new SetOfLights[3];

	private int lightsNo;

	private int setWanted;

	private TextField duration;

	public Traffic() {
		setTitle("Traffic Lights");
		Panel title = new Panel();
		title.add(new Label("Mittal Traffic Light Simulation"));
		add("North", title);

		area = new Canvas();
		add("Center", area);

		Panel buttons = new Panel();
		buttons.add(new Button("Start"));
		Choice c = new Choice();
		c.addItem("Red");
		c.addItem("Yellow");
		c.addItem("Green");
		c.addItem("Walk");
		buttons.add(c);
		buttons.add(new Label("Duration"));
		duration = new TextField("", 3);
		duration.setEditable(false);
		buttons.add(duration);
		buttons.add(new Button("Walk"));
		buttons.add(new Button("Close"));
		add("South", buttons);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		setWanted = x / lightsWidth;
		return true;
	}

	public boolean action(Event evt, Object arg) {
		if (arg.equals("Start")) {
			lights[lightsNo] = new SetOfLights(area, lightsPosition);
			lights[lightsNo].start();
			lightsPosition += lightsWidth;
			lightsNo++;
		} else if (arg.equals("Walk"))
			lights[setWanted].walk = true;
		else if (arg.equals("Close")) {
			this.hide();
			this.dispose();
			System.exit(0);
		} else
			return super.action(evt, arg);
		return true;
	}

	public boolean handleEvent(Event evt) {
		if (evt.id == Event.WINDOW_DESTROY)
			System.exit(0);
		return super.handleEvent(evt);
	}

	public static void main(String[] args) {
		Frame f = new Traffic();
		f.resize(450, 210);
		f.show();
	}
}
