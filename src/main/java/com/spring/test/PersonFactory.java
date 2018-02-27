package com.spring.test;

public class PersonFactory {

	public Person createPerson(int id,String name) {
		
		System.out.println("Using GFactory to create Person");
		return new Person(id,name);
	}
}
