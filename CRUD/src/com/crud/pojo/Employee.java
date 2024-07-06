package com.crud.pojo;

public class Employee {

	private int id;
	private String name,password,email,country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", pass=" + password + ", email=" + email + ", country=" + country
				+ "]";
	}
	
	
}
