package com.yogi.inhetitance.ex1.pckage1;

public class Animal {
	public int nr = 0;

	public static void main(String args[]) {
		Animal anim = new Cat(1);
		Cat cat = new Cat(2);

		System.out.println(anim.nr);
		System.out.println(((Cat) (anim)).nr);
		System.out.println(cat.nr);
	}
}

class Cat extends Animal {
	public int nr = 0;

	public Cat(int i) {
		nr = i;
	}
}
