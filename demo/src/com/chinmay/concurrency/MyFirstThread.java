package com.chinmay.concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();

		try {
			Thread.sleep(10000);
//			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Execption detected...");
			e.printStackTrace();
		}

		System.out.println("Inside Main...");
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside Run...");
		go();
	}

	private void go() {
		System.out.println("Inside Go...");
		more();
	}

	private void more() {
		System.out.println("Inside More...");
	}

}
