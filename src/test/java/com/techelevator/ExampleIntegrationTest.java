package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.toolLibrary.model.Loan;

/* Integration tests should extend com.techelevator.IntegrationTestBase.  This super-class
 * takes care of all of the Spring configuration and JDBC connection management. */
public class ExampleIntegrationTest extends IntegrationTestBase {

	/* by extending com.techelevator.IntegrationTestBase, this test is Spring-enabled. 
	 * So, we can inject dependencies using the @Autowired annotation. */
	@Autowired private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
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
		Loan expectedLoan = new Loan(5, 0, null, null, null, null, null, null, null, null);
		
		Loan resultLoan = new Loan(0, 0, null, null, null, null, null, null, null, null);
			
		
		
		assertEquals(resultLoan, expectedLoan);
	}
	
	
}
