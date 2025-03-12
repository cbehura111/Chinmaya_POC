package com.chinmaya.code.payment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class EncryptionDecryptionSPGRS {
    public static Logger logger = LogManager.getLogger(EncryptionDecryptionSPGRS.class);

//	final static String encryptionKey ="dcsgbfuy#$@#$%$^f5yi8893789NEP87";
//	final static String ivstring ="8575249666769673";

    final static String encryptionKey ="1203199321052024";
    final static String ivstring ="1203199321052024";

    public static String decryptEncData(String encData) {
        try {
            byte[] secretKeyInByte = encryptionKey.getBytes();

            SecretKeySpec secretkeyspec = new SecretKeySpec(secretKeyInByte, "AES");
            IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretkeyspec, ivparameterspec);

            byte[] encByteArray = Base64.getDecoder().decode(encData.getBytes());

            byte[] cipherText = cipher.doFinal(encByteArray);
            return new String(cipherText);
        } catch (Exception e) {
            logger.error("Exception occurred while decrypting the text:: {}", e);
            return "";
        }

    }

    public static String encrypt(String plainText){
        String characterEncoding = "UTF-8";
        String aesEncryptionAlgorithem = "AES";

        try {

            while (plainText.getBytes().length % 16 != 0) {
                plainText += '\u0020';
            }

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] key = encryptionKey.getBytes(characterEncoding);
            SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
            IvParameterSpec ivparameterspec = new IvParameterSpec(ivstring.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivparameterspec);

            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            return Base64.getEncoder().encodeToString(cipherText);

        } catch (Exception e) {
            logger.error("Exception occurred while encrypting the text:: {}", e);
            return "";
        }
    }

    public static void main(String arg[]) throws Exception {
        String reqString = "{\r\n"
                + "        \"inputType\": \"MOBILE\",\r\n"
                + "        \"inputValue\": \"917709711236\",\r\n"
                + "        \"requestId\": \"BOMMB202411229999\",\r\n"
                + "         \"requestType\":\"fetchCifAdhaarMobPan\"  \r\n"
                + "  }";
        String encData = encrypt(reqString);
        //System.out.println("Encrypted Data = " + encData);

        String decData = decryptEncData("xcL+8QsUleURHlyInaoAZX+qSGWLW+N+31blAH9GDxCj0YdM3F3x1kiLYnHrrMW5st3+4ZvSCNn9hF6FvZsx4Jkim+xJsyDTBAB9g1MkaMHe8uDTL2JeeO1nCZHtrDI3g8L6cPiPMr2kIrii8hYcLNFprHPeO40lvGw5L+50EROxlLXdcxIn0E1XaoqTIcGhD2Ub5ltFfRSiAyYiRuImG0S8WSX4qReTFmKDZLYjHCgopN7YNSfamgunFQepSWZVnU7DgJxZIp6jHCXeHCbnhLsvz0PlizzWwVfLHlL/1QGc8bLBXomA575e/a5bZ61fvSU9FDCYqP+4p+4FTpD/3DmpWIp37auxwPGiSIKtjpvInTxVG4ZZOGQbuPRk0eZMdG+RaCCX70RloRl5eMIFnAWHnM+0UeyiRvolqt/0bX6iejLMSlnriJY/7tZqDy08Y6hTRPLChiASkElrkv+X1+mWfVn5cFUxY3FvHHRz5GufadtSdXyJY7P/qf5SZ7HriW2CiSsbx0Waz5EnfFT1uys+ktQzDTQ+SkYJ3skAslnrKCvBo3uY7PC1H+fhqWkAyB7Mbz3ZUnqpYrVmwPGL/D9kpNtcN+b9Asd57BfnmrBz6qwbt5nnDeIa0gtbDllM3JdlbLHV04a8eLEY3FSPBJFYBvflWXmWfXviuYLXuQJtd8YHGFFDoHzMhCKuF/xhvAQxVJum7tKgVWJz7QwyHQ==");

        System.out.println("Decrypted Data " + decData);

    }

}
