package com.chinmay.concurrency;

public class MyFirstThread2 extends Thread {
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

	public static void main(String[] args) {
		Thread thread2 = new MyFirstThread2();
		thread2.start();

		System.out.println("Inside Main...");
	}
}
