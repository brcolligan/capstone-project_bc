package com.techelevator;

import java.util.Date;

public class Loan {
	
	private int loanId;
	private int inventory_id;
	private String toolLoaned;
	private String firstName;
	private String lastName;
	private String driversLicense;
	private String phoneNumber;
	private Date dateOfLoan;
	private Date expectedReturn;
	
	
	public Loan (int loanId, int inventory_id, String toolLoaned, Date dateOfLoan, Date expectedReturn, String firstName, String lastName, String phoneNumber, String driversLicense) {
		this.loanId = loanId;
		this.inventory_id = inventory_id;
		this.toolLoaned = toolLoaned;
		this.expectedReturn = expectedReturn;
		this.dateOfLoan = dateOfLoan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.driversLicense = driversLicense;
	}
	
	public int getloanId() {
		return loanId;
	}
	
	public int getInventoryId() {
		return inventory_id;
	}
	
	public String getToolLoaned() {
		return toolLoaned;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDriversLicense() {
		return driversLicense;
	}
	public Date getExpectedReturn() {
		return expectedReturn;
	}
	public Date getDateOfLoan() {
		return dateOfLoan;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

}
