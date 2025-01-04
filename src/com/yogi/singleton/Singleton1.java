package com.yogi.singleton;
public class Singleton1 {
	private static Singleton1 test = new Singleton1();

	private Singleton1() {

	}

	public Singleton1 getInstanceSingletonTest() {
		return test;
	}

}
