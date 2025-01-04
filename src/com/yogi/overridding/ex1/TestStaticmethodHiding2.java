package com.yogi.overridding.ex1;

class Foo1 {
	public static void classMethod() {
		System.out.println("classMethod() in Foo");
	}

	public Foo1 instanceMethod() {
		System.out.println("instanceMethod() in Foo");
		return new Foo1();
	}
}

class Bar1 extends Foo1 {
	public static void classMethod() {
		System.out.println("classMethod() in Bar");
	}

	public Bar1 instanceMethod() {
		System.out.println("instanceMethod() in Bar");
		return new Bar1();
	}
}

public class TestStaticmethodHiding2 {
	public static void main(String[] args) {
		Foo1 f = new Bar1();
		f.instanceMethod();
		f.classMethod();
	}

}
