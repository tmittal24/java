package com.yogi.annotations.ex1;

@TestParameters(
		testStage = "Unit", 
		testMethods = "testConcat,testSubstring", 
		testOutputType = "screen", 
		testOutput = "")
public class StringUtility {
	public String concat(String s1, String s2) {
		return (s1 + s2);
	}

	public String substring(String str, int startIndex, int endIndex) {
		return (str.substring(startIndex, endIndex));
	}

	public boolean testConcat() {
		String s1 = "test";
		String s2 = " 123";
		return (concat(s1, s2).equals("test 123"));
	}

	public boolean testSubstring() {
		String str = "The cat landed on its feet";
		return (substring(str, 4, 7).equals("cat"));
	}
}