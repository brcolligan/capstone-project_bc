package com.techelevator;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.Calendar;
import org.junit.Test;

public class LoanTest {

	@Test
	public void loan_can_be_created() {
		Date startDate = new Date();
		Date dueDate = new Date();
		Date endDate = new Date();
		Loan newLoan = new Loan(1, 124, "Aerator", startDate, dueDate, endDate, "John", "Doe", "440-123-4567", "RT12345");
	
		String compareLicense = newLoan.getDriversLicense();
		String compareToolName = newLoan.getToolLoaned();
		String compareFirstName = newLoan.getFirstName();
		String compareLastName = newLoan.getLastName();
		String comparePhoneNum = newLoan.getPhoneNumber();
		int compareInvId = newLoan.getInventoryId();
		int compareLoanId = newLoan.getLoanId(); 
		Date compareStartDate = newLoan.getDateOfLoan();
		Date compareDueDate = newLoan.getExpectedReturn();
		Date compareEndDate = newLoan.getEndDate();
		
		Loan compareLoan = new Loan(compareLoanId, compareInvId, compareToolName, compareStartDate, compareDueDate, compareEndDate, compareFirstName, compareLastName, comparePhoneNum, compareLicense);
		
		assertEquals(newLoan.getToolLoaned(), compareLoan.getToolLoaned());
		assertEquals(newLoan.getDriversLicense(), compareLoan.getDriversLicense());
		assertEquals(newLoan.getDateOfLoan(), compareLoan.getDateOfLoan());
		assertEquals(newLoan.getExpectedReturn(), compareLoan.getExpectedReturn());
		assertEquals(newLoan.getFirstName(), compareLoan.getFirstName());
		assertEquals(newLoan.getLastName(), compareLoan.getLastName());
		assertEquals(newLoan.getInventoryId(), compareLoan.getInventoryId());
		assertEquals(newLoan.getLoanId(), compareLoan.getLoanId());
		assertEquals(newLoan.getPhoneNumber(), compareLoan.getPhoneNumber());
		assertEquals(newLoan.getEndDate(), compareLoan.getEndDate());
		
	}

}
