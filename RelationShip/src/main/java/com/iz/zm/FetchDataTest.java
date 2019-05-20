package com.iz.zm;

import org.hibernate.Session;

import com.iz.zm.entities.Address;
import com.iz.zm.entities.Student;
import com.iz.zm.util.HibernateUtil;

public class FetchDataTest {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            
		/*	Student student = session.get(Student.class, 1);
			Address address = student.getAddress();
			System.out.println(student);
			System.out.println(address);*/
			
		Address address = session.get(Address.class, 1);
		
		Student student = address.getStudent();
		System.out.println(address);
		System.out.println(student);
		
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
}
