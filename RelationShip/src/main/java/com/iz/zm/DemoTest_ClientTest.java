package com.iz.zm;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;

import com.iz.zm.entities.DemoTest;
import com.iz.zm.util.HibernateUtil;

public class DemoTest_ClientTest {
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();

			DemoTest demoTest = new DemoTest();
			//demoTest.setName("ravichnadra ashvin");
			demoTest.setGender("Male");
			demoTest.setEmail("vitthalj@izealiant.com");
			session.beginTransaction();
			session.doWork(Connection -> {
				demoTest.setProfielPic(BlobProxy.generateProxy(imageGetting()));
			});

			session.save(demoTest);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static byte[] imageGetting() {
		Path path = Paths.get("input/img1.jpg");
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
