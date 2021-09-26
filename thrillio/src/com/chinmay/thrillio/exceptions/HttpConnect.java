package com.chinmay.thrillio.exceptions;

import java.io.FileNotFoundException;

public class HttpConnect {
	public static void send(int destination, String data, String partner) throws FileNotFoundException {
		System.out.println("\n Inside Send...");

		if (destination == 0) {
			throw new FileNotFoundException();
		}
		System.out.println("\n End of Send...");
	}
}
