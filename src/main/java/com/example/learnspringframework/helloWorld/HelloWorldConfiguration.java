package com.example.learnspringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration  
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	}
	

	@Bean
	public int age() {
		return 15;
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}

	@Bean(name = "address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		var address = new Address("Motinagar", "Hydrabad");
		return address;
	}

	@Bean
	public Person person() {
		var person = new Person("Ravi", 20, new Address("Main Street", "London"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), new Address("Baker Street", "London") );
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address3) {
		return new Person(name, age, address3);
	}
	
	@Bean
	public Person person5Qualifier(String name, int age,@Qualifier("address3Qualifier") Address address3) {
		return new Person(name, age, address3);
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		return new Person(name, age, address3);
	}


	
	
}
