package com.hashing;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunctionTest {
	private static String listHashINput[] = {
			"implement hashCode implement hashCodeimplement hashCodeimplement hashCodeimplement hashCode implement hashCodeimplement hashCodeimplement hashCodeimplement hashCode",
			"String hash function implemented", " first five characters is a bad idea",
			"this hash function displayed terrible" };

	public static void main(String[] args) {
		digestBigInt();
	}

	private static void digetString() {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private static void digestBigInt() {
		for (int i = 0; i < listHashINput.length; i++) {
			String strKey = listHashINput[i];

			int hash = strKey.hashCode();
			// System.out.println(hash);

			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				// Compute message digest of the input
				byte[] messageDigest = md.digest(strKey.getBytes());

				BigInteger bigInt = new BigInteger(1, messageDigest);
				String hashtext = bigInt.toString(16);
				System.out.println(hashtext);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
}
