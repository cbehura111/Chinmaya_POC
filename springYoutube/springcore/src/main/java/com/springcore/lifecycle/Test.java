package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/lifecycle/lifecycleconfig.xml");

		// for registering shutdown hook for destroy method calling
		context.registerShutdownHook();

//		Samosa s1 = (Samosa) context.getBean("s1");
//		System.out.println(s1+ "\n\n");
//
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++  \n\n");
//
//		Pepsi p1 = (Pepsi) context.getBean("p1");
//		System.out.println(p1);
		
		Example exmp = (Example) context.getBean("exmp");
		System.out.println(exmp);
	}

}
