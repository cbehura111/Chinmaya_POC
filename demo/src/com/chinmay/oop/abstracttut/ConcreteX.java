package com.chinmay.oop.abstracttut;

public class ConcreteX extends AbstractA implements A,C {
	public void foo() {
		System.out.println("ConcreteX : foo");
	}
	public void foobar(){
		System.out.println("ConcreteX : foobar");
	}
}
