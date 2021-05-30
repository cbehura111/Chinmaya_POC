package com.chinmay.basics;

public class Employee{
	
	int empid;
	String Name;
	static String compname="IBM";
	static int x=5;
	
	Employee(int id,String name){
		this.empid=id;
		this.empName=name;
	}
	void display(){
		
		System.out.println(empid+"	"+empName+"	"+compname);
	}
	
	public static void main(String[] args) {
		Employee E1= new Employee(101,"Chinmay");
		E1.display();
		Employee E2= new Employee(102,"Abhipsa");
		E2.display();
	}
}
	
	
	