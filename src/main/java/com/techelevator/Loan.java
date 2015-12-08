package com.techelevator;

import java.util.Date;
import java.util.Calendar;

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
	private Date endDate;
	
	
	public Loan (int loanId, int inventory_id, String toolLoaned, Date dateOfLoan, Date expectedReturn, Date endDate, String firstName, String lastName, String phoneNumber, String driversLicense) {
		this.loanId = loanId;
		this.inventory_id = inventory_id;
		this.toolLoaned = toolLoaned;
		this.expectedReturn = expectedReturn;
		this.dateOfLoan = dateOfLoan;
		this.endDate = endDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.driversLicense = driversLicense;
	}
	
	public int getLoanId() {
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
	
	public Date getEndDate() {
		return endDate;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	
	
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	
	public void setInventoryId(int inventory_id) {
		this.inventory_id = inventory_id;
	}
	
	public void setToolLoaned(String toolLoaned) {
		this.toolLoaned = toolLoaned;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDriversLicense(String driversLicense) {
		this.driversLicense = driversLicense;
	}
	
	public void setExpectedReturn(Date expectedReturn) {
		this.expectedReturn = expectedReturn;
	}
	
	public void setDateOfLoan(Date dateOfLoan) {
		this.dateOfLoan = dateOfLoan;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
