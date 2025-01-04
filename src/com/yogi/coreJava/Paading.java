package com.yogi.coreJava;
public class Paading {
	public static void main(String[] args) {
		Paading.createOpaqueId("XXXXXXLL", "CCC");
	}

	public static String createOpaqueId(String aIntId, String aClientId) {
		String partial = aIntId + aClientId;

		// determine the amount of padding needed
		int padLen = 15 - partial.length();

		StringBuilder sb = new StringBuilder(partial);

		// add proper padding
		for (int i = 0; i < padLen; i++) {
			sb.insert(0, '0');
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
