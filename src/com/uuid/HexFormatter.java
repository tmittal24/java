package com.uuid;



public class HexFormatter {

	/**
	 * Establish the range of Hex characters.
	 */
	private static final char[] HEXCHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static byte[] fromHexString(String aHexString) {

		int len = aHexString.length();
		byte[] buf = new byte[(len + 1) / 2];
		int i = 0;
		int j = 0;

		if ((len % 2) == 1) {
			buf[j++] = (byte) fromDigit(aHexString.charAt(i++));
		}

		while (i < len) {
			buf[j++] = (byte) ((fromDigit(aHexString.charAt(i++)) << 4) | fromDigit(aHexString
					.charAt(i++)));
		}

		return buf;
	}

	/**
	 * Convert array of bytes to a hexadecimal string.
	 * 
	 * @param aBytes
	 *            The array of bytes to translate.
	 * 
	 * @return The hexadecimal string representation of the array of bytes.
	 */
	public static String toHexString(byte[] aBytes) {

		StringBuffer buf = new StringBuffer(aBytes.length * 2);
		int len = aBytes.length;

		for (int i = 0; i < len; i++) {
			byte2hex(aBytes[i], buf);
		}

		return buf.toString();
	}

	/**
	 * Translate a byte to a hex character.
	 * 
	 * @param aByte
	 *            byte.
	 * @param aBuf
	 *            StringBuffer to append the translated byte to.
	 */
	private static void byte2hex(byte aByte, StringBuffer aBuf) {

		int high = (aByte & 0xf0) >> 4;
		int low = aByte & 0xf;
		aBuf.append(HEXCHARS[high]);
		aBuf.append(HEXCHARS[low]);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @since $Release$
	 * 
	 * @param aChar
	 *            DOCUMENT ME!
	 * 
	 * @return DOCUMENT ME!
	 * 
	 * @throws IllegalArgumentException
	 *             DOCUMENT ME!
	 */
	private static int fromDigit(char aChar) {

		int result;

		if ((aChar >= '0') && (aChar <= '9')) {

			result = aChar - 48;
		}

		else if ((aChar >= 'A') && (aChar <= 'F')) {

			result = (aChar - 65) + 10;
		}

		else if ((aChar >= 'a') && (aChar <= 'f')) {

			result = (aChar - 97) + 10;
		} else {
			throw new IllegalArgumentException(
					"an invalid hex digit was found -\t'" + aChar + "'");
		}

		return result;
	}

}
