package com.capg.mtb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//The @Table annotation specifies the name of the database table to be used for mapping
@Entity
@Table(name="Customers")

public class Customer {
	
	@Id                                                //This annotation specifies the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Instructs database to generate a value for this field automatically.
	private int userId;
	private String customerName;
	private String address;
	private String mobileNumber;
	private String email;
	private String password;
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
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
	
}


