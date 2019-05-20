/**
 * 
 */
package com.iz.zm;

import java.sql.Statement;

import org.hibernate.Session;

import com.iz.zm.entities.DemoTest;
import com.iz.zm.util.HibernateUtil;

/**
 * @author INTEL
 *
 */
public class SaveEntityData {

	public static void main(String[] args) {
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			DemoTest demoTest = session.byId(DemoTest.class).load(1);
			session.doWork(connection -> {
				try {
					Statement statement = connection.createStatement();
                   statement.executeUpdate("update DemoTest set name=UPPER(name)");
                 
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			  //session.refresh(demoTest);
              System.out.println(demoTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
