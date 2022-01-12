package com.capg.mtb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//The @Table annotation specifies the name of the database table to be used for mapping
@Entity
@Table(name = "Seats")
public class Seat {
	//This annotation specifies the primary key of the entity
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Instructs database to generate a value for this field automatically.
	private int seatId;
	private String seatNumber;
	private String type;
	private double price;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
