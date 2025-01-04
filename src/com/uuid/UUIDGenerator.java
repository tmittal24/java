package com.uuid;

public class UUIDGenerator {

	/**
	 * CleintParm = ENCRYPT_UUID
	 */
	static boolean isUUIDEncryptionEnabled = false;

	// comes from HRO file - GLOBAL_SESSION_ID_KEY
	static String encryptionKeyGlobal = "20E261FE45A270D60D6086E06A0F69D7"; 

	public static String createUUID(String aIntId, String aClientId) {
		String uuid = createOpaqueId(aIntId, aClientId);

		String encryptedUUID = uuid;
		System.out.println("uuid=" + uuid);
		// encrypt uuid if configured by client
		if (isUUIDEncryptionEnabled()) {

			try {

				/**
				 * <pre>
				 * String encryptionKey = (String) HROPropertiesLocalServiceUtil.getProperty(hroLineage, GLOBAL_SESSION_ID_KEY);
				 * </pre>
				 * 
				 */

				String encryptionKey = "20E261FE45A270D60D6086E06A0F69D7";
				//encryptionKey = encryptionKeyGlobal;
				encryptedUUID = (String) (new SecureText(encryptionKey).encrypt(uuid));

				
			}

			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("encryptedUUID=" + encryptedUUID);
		return encryptedUUID;
	}

	public static boolean isUUIDEncryptionEnabled() {
		boolean encryptUUID = false; // defaulted to false for fallback
		try {

			// Parameter encryptionEnabledParameter =
			// ParametersLocalServiceUtil.getParameter(lineage,"ENCRYPT_UUID");
			if (isUUIDEncryptionEnabled) {
				encryptUUID = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encryptUUID;

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

		return sb.toString();
	}

}
