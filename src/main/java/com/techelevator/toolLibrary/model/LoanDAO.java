package com.techelevator.toolLibrary.model;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class LoanDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoanDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void save(Loan newLoan) {
		
		String insertSQL = "INSERT INTO loan(loan_id, inventory_id, loan_start_date, loan_due_date, loan_end_date, late_fee, maintenance_fee, cleaning_fee VALUES (nextval('seq_loan_id'), ?, ?, ?, ?, ?, ?, ?;";
	
		jdbcTemplate.update(psc)
	}
	
	
}
