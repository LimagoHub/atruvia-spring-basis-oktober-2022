package de.application;


import de.application.demo.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		System.out.println("----------------------------------------");
		Demo demo = context.getBean(Demo.class);
		demo.print();


	}

}
