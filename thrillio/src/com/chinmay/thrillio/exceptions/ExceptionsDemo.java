package com.chinmay.thrillio.exceptions;

import java.io.FileNotFoundException;

public class ExceptionsDemo {

	public static void main(String[] args) {

		System.out.println("\n Inside Main Method...");
		Share();
		System.out.println("\n End of Main Method...");
	}

	private static void Share() {
		System.out.println("\n Inside Share Method...");

		try {
			HttpConnect.send(0

					, "Hello", "www.google.com");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n End of Share Method...");
	}

}
