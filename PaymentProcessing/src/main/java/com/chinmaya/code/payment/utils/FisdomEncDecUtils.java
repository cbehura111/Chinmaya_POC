package com.chinmaya.code.payment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class FisdomEncDecUtils {
	


	public static Logger logger = LogManager.getLogger(FisdomEncDecUtils.class);

	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";
	

	public static String encrypt(String plaintext) {
		try {
//			String key = CommonUtils.getExternalProperties("fisdomKey");
//			String iv = CommonUtils.getExternalProperties("fisdomVectorKey");
			String key = "9353667e3287a8943e96056368406962";
			String iv = "9568463295684632";
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
			byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
			return Base64.getEncoder().encodeToString(encryptedBytes);
		} catch (Exception e) {
			logger.error("Exception occurred while encrypting the text:: {}", e);
			return "";
		}
	}

	public static String decrypt(String ciphertext) {
		try {
		//	String key = CommonUtils.getExternalProperties("fisdomKey");
		//	String iv = CommonUtils.getExternalProperties("fisdomVectorKey");
			String key ="9353667e3287a8943e96056368406962";
			String iv ="9568463295684632";
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
			IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
			byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
			return new String(decryptedBytes);
		} catch (Exception e) {
			logger.error("Exception occurred while decrypting the text:: {}", e);
			return "";
		}
	}
	public static String formatAccountNumber(String accNo, int trailingZerosToRemove, boolean removeAllTrailingZeros) {
		return accNo.replaceFirst("^0{1," + (removeAllTrailingZeros ? accNo.length() : trailingZerosToRemove) + "}", "");
	}

//	public static void main(String[] args) {
//		String jsonencryptValue;
//		String jsondecValue;
//
//		try {
//
//			String accNo = "0000009876578000";
//			int trailingZerosToRemove = 8;
//			boolean removeAllTrailingZeros = false; // Change to true to remove all trailing zeros
//
//			String formattedAccNo = formatAccountNumber(accNo, trailingZerosToRemove, removeAllTrailingZeros);
//			System.out.println("Formatted Account Number: " + formattedAccNo);
//
//			jsonencryptValue= FisdomEncDecUtils.encrypt("{\r\n"
//					+ " \"action\": \"FisdomTokenValidation\",\r\n"
//					+ " \"subAction\": \"FisdomTokenValidation\",\r\n"
//					+ " \"entityId\": \"INB\",\r\n"
//					+ " \"inputParam\": {\r\n"
//					+ " \"token\": \"712762\"\r\n"
//					+ " }\r\n"
//					+ " }");
//			System.out.println(jsonencryptValue);
//
//
//			jsondecValue= FisdomEncDecUtils.decrypt("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");
//			System.out.println(jsondecValue);
//		} catch (Exception e) {
//			// TODOAuto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
