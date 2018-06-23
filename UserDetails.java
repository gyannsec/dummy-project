package com.projname.model;

import java.io.Serializable;


public class UserDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String name;
	private String mobileno;
	private String dob;
	private String gender;
	private String[] hobby;
	private String hobbyString;
	private String country;
	private String address;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getHobbyString() 
	{
		return hobbyString;
	}
	
	public void setHobbyString(String hobbyString) {
		this.hobbyString = hobbyString;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) 
	{
		String h = "";
		for(String s : hobby)
			h = h + s + " ";
		
		this.hobby = hobby;
		hobbyString = h;
	}
		
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}