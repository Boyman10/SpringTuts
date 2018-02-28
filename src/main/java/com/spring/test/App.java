package com.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		// Bean container which can instantiate beans
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/test/beans/beans.xml");


		Person pers = (Person) context.getBean("person");
		pers.setTaxId(666);
		System.out.println(pers);


		Address address2 = (Address)context.getBean("address2");

		System.out.println(address2);


		OffersDAO offersDAO = (OffersDAO)context.getBean("offersDAO");

		// Handling shitty sql or connection ! debug !
		try {
			List<Offer> offers = offersDAO.getOffers();

			for (Offer offer:offers) {

				System.out.println(offer);
			}
			
			Offer offer = offersDAO.getOffer(1);
			
			System.out.println("Should be bob " + offer);
			
			
			
			
			// Creating batches queries :
			List<Offer> myOffers = new ArrayList<Offer>();
			myOffers.add(new Offer("Dave","email@org.ocm","Whatever ..."));
			myOffers.add(new Offer("Bool","sdsdsd@org.ocm","what kind of offer??"));
			myOffers.add(new Offer(0,"Fake","no@org.ocm","not working"));
			
			int[] rvals = offersDAO.create(myOffers);
			
			for(int value: rvals) {
				
				System.out.println("Updated " + value + " rows.");
			}
			
			
			
			
		}catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get DB connection");
		}

		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		// Close the container to avoid resources leak
		((ClassPathXmlApplicationContext)context).close();
	}
}
