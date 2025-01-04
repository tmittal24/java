package com.yogi.jdk50;

import javax.swing.Box;

public class shiftOperator {

	public static void main(String[] args) {
		leftShift();

		System.out.println("--------------------------------------");
		
		rithShift1();
		
		System.out.println("--------------------------------------");
		


	}

	private static void leftShift() {
		int i = 12;
		int exp = 5;
		int k = 5;
		int result = i << exp; // 192

		System.out.println(result);

		System.out.println(i * (Math.pow(2, exp)));
	}

	private static void rithShift1() {
		int i1 = -42;
		int exp1 = 4;
		int result1 = i1 >> exp1;    // 3

		System.out.println(result1);
		System.out.println(i1 >>> exp1);

		System.out.println(i1 / (Math.pow(2, exp1)));
		
	}

	public static void printIntToStr(String label, int result) {
		System.out.println(label);
		System.out.println("    Binary:  " + Integer.toBinaryString(result));
		System.out.println("    Hex:     " + Integer.toHexString(result));
		System.out.println("    Octal:     " + Integer.toOctalString(result));
		System.out.println("    Decimal: " + result);
	}

}
