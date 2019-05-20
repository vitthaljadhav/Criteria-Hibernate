package com.iz.zm;

import org.hibernate.Session;

import com.iz.zm.entities.DemoTest;
import com.iz.zm.util.HibernateUtil;

public class UniqueConstraintDemo {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			DemoTest demoTest = new DemoTest();
			demoTest.setName("sachin");
			demoTest.setGender("male");
			demoTest.setIbsn("9988776556-554433");
			demoTest.setEmail("jadhav.vitthal25@gmail.com");
			demoTest.setPassport("airglow");

			DemoTest demoTest1 = new DemoTest();
			demoTest1.setName("sachin");
			demoTest1.setGender("male");
			demoTest1.setIbsn("9988776556s-554433");
			demoTest1.setEmail("jadhav.vitthaal25@gmail.com");
			demoTest1.setPassport("airglow");
			
			session.beginTransaction();
			session.save(demoTest1);
			session.save(demoTest);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
