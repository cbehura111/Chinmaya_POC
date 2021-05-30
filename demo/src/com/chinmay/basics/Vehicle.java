package com.chinmay.basics;

//Example of Abstract Class
abstract class Vehicle {
	
	int Tyre;
	abstract void start();
}

class Car extends Vehicle{
	
	void start() {
		System.out.println("Car Starts with Keys");
	}
}

class Bike extends Vehicle{
	
	void start() {
		System.out.println("Bike Starts with Kick");
	}
	public static void main(String[] args) {
		//Vehicle v= new Vehicle();
		Car c= new Car();
		c.start();
		Bike b=new Bike();
		b.start();
	}
}