package com.yogi.annotations.ex2;

public class BuildHouse {
	@Developer("Alice")
	public void aliceMethod() {
		System.out.println("This method is written by Alice");
	}

	@Developer("Popeye")
	public void buildHouse() {
		System.out.println("This method is written by Popeye");
	}
}
