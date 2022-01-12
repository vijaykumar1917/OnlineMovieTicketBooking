package com.capg.mtb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
//The @Entity annotation specifies that the class is an entity and is mapped to a database table
//The @Table annotation specifies the name of the database table to be used for mapping
@Entity
@Table(name = "Screens")
public class Screen {
	//This annotation specifies the primary key of the entity
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Instructs database to generate a value for this field automatically.
	private int screenId;
	
	private String screenName;

	private int rowCount;
	private int columnCount;
	
	
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

}
