package de.application;


import de.application.demo.ContentInjection;
import de.application.demo.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		context.registerShutdownHook();

		System.out.println("----------------------------------------");
		Demo demo = context.getBean(Demo.class);
		demo.print();

		ContentInjection c = context.getBean(ContentInjection.class);
		c.print();
//		Runtime.getRuntime().addShutdownHook(new Thread(){
//			@Override
//			public void run() {
//				context.close();
//			}
//		});
	}

}
