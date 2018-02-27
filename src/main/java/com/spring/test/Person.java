package com.spring.test;

public class Person {

	private int id;
	private String name;
	private int taxId;
	
	private Address address;
	
	public Person() {
		
		
	}
	public Person(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	// Factory method
	public static Person getInstance(int id, String name) {
		
		System.out.println("Creating factory method");
		return new Person(id,name);
	}
	
	public void speak() {
		
		System.out.println("Hello Spring");
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", address=" + address + "]";
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}


	
	
}
