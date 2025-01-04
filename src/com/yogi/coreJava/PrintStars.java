package com.yogi.coreJava;

public class PrintStars {
	public static void main(String[] args) {
		triangle();
	}

	private static void simple1() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	private static void simple2() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	
	private static void simple2_reverse() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; i < 5-j; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	private static void triangle() {
		for (int i = 1; i <= 5; i++) {
			System.out.print(" ");
			for (int j = 1; j < i; j++) {
				System.out.println("*");
			}
			
		}
	}
}
