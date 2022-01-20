package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting Pepsi Price...");
		this.price = price;
	}

	public Pepsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}
	
//	public void start() {
//		System.out.println("Inside start Method");
//	}
//
//	public void end() {
//		System.out.println("Inside end Method");
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Opening Pepsi Bottle");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Throw Pepsi Bottle");
		
	}
}
