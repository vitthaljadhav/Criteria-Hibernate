package com.iz.zm;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;

import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.iz.zm.entities.DemoTest;
import com.iz.zm.util.HibernateUtil;

public class FetchData {
	public static void main(String[] args) {
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
         DemoTest demoTest = session.get(DemoTest.class, 1);
		 Blob image = demoTest.getProfielPic();
		  InputStream inputStream = image.getBinaryStream();
		  Files.copy(inputStream, Paths.get("output/"+demoTest.getName()+".JPG"), StandardCopyOption.REPLACE_EXISTING);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
