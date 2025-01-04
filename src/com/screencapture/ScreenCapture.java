package com.screencapture;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ScreenCapture {

	public static void main(String[] args) {
		ScreenCapture test2 = new ScreenCapture();
		test2.makeScreenshot();
	}

	public  void makeScreenshot() {
		BufferedImage screencapture;
		try {
			System.out.println("Starting............");
			screencapture = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

			File file = new File("c:/temp/screencapture.jpg");
			ImageIO.write(screencapture, "jpg", file);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Save as JPEG

		// Save as PNG
		// File file = new File("screencapture.png");
		// ImageIO.write(screencapture, "png", file);
	} // makeScreenshot method

}
