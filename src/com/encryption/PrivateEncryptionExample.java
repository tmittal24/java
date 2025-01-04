package com.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class PrivateEncryptionExample {
	
	public static void main(String[] args)throws UnsupportedEncodingException, NoSuchAlgorithmException, 
	NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
	
		byte[] plainText = "Private Key Encryption Algorithm".getBytes("UTF8");
		final int AES_KEYLENGTH = 128;	// change this as desired for the security level you want
		byte[] iv = new byte[AES_KEYLENGTH / 8];
		SecureRandom prng = new SecureRandom();
		prng.nextBytes(iv);
	    // get a DES private key
	    System.out.println( "\nStart generating AES key" );
	    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	    keyGen.init(128);
	    SecretKey key = keyGen.generateKey();
	    
	    System.out.println("key is :"+key.hashCode());
	    System.out.println( "Finish generating AES key" );
	    //
	    // get a DES cipher object and print the provider
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    System.out.println( "\n" + cipher.getProvider().getInfo() );
	    //
	    // encrypt using the key and the plaintext
	    System.out.println( "\nStart encryption" );
	    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(iv));
	    byte[] cipherText = cipher.doFinal(plainText);
	    System.out.println( "Finish encryption: " );
	    System.out.println( new String(cipherText, "UTF8") );
	 
	    //
	    // decrypt the ciphertext using the same key
	    System.out.println( "\nStart decryption" );
	    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(iv));
	    byte[] newPlainText = cipher.doFinal(cipherText);
	    System.out.println( "Finish decryption: " );
	 
	    System.out.println( new String(newPlainText, "UTF8") );
	}	
}
