package com.iz.zm.entities;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;


@Entity
//@Table(name="demo_test",uniqueConstraints=@UniqueConstraint(columnNames = { "ibsn","email" },name="uk_demo_test"))
@Table(name="demo_test" , indexes=@Index(name="idex_demo_email_name",columnList = "email,name"))
public class DemoTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int d_id;
	//@ColumnDefault(value = "vitthal bhai")
	private String name;
	@Column(name = "email", nullable = false)
	private String email;
	//@NaturalId
	private String ibsn;
	
	private String passport;
	
	public String getIbsn() {
		return ibsn;
	}

	public void setIbsn(String ibsn) {
		this.ibsn = ibsn;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	private String gender;

	@Lob
	@Column(name = "profile_pic")
	private Blob profielPic;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getProfielPic() {
		return profielPic;
	}

	public void setProfielPic(Blob profielPic) {
		this.profielPic = profielPic;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "DemoTest [d_id=" + d_id + ", name=" + name + ", gender=" + gender + "]";
	}

}
