package com.techelevator.toolLibrary.model;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.Date;
import com.techelevator.Loan;


@Component
public class LoanDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public LoanDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void saveLoanItem(Loan newLoan) {
		
		Date loanEndDate=null;
		Double lateFee = 0d;
		Double maintenanceFee = 0d;
		Double cleaningFee = 0d;
		
		String insertSQL = "INSERT INTO loan(loan_id, inventory_id, tool_loaned, loan_start_date, loan_due_date, loan_end_date, first_name, last_name, phone_number, license_num, late_fee, maintenance_fee, cleaning_fee VALUES (nextval('seq_loan_id'), ?, ?, ?, ?, ?, ?, ?;";
	
		jdbcTemplate.update(insertSQL, newLoan.getInventoryId(),
										newLoan.getDateOfLoan(),
										newLoan.getExpectedReturn(),
										loanEndDate,
										newLoan.getFirstName(),
										newLoan.getLastName(),
										newLoan.getPhoneNumber(),
										newLoan.getDriversLicense(),
										lateFee,
										maintenanceFee,
										cleaningFee);						
	}
	
	
	 public Loan getLoanById(int loanId) {
		Loan queriedLoan = null;
		String selectSQL = "SELECT user_first_name || ' ' || user_last_name as customer_name,t.name as tool_name,l.loan_start_date,l.loan_due_date,l.inventory_id, l.loan_id FROM loan l INNER JOIN tool_inventory ti on l.inventory_id = ti.tool_inventory_id INNER JOIN tool t on ti.tool_id = t.tool_id WHERE loan_id = ?;";
		
		jdbcTemplate.update(selectSQL, loanId);
		 
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, loanId);
		if(results.next()) {
				loanId = results.getInt("loan_id");
				int inventory_id = results.getInt("inventory_id");
				//int tool_id = results.getInt("tool_id");
				//String toolLoaned = results.getString("name");
				Date startDate = results.getDate("loan_start_date");
				Date dueDate = results.getDate("loan_due_date");		
		}
		
		 return queriedLoan; 
	 }
	
	
	//public getListOfLoans(){ //exclude loans that are complete
	//}
	
	
	
	//public updateReturnedItem(){
	//}
	
	
	//public getListOfAvailableTools(){
	//}
	
	
	
	// query fee info???
	
	
}
