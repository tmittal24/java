package com.uuid;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


/**
 * This class will be used to encrypt and decrypts text strings according to a
 * key (defined in property file) and the Blowfish algorithm.
 * 
 */

@Deprecated
public class SecureText {

	/**
	 * DOCUMENT ME!
	 * 
	 * @since 1.0
	 */
	private final String ALGORITHM_NAME = "Blowfish";

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 */
	private Cipher mDecoder;

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 */
	private Cipher mEncoder;

	/**
	 * Creates a new SecureText object.
	 * 
	 * @param aKey
	 *            DOCUMENT ME!
	 * 
	 * @since $Release$
	 * 
	 * @throws FndtCryptoException
	 *             DOCUMENT ME!
	 */
	@Deprecated
	public SecureText(String aKey) throws FndtCryptoException {

		byte[] keyBytes = HexFormatter.fromHexString(aKey);
int size = keyBytes.length;
		try {
			mEncoder = Cipher.getInstance(ALGORITHM_NAME);
			mEncoder.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes,
					ALGORITHM_NAME));
			mDecoder = Cipher.getInstance(ALGORITHM_NAME);
			mDecoder.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes,
					ALGORITHM_NAME));
		} catch (InvalidKeyException ike) {
			throw new FndtCryptoException("Couldn't initialize Cipher: "
					+ ike.getMessage(), ike);
		} catch (NoSuchAlgorithmException nsae) {
			throw new FndtCryptoException("Couldn't initialize Cipher: "
					+ nsae.getMessage(), nsae);
		} catch (NoSuchPaddingException nspe) {
			throw new FndtCryptoException("Couldn't initialize Cipher: "
					+ nspe.getMessage(), nspe);
		} catch (Exception e) {
			throw new FndtCryptoException("Couldn't initialize Cipher: "
					+ e.getMessage(), e);
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 * 
	 * @param aForDecryption
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * 
	 * @throws FndtCryptoException
	 *             DOCUMENT ME! public static void main(String[] args) throws
	 *             FndtCryptoException { SecureText codec = new SecureText();
	 *             System.out.println(codec.encrypt("this is a
	 *             test")); System.out.println(codec.decrypt("
	 *             76668B2FF887AEEC"));
	 *             System.out.println(codec.decrypt("64085FEDB8EA0F82")); }
	 */

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 * 
	 * @param aForDecryption
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * 
	 * @throws FndtCryptoException
	 *             DOCUMENT ME!
	 */
	@Deprecated
	public String decrypt(String aForDecryption) throws FndtCryptoException {

		try {

			String decStr = aForDecryption;

			if (aForDecryption != null) {

				byte[] decBytes = mDecoder.doFinal(HexFormatter
						.fromHexString(aForDecryption));

				decStr = new String(decBytes);
			}

			return decStr;

		} catch (BadPaddingException bpe) {
			throw new FndtCryptoException("Couldn't decrypt: "
					+ bpe.getMessage(), bpe);
		} catch (IllegalBlockSizeException ibse) {
			throw new FndtCryptoException("Couldn't decrypt: "
					+ ibse.getMessage(), ibse);
		} catch (Exception e) {
			throw new FndtCryptoException(
					"Couldn't decrypt: " + e.getMessage(), e);
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 * 
	 * @param aForEncryption
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * 
	 * @throws FndtCryptoException
	 *             DOCUMENT ME!
	 */
	
	@Deprecated
	public String encrypt(String aForEncryption) throws FndtCryptoException {

		try {

			String encrypted = aForEncryption;

			if (encrypted != null) {

				byte[] encBytes = mEncoder.doFinal(encrypted.getBytes());

				encrypted = HexFormatter.toHexString(encBytes);
			}

			return encrypted;

		} catch (BadPaddingException bpe) {
			throw new FndtCryptoException("Couldn't encrypt: "
					+ bpe.getMessage(), bpe);
		} catch (IllegalBlockSizeException ibse) {
			throw new FndtCryptoException("Couldn't encrypt: "
					+ ibse.getMessage(), ibse);
		} catch (Exception e) {
			throw new FndtCryptoException(
					"Couldn't encrypt: " + e.getMessage(), e);
		}
	}

}
