package com.iz.zm;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.iz.zm.entities.DemoTest;
import com.iz.zm.util.HibernateUtil;

public class EvitEntityDemo {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			DemoTest demoTest = session.get(DemoTest.class, 1);
			System.out.println(demoTest.getName());
			session.evict(demoTest);
			System.out.println("---------------------------------------------------------");
           DemoTest demoTest2 = session.get(DemoTest.class,1);
			System.out.println(demoTest.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
