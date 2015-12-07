package com.techelevator;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class LoanTest {

	@Test
	public void loan_can_be_created() {
		
		Loan newLoan = new Loan(1, 124, "Aerator", 11/7/2015, 11/14/2015, "John", "Doe", "440-123-4567", "RT12345");
	
		
		assertEquals(expectedLoanInfo, calculation.getLoan());
	}

}
