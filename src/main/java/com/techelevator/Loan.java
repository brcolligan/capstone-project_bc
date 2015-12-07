package com.techelevator;

import java.util.Date;

public class Loan {
	
	private int loanId;
	private String toolLoaned;
	private String firstName;
	private String lastName;
	private String driversLiscense;
	private String phoneNumber;
	private Date dateOfLoan;
	private Date expectedReturn;
	
	
	public Loan (int loanId, String toolLoaned, Date dateOfLoan, Date expectedReturn, String firstName, String lastName, String phoneNumber, String driversLiscense) {
		this.loanId = loanId;
		this.toolLoaned = toolLoaned;
		this.expectedReturn = expectedReturn;
		this.dateOfLoan = dateOfLoan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.driversLiscense = driversLiscense;
	}
	
	public int getloanId() {
		return loanId;
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
	public String getDriversLiscense() {
		return driversLiscense;
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
