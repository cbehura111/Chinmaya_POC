package com.chinmay.basics;

interface I1 {
	int i=10;
	void show();
}

class Test implements I1{
	
	public void show() {
		System.out.println("Inside git Test Void Show");
	}
	
	public static void main(String[] args) {
		Test T=new Test();
		T.show();
	}
}
