package com.yogi.regexp.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class RegexTestHarness2 {

	/**
	 * Main method to start the execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			outPut = new PrintStream(System.out);
		} catch (Exception fnfe) {
			// throw new IllegalArgumentException( " error while attempting to
			// open
			// the output file: " );
		}
		execute();
	}

	/**
	 * Bussiness logic method
	 * 
	 */
	public static void execute() {

		do {
			try {
				// System.out.print("Enter input string to search: ");
				// String input = in.readLine();
				// System.out.println(input);
				System.getProperties().list(outPut);
			} catch (NumberFormatException e) {
				log("    enter a valid number ...");
			} catch (Exception exc) {
				exc.printStackTrace(System.out);
			}
		} while (getConfirmationFromUser(" Do you want to Test new Reg Exp"));
	}

	// --- Get the user confirmation
	public static boolean getConfirmationFromUser(String question) {
		boolean done = false;
		boolean result = false;
		while (!done) {
			System.out.print(question + " (<Y>es, <N>o) ");
			try {
				String input = in.readLine();
				if (input.equalsIgnoreCase("y")) {
					result = true;
				} else if (!input.equalsIgnoreCase("n")) {
					throw new IOException("    Please type in <Y>es or <N>o!");
				}
				done = true;
			} catch (IOException e) {
				log("    Please type in <Y>es or <N>o!\n");
			}
		}
		return result;
	}

	/**
	 * Log method
	 * 
	 * @param text
	 */
	static void log(String text) {
		outPut.println(text);
		System.out.println(text);
	}

	private static PrintStream outPut;

	// Read the user input
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

}
