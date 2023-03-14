package com.keval.SpringApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", name=" + name + ", mobileno=" + mobileno + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String email;
	private String name;
	private String mobileno;
	
	public Student() {
	}
	public Student(String email, String name, String mobileno) {
		this.email = email;
		this.name = name;
		this.mobileno = mobileno;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
}
