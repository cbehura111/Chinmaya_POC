package com.chinmaya.cache.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

@Component
public class CustomDynamicValue {

	private static final Logger logger = LogManager.getLogger(CustomDynamicValue.class);
	final static String encryptionKey = "dcsgbfuy#$@#$%$^f5yi8893789NEP87";
	final static String ivstring = "8575249666769673";
	private static final String DATA = "data";
	private static SecretKeySpec secretKey;
	private static byte[] key;
	public static String KEY_PASSWORD = "SCOREME_2021";
	
	    
		public String generateValue(String valueMapperKey) {
			logger.debug("Start : generateValue");
			String randomValue = null;
		
			if ("generateRequestTimestamp".equalsIgnoreCase(valueMapperKey)) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				randomValue = now.format(formatter);
			}else if("EFRMSRequestTimestamp".equalsIgnoreCase(valueMapperKey)) {
				  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
				  randomValue = LocalDateTime.now().format(formatter);
			}
			return randomValue;
		}
	
		public String generateValueAppendURL(String valueMapperKey, Map<String, Object> requestMap) {
			logger.debug("Start : generateValue with valueMapperKey = " + valueMapperKey);
			String reqId = requestMap.get(valueMapperKey).toString();
			return reqId;
		}


		public static String generateSHA256Hash(String sValue) throws Exception {
			String sHashedValue = "";
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update((sValue).getBytes());
				byte byteData[] = md.digest();
				// convert the byte to hex format method 1
				StringBuffer sb = new StringBuffer();
				int iSize = byteData.length;
				for (int i = 0; i < iSize; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}
				sHashedValue = sb.toString();
				// byte[] hash = md.digest(sValue.getBytes());
			} catch (Exception e) {
				throw new Exception(e);
			} finally {
				// log.debug("End : generateSHA256Hash");
			}
			return sHashedValue;
		}

	
	public static String encrypt(String plainText) throws Exception {
		String encryptedText = "";

		String characterEncoding = "UTF-8";
		String aesEncryptionAlgorithem = "AES";

		try {
			while (plainText.getBytes().length % 16 != 0) {
				plainText += '\u0020';
			}
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);

			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));

			encryptedText = (new org.apache.commons.codec.binary.Base64()).encodeAsString(cipherText);

		} catch (Exception E) {
			logger.error("Exception Occured:: "+ E);
		}
		return encryptedText;

	}
	
	public static String decryptEncData(String encData1) {
		String decryptedText = "";
		try {
			// Setting key and IV in global static variable to future use.

			byte[] secretKeyInByte = encryptionKey.getBytes();

			SecretKeySpec secretkeyspec = new SecretKeySpec(secretKeyInByte, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, secretkeyspec, ivparameterspec);

			byte[] encByteArray = (new org.apache.commons.codec.binary.Base64()).decode(encData1.getBytes());

			byte[] cipherText = cipher.doFinal(encByteArray);
			decryptedText = new String(cipherText, "UTF-8");
		} catch (Exception e) {
			logger.error("Exception Occured:: " + e);
		}
		return decryptedText;

	}
	
	
	/*public static JSONObject decryptDataFromResponse(Object val) {
		logger.debug("enter in response data decryption");
		// JSONObject jsonActaulRes = null;
		try {
			JSONObject jsonActaulRes = new JSONObject((String) val);
			String dataEncryptString = jsonActaulRes.getString(DATA);
			String dataDecryptString = CustomDynamicValue.decryptEncData(dataEncryptString);
			logger.debug("final JSON Response after decryption :: {}", dataDecryptString);
			return new JSONObject(dataDecryptString);
			//jsonActaulRes.put(DATA, jsonDataDecrypt);
		} catch (Exception e) {
			logger.error("Exception While decrypting Data Object :: " + e);
		}
		return new JSONObject(val);
	}*/
	
	public static JSONObject decryptDataFromResponse(Object val) {
		logger.debug("Enter in response data decryption");

		try {
			JSONObject jsonActaulRes = new JSONObject((String) val);
			var data = jsonActaulRes.opt(DATA);

			// Attempt decryption only if data is encrypted
			if (data instanceof String dataEncryptString && isEncrypted(dataEncryptString)) {
				logger.debug("given data is encrypted data");
				try {
					var dataDecryptString = decryptEncData(dataEncryptString);
					logger.debug("Final JSON Response after decryption :: {}", dataDecryptString);
					// TODO clean up required for below line.Was written to handle few API (Statement APIs) response , now BANK has rectified API response
					String s = dataDecryptString.substring(dataDecryptString.indexOf("{"));
					logger.debug("Final JSON Response after s :: {}", s);
					return new JSONObject(s);
				} catch (Exception e) {
					logger.error("Decryption failed, returning original data. Error: {}", e);
					return jsonActaulRes; // Return original JSON if decryption fails
				}
			}
			logger.debug("Data is not encrypted or not a string, returning original JSON.");
			return jsonActaulRes;
		} catch (Exception e) {
			logger.error("Exception while processing Data Object :: {}", e);
		}
		return new JSONObject(val);
	}
	
	public static boolean isEncrypted(String data) {
	    // Check if data is Base64 encoded (common for encrypted data)
	    try {
	        byte[] decoded = Base64.getDecoder().decode(data);
	        return decoded.length % 16 == 0; // Many encryption algorithms use 16-byte block size
	    } catch (IllegalArgumentException e) {
	        return false; // Not Base64, so assume it's plain text
	    }
	}


	
	
	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// Aadhaar Req Encrypt
	public static String aadhaarEncrypt(String strToEncrypt) {

		String encString = "";
		try {
			setKey(KEY_PASSWORD);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encString = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			logger.debug("Exception While Encrypting Aadhaar Object :: " + e);
		}
		return encString;
	}

	// Aadhaar Response Decrypt
	public static String aadhaarDecrypt(String strToDecrypt) {

		String decryptString = "";
		try {
			setKey(KEY_PASSWORD);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			decryptString = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			logger.debug("Exception While Decrypting Aadhaar Object :: " + e);
		}
		return decryptString;
	}

}