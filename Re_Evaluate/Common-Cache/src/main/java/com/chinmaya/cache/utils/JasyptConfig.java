package com.chinmaya.cache.utils;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.iv.RandomIvGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

	@Bean(name = "jasyptStringEncryptor")
	public StringEncryptor getPasswordEncryptor() {

		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		//String encryptedKeyStr = AppzillonAESUtils.encryptString("key", "3ecR31@1234$#$");
		config.setPassword("3ecR31@1234$#$");

		config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
		config.setIvGenerator(new RandomIvGenerator());
		config.setKeyObtentionIterations("1000");
		config.setPoolSize("1");
		config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
		config.setStringOutputType("base64");

		encryptor.setConfig(config);

		return encryptor;
	}

	public static void main(String[] args) {
		String decryptedPassword;
		try {
			JasyptConfig jasyptConfig = new JasyptConfig();
			StringEncryptor encryptor =  jasyptConfig.getPasswordEncryptor();
			//decryptedPassword = encryptor.encrypt("password");
			System.out.println(encryptor.encrypt("`"));
			//System.out.println(encryptor.encrypt("APPZILLONCB"));

			// decryptedPassword = encryptor.decrypt("x9nWTodmTJvkgcOGbjZAZD45E0s6sX3NsCuxyJDWkfbTkEy5CfZU6MRXyyc/BgX3");
			// System.out.println(decryptedPassword);
			 

		} catch (Exception e) {
			// TODOAuto-generated catch block
			e.printStackTrace();
		}
	}
}
