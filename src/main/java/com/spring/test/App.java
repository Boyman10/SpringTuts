package com.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// Bean container which can instantiate beans
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/test/beans/beans.xml");
		
		
		Person pers = (Person) context.getBean("person");
		pers.setTaxId(666);
		System.out.println(pers);
		
		
		Address address2 = (Address)context.getBean("address2");
		
		System.out.println(address2);
		
		
		OffersDAO offersDAO = (OffersDAO)context.getBean("OffersDAO");
		List<Offer> offers = offersDAO.getOffers();
		
		for (Offer offer:offers) {
			
			System.out.println(offer);
		}
		
		

		// Close the container to avoid resources leak
		((ClassPathXmlApplicationContext)context).close();
	}
}
