package com.techelevator.toolLibrary.model;

import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Loan {

	private int loanId;
	private int inventory_id;
	private String toolLoaned;
	private String toolCategoryName;
	private String firstName;
	private String lastName;
	private String driversLicense;
	private String phoneNumber;
	private LocalDate dateOfLoan;
	private LocalDate expectedReturn;
	private LocalDate endDate;
	private double lateFee;
	private double maintenanceFee;
	private double cleaningFee;
	private int toolLoanPeriod;

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

	public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public LocalDate getDateOfLoan() {
		return dateOfLoan;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getToolCategoryName() {
		return toolCategoryName;
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

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public void setDateOfLoan(LocalDate dateOfLoan) {
		this.dateOfLoan = dateOfLoan;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	public double getMaintenanceFee() {
		return maintenanceFee;
	}

	public void setMaintenanceFee(double maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	public double getCleaningFee() {
		return cleaningFee;
	}

	public void setCleaningFee(double cleaningFee) {
		this.cleaningFee = cleaningFee;
	}

	public void setToolCategoryName(String toolCategoryName) {
		this.toolCategoryName = toolCategoryName;
	}

	public void setToolLoanPeriod(int toolLoanPeriod) {
		this.toolLoanPeriod = toolLoanPeriod;
	}
	
	public int getToolLoanPeriod(){
		return toolLoanPeriod;
		
	}
}
