package com.test.gitapi.vo;

import java.util.Date;

public class PersonVO {
	private String name;
	private String email;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", email=" + email + ", date=" + date + "]";
	}
	
}
