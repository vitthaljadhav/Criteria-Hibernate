package com.iz.zm;

import org.hibernate.Session;

import com.iz.zm.entities.Address;
import com.iz.zm.entities.Phone;
import com.iz.zm.entities.Student;
import com.iz.zm.util.HibernateUtil;

public class ClintTest {
	public static void main(String[] args) {
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession();

			Address address1 = new Address();
			address1.setCity("pune");
			address1.setStreet("Xyz");
			address1.setPhones(Phone.MOBILE);
			
			
			Address address2 = new Address();
			address2.setCity("mUMNBAI");
			address2.setStreet("WRREVVE");
			address2.setPhones(Phone.LNADLINE);
			
			Address address3 = new Address();
			address3.setCity("Solapur");
			address3.setStreet("Dear");
			address3.setPhones(Phone.LNADLINE);

			Student student1 = new Student();
			student1.setName("ram");
			student1.setBranch("Computer");
			student1.setRollNo(78);
			
			Student student2 = new Student();
			student2.setName("Ravi");
			student2.setBranch("IT");
			student2.setRollNo(25);
			

			student1.getAddress().add(address2);
			student2.getAddress().add(address1);
            student2.getAddress().add(address3);
            
            
            session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
