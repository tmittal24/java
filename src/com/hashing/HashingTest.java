package com.hashing;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

public class HashingTest {

	public static void main(String[] args) {

		String object = "";

		MessageDigest messageDigest = null;
		byte[] hash = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(object.getBytes("UTF8"));
			hash = messageDigest.digest();

			String output = String.valueOf(Hex.encodeHex(hash));
			System.out.println(output);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
