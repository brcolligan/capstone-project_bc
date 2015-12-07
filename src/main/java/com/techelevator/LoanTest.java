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
		Loan newLoan = new Loan(1, 124, "Aerator", startDate, dueDate, "John", "Doe", "440-123-4567", "RT12345");
	
		String compareLicense = newLoan.getDriversLicense();
		String compareToolName = newLoan.getToolLoaned();
		String compareFirstName = newLoan.getFirstName();
		String compareLastName = newLoan.getLastName();
		String comparePhoneNum = newLoan.getPhoneNumber();
		int compareInvId = newLoan.getInventoryId();
		int compareLoanId = newLoan.getloanId(); 
		Date compareStartDate = newLoan.getDateOfLoan();
		Date compareDueDate = newLoan.getExpectedReturn();
		
		Loan compareLoan = new Loan(compareLoanId, compareInvId, compareToolName, compareStartDate, compareDueDate, compareFirstName, compareLastName, comparePhoneNum, compareLicense);
		
		assertEquals(newLoan.getToolLoaned(), compareLoan.getToolLoaned());
		assertEquals(newLoan.getDriversLicense(), compareLoan.getDriversLicense());
	}

}
