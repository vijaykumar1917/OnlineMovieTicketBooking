package com.capg.mtb.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//The @Table annotation specifies the name of the database table to be used for mapping
//An entity class is essentially an object wrapper for a database table. 
//The attributes of an entity are transformed to columns on the database table
@Entity
@Table(name = "Bookings")
public class Booking {
	//This annotation specifies the primary key of the entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Instructs database to generate a value for this field automatically.
	private int bookingId;
	
	private int showId;
	
	private int userid;
	
	private LocalDate bookingDate;
	
	private int transcationId;
	
	private String transcationMode;
	
	private String transcationStatus;
	
	private double totalCost;
	// It is used to create the one-to-one relationship between the two entities
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticketId", referencedColumnName = "ticketId")//  @JoinColumn annotation to map the foreign key column of a managed association
	private Ticket ticket;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}

	public String getTranscationMode() {
		return transcationMode;
	}

	public void setTranscationMode(String transcationMode) {
		this.transcationMode = transcationMode;
	}

	public String getTranscationStatus() {
		return transcationStatus;
	}

	public void setTranscationStatus(String transcationStatus) {
		this.transcationStatus = transcationStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
}
