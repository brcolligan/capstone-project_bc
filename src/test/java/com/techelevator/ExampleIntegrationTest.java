package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.toolLibrary.model.LoanDAO;

/* Integration tests should extend com.techelevator.IntegrationTestBase.  This super-class
 * takes care of all of the Spring configuration and JDBC connection management. */
public class ExampleIntegrationTest extends IntegrationTestBase {

	/* by extending com.techelevator.IntegrationTestBase, this test is Spring-enabled. 
	 * So, we can inject dependencies using the @Autowired annotation. */
	@Autowired 
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	@Autowired 
	private LoanDAO dao;
	
	
	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void dependencies_are_injected_by_Spring() {
		assertNotNull(dataSource);
	}
	
	
	@Test
	public void database_connectivity_works() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT 1 AS value");
		results.next();
		assertEquals(1, results.getInt("value"));
	}
	
	@Test
	public void loan_records_can_be_saved_and_found() {
		Date startDate = new Date();
		Date dueDate = new Date();
		Date endDate = new Date();
		
		Loan expectedLoan = new Loan();
		
		expectedLoan.setDateOfLoan(startDate);
		expectedLoan.setEndDate(endDate);
		expectedLoan.setExpectedReturn(dueDate);
		expectedLoan.setDriversLicense("RT98765");
		expectedLoan.setFirstName("John");
		expectedLoan.setInventoryId(13);
		expectedLoan.setLastName("Smith");
		expectedLoan.setPhoneNumber("4409876543");
		expectedLoan.setToolLoaned("House Broom");

			dao.saveLoanItem(expectedLoan);
			int loanId = expectedLoan.getLoanId();
			
			Loan resultLoan = dao.getLoanById(loanId);
		
			assertNotNull(resultLoan);
			assertEquals(expectedLoan.getInventoryId(), resultLoan.getInventoryId());
			assertEquals(expectedLoan.getFirstName(), resultLoan.getFirstName());
			assertEquals(expectedLoan.getToolLoaned(), resultLoan.getToolLoaned());
		
	}	
}
