package com.yogi.sorting;

public class Swap {

	public void swap() {
		int x = 50, y = 70;

		System.out.println("x=" + x + ", y=" + y);
		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("x=" + x + ", y=" + y);
	}

	public static void main(String[] args) {
		Swap swap = new Swap();
		swap.swap();
	}
}
