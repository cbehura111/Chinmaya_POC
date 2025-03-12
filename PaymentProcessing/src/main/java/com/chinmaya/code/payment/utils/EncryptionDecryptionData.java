package com.chinmaya.code.payment.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

@Component
public class EncryptionDecryptionData {
	
	final static String encryptionKey ="dcsgbfuy#$@#$%$^f5yi8893789NEP87";
	final static String ivstring ="8575249666769673";
	
	public static String decryptEncData(String encData1)
	{

		String decryptedText = "";
		String finalText = "";
		String decryptedData = "";
		try
		{
			// Setting key and IV in global static variable to future use.

			byte[] secretKeyInByte = encryptionKey.getBytes();

			SecretKeySpec secretkeyspec = new SecretKeySpec(secretKeyInByte, "AES");
			IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, secretkeyspec, ivparameterspec);

			byte[] encByteArray = (new org.apache.commons.codec.binary.Base64()).decode(encData1.getBytes());
			// byte[] encByteArray = Base64.getDecoder().decode(encData1.getBytes());

			byte[] cipherText = cipher.doFinal(encByteArray);
			decryptedText = new String(cipherText, "UTF-8");
			// decryptedData = decryptedText.substring(16);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			// return "Error";
		}
		return decryptedText;

	}

	public static String encrypt(String plainText) throws Exception
	{
		String encryptedText = "";

		String characterEncoding = "UTF-8";
		String aesEncryptionAlgorithem = "AES";

		try
		{

			while(plainText.getBytes().length % 16 != 0)
			{
				plainText += '\u0020';
			}

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);

			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));

			encryptedText = (new org.apache.commons.codec.binary.Base64()).encodeAsString(cipherText);

		}
		catch(Exception E)
		{

			System.err.println("Encrypt Exception : " + E);
		}

		return encryptedText;

	}

	public static void main(String arg[]) throws Exception
	{

		String reqString="{\r\n"
				+ "        \"inputType\": \"MOBILE\",\r\n"
				+ "        \"inputValue\": \"917709711236\",\r\n"
				+ "        \"requestId\": \"BOMMB202411229999\",\r\n"
				+ "         \"requestType\":\"fetchCifAdhaarMobPan\"  \r\n"
				+ "  }";
		String encData = encrypt(reqString);
		//System.out.println("Encrypted Data = " + encData);
		
		//String shaValue = generateSHA256Hash("{\"accountNumber\":\"60398969473\",\"emailID\"  :\"vinitvdeshmukh@gmail.com\",\"fromDate\" :\"2014-06-01\",\"toDate\":\"2014-06-02\"}");

		//System.out.println("shaValue  " + shaValue);
		
		String decData = decryptEncData("N4zYy3nEVFDRl9pEDjSteFOYCsFUo8iBnESro6RaAq0+33bIc3+TubLbAJNV3x0dWCG/JbLWRoiyBuePALlRH8KXza+krFBXrcQ1PckbDME=");

		System.out.println("Decrypted Data " + decData);

	}




public static String generateSHA256Hash(String sValue) throws Exception
	{
		//log.debug("Start : generateSHA256Hash");
		String sHashedValue = "";
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update((sValue).getBytes());
			byte byteData[] = md.digest();
			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			int iSize = byteData.length;
			for(int i = 0; i < iSize; i++)
			{
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			sHashedValue = sb.toString();
			// byte[] hash = md.digest(sValue.getBytes());
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		finally
		{
			//log.debug("End : generateSHA256Hash");
		}
		return sHashedValue;
	}
}
