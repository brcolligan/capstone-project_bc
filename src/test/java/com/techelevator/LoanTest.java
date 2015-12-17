package com.techelevator;

import static org.junit.Assert.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.toolLibrary.model.Loan;
import com.techelevator.toolLibrary.model.LoanDAO;

public class LoanTest extends IntegrationTestBase {

	@Autowired
	private LoanDAO dao;

	@Test
	public void loan_can_be_created() {
		LocalDate startDate = LocalDate.now();
		LocalDate dueDate = startDate.plusDays(7);
		LocalDate endDate = startDate.plusDays(14);
		Loan newLoan = new Loan();

		newLoan.setDateOfLoan(startDate);
		//newLoan.setEndDate(endDate);
		newLoan.setExpectedReturn(dueDate);
		newLoan.setDriversLicense("RT98765");
		newLoan.setFirstName("John");
		newLoan.setInventoryId(13);
		newLoan.setLastName("Doe");
		newLoan.setPhoneNumber("4401234567");
		newLoan.setToolLoaned("House Broom");

		dao.saveLoanItem(newLoan);
		int loanId = newLoan.getLoanId();

		Loan compareLoan = dao.getLoanById(loanId);

		assertEquals(newLoan.getToolLoaned(), compareLoan.getToolLoaned());
		assertEquals(newLoan.getDriversLicense(), compareLoan.getDriversLicense());
		assertEquals(newLoan.getDateOfLoan(), compareLoan.getDateOfLoan());
		assertEquals(newLoan.getExpectedReturn(), compareLoan.getExpectedReturn());
		assertEquals(newLoan.getFirstName(), compareLoan.getFirstName());
		assertEquals(newLoan.getLastName(), compareLoan.getLastName());
		assertEquals(newLoan.getInventoryId(), compareLoan.getInventoryId());
		assertEquals(newLoan.getLoanId(), compareLoan.getLoanId());
		assertEquals(newLoan.getPhoneNumber(), compareLoan.getPhoneNumber());
		//assertEquals(newLoan.getEndDate(), compareLoan.getEndDate());

	}

}
