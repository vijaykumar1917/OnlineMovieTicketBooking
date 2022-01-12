package com.capg.mtb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//The @Table annotation specifies the name of the database table to be used for mapping
@Entity
@Table(name = "Theatres")
public class Theatre {
	//This annotation specifies the primary key of the entity
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Instructs database to generate a value for this field automatically.
	private int theatreId;

	private String theatreName;

	private String theatreCity;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "theatreId", referencedColumnName = "theatreId")
	private List<Screen> listOfScreens;

	private String managerName;

	private String managerContact;

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}


	public List<Screen> getListOfScreens() {
		return listOfScreens;
	}

	public void setListOfScreens(List<Screen> listOfScreens) {
		this.listOfScreens = listOfScreens;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

}
