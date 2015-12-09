package com.techelevator.toolLibrary.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.techelevator.Loan;
import com.techelevator.Tool;


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
		
		String nextIdSQL = "SELECT nextval('seq_loan_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(nextIdSQL);
		results.next();
		int id = results.getInt(1);
		
		newLoan.setLoanId(id);
		
		
		String insertSQL = "INSERT INTO loan(inventory_id, tool_name, loan_start_date, loan_due_date, loan_end_date, user_first_name, user_last_name, user_phone_num, user_license_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		jdbcTemplate.update(insertSQL, 	
										//newLoan.getLoanId(),
										newLoan.getInventoryId(),
										newLoan.getToolLoaned(),
										newLoan.getDateOfLoan(),
										newLoan.getExpectedReturn(),
										loanEndDate,
										newLoan.getFirstName(),
										newLoan.getLastName(),
										newLoan.getPhoneNumber(),
										newLoan.getDriversLicense()
										//lateFee,
										//maintenanceFee,
										//cleaningFee
										);
		
	//	String updateSQL = "UPDATE tool_inventory SET tool_available = 'f' WHERE inventory_id = ?";
		
	//	jdbcTemplate.update(updateSQL, newLoan.getInventoryId());
	}
	
	
	
	 public Loan getLoanById(int loanId) {
		Loan existingLoan = null;
		String selectSQL = "SELECT * FROM loan WHERE loan_id = ?";
		 
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, loanId);
		while(results.next()) {
			//existingLoan.setLoanId(results.getInt("loan_id"));
			existingLoan.setInventoryId(results.getInt("inventory_id"));
			existingLoan.setFirstName(results.getString("firstName"));
			existingLoan.setLastName(results.getString("lastName"));
			existingLoan.setDateOfLoan(results.getDate("loan_start_date"));
			existingLoan.setExpectedReturn(results.getDate("loan_due_date"));
			existingLoan.setDriversLicense(results.getString("driversLicense"));
			existingLoan.setPhoneNumber(results.getString("phoneNumber"));
			existingLoan.setToolLoaned(results.getString("toolLoaned"));				
		}
		
		 return existingLoan; 
	 }
	
	
	public List<Loan> getListOfLoans(){ //exclude loans that are complete
		List<Loan> loanList = new ArrayList<>();
		Loan existingLoan = new Loan(0, null, null, null, null, null, null, null, null);
		
		String selectSQL = "SELECT * FROM loan WHERE loan_end_date IS NULL";
		
		jdbcTemplate.update(selectSQL);
		 
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL);
		while(results.next()) {
				existingLoan.setLoanId(results.getInt("loan_id"));
				existingLoan.setInventoryId(results.getInt("inventory_id"));
				existingLoan.setFirstName(results.getString("firstName"));
				existingLoan.setLastName(results.getString("lastName"));
				existingLoan.setDateOfLoan(results.getDate("loan_start_date"));
				existingLoan.setExpectedReturn(results.getDate("loan_due_date"));
				existingLoan.setDriversLicense(results.getString("driversLicense"));
				existingLoan.setPhoneNumber(results.getString("phoneNumber"));
				existingLoan.setToolLoaned(results.getString("toolLoaned"));				
		
				loanList.add(existingLoan);
		}
		return loanList;
	}
	
	
	
	public void updateReturnedItem(){
	
		// update tool_inventory.tool_available to 't'
		// update loan.loan_end_date to current_date
		// update loan.late_fee, loan.maintenance_fee, loan.cleaning_fee as needed
	
	}
	
	
	public List<Tool> getListOfAvailableTools(){
		List<Tool> availableToolList = new ArrayList<>();
			
		Tool newTool = new Tool(null, null, 0, 0, 0, null);
		
		String selectSQL = "SELECT tool.tool_id, tool.name, tool.tool_category_id, tool.description, tool.loan_period_in_days, tool_category.name as tool_category_name FROM tool INNER JOIN tool_inventory ON tool.tool_id = tool_inventory.tool_id inner join tool_category on tool.tool_category_id = tool_category.tool_category_id WHERE tool_available = 'T'";
		
	//	jdbcTemplate.update(selectSQL);
		 
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL);
		while(results.next()) {
			newTool.setToolCategoryId(results.getInt("tool_category_id"));
			newTool.setToolCategoryName(results.getString("tool_category_name"));
			newTool.setToolDescription(results.getString("description"));
			newTool.setToolId(results.getInt("tool_id"));		
			newTool.setToolLoanPeriod(results.getInt("loan_period_in_days"));
			newTool.setToolName(results.getString("name"));
					
			availableToolList.add(newTool);
		}		
		return availableToolList;
	}
	
}
