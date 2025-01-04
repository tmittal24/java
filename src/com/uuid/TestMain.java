package com.uuid;

public class TestMain {

	public static void main(String[] args) {
		TestMain obj = new TestMain();

		/**
		 * <pre>
		 * 	User - ID		Password	TestCFG 1	TestCFG 2	UUID LOGGED BY UPOINT
		 * 000HEW00339009	99999999	L78B		L78B		091000117400095
		 * 000HEW00435010	87654321	L78B		L78B		089000111100095
		 * </pre>
		 */
		
		
		/**
		 * Person Id =	789654123
		 * Person Internal Id =	053000055
		 */
		UUIDGenerator.createUUID("053000055", "19920");
		UUIDGenerator.createUUID("910001174", "00095");
		UUIDGenerator.createUUID("6d5770b2f23810cc2cfb9d15acc4810d", "19941"); //BPO
		
		
	}

}
