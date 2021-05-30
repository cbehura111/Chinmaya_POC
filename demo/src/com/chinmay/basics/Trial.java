package com.chinmay.basics;

public class Trial{
	
	static int x=5;
	static void print(){
		int y=10;
		System.out.println("\n\nInside print ...");
		System.out.println(x);
		System.out.println(y);
	}
}
	
	class Demo2{
		public static void main(String[] args){
		System.out.println("\n\n\n"+Trial.x);
		Trial.print();
	}
	}
	