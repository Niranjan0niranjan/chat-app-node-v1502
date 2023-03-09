package com.example.learnspringframework.helloWorld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		try (//1: Launch a Spring Context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//3: Retrieving beans managed by Spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean(Person.class));
			
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("person5Qualifier"));
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2: Configure the things that we want Spring to manage 
		//HellowWOrldConfiguration-@configuration
		//name - @Bean

		
	}
}
