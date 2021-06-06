package com.chinmay.oop.abstracttut;

public class TestClient {
public static int Val=60;//() {
	//return 86;
//}

public static void main(String[] args) {
	A a = new ConcreteX();
	C c = new ConcreteX();
	c.foo();
	c.bar();
	c.foobar();
}
}