package com.iz.zm;

import org.hibernate.Session;

import com.iz.zm.entities.Customer;
import com.iz.zm.util.HibernateUtil;

public class CustmerClientTest {

	public static void main(String[] args) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Customer customer1 = new Customer();
			customer1.setId("abc");
			customer1.setAddress("pune");
			customer1.setEmail("jadhav.vitthal25@gmail.com");
			customer1.setFname("vitthal");
			customer1.setLname("jadhav");
			customer1.setGender("male");

			Customer customer2 = new Customer();
			customer2.setId("kbc");
			customer2.setAddress("Mumbai");
			customer2.setEmail("jadhav@gmail.com");
			customer2.setFname("amol");
			customer2.setLname("surwase");
			customer2.setGender("male");

			Customer customer3 = new Customer();
			customer3.setId("aaa");
			customer3.setAddress("solapur");
			customer3.setEmail("sachin@gmail.com");
			customer3.setFname("pranali");
			customer3.setLname("patil");
			customer3.setGender("female");

			Customer customer4 = new Customer();
			customer4.setId("aass");
			customer4.setAddress("solapur");
			customer4.setEmail("sachin@gmail.com");
			customer4.setFname("pranali");
			customer4.setLname("patil");
			customer4.setGender("female");

			session.beginTransaction();

			session.save(customer1);
			session.save(customer2);
			session.save(customer3);
			session.save(customer4);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
