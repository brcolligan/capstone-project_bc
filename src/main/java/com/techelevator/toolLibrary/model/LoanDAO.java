package com.techelevator.toolLibrary.model;

import javax.sql.DataSource;
import static java.sql.Types.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

		String insertSQL = "INSERT INTO loan(loan_id, inventory_id, tool_name, loan_start_date, loan_due_date, user_first_name, user_last_name, user_phone_num, user_license_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
		jdbcTemplate.update(insertSQL,
			    newLoan.getLoanId(),
				newLoan.getInventoryId(),
				newLoan.getToolLoaned(),
				new SqlParameterValue(DATE, newLoan.getDateOfLoan()),
				new SqlParameterValue(DATE, newLoan.getExpectedReturn()),
				newLoan.getFirstName(),
				newLoan.getLastName(),
				newLoan.getPhoneNumber(),
				newLoan.getDriversLicense()
		// lateFee,
		// maintenanceFee,
		// cleaningFee
		);
		
		 String updateSQL = "UPDATE tool_inventory SET tool_available = 'f' WHERE tool_inventory_id = ?";
		
		jdbcTemplate.update(updateSQL, newLoan.getInventoryId());
	}
	
	
	
	 public Loan getLoanById(int loanId) {
		Loan existingLoan = new Loan();
		String selectSQL = "SELECT * FROM loan WHERE loan_id = ?";
		 
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, loanId);
		
		if (results.next()) {
			populateLoanAttributes(existingLoan, results);
		}
		 return existingLoan; 
	 }
	
	
	public List<Loan> getListOfLoans(){ //exclude loans that are complete
		List<Loan> loanList = new ArrayList<>();

		String selectSQL = "SELECT * FROM loan WHERE loan_end_date IS NULL ORDER BY loan_due_date asc, user_last_name asc, user_first_name asc";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL);
		while (results.next()) {
			Loan existingLoan = new Loan();
			populateLoanAttributes(existingLoan, results);			
				loanList.add(existingLoan);
		}
		return loanList;
	}
	
	public void updateReturnedItem(int loanId){
	
		// update tool_inventory.tool_available to 't'
		// update loan.loan_end_date to current_date
		// update loan.late_fee, loan.maintenance_fee, loan.cleaning_fee as
		// needed
	
	
			Date loanEndDate=new Date();
			Double lateFee = 0d;
			Double maintenanceFee = 0d;
			Double cleaningFee = 0d;

			String insertSQL = "UPDATE loan SET loan_end_date = ?, late_fee = ?, maintenance_fee = ?, cleaning_fee = ? WHERE loan_id = ?";
		
			jdbcTemplate.update(insertSQL,
					loanEndDate,
					lateFee,
					maintenanceFee,
					cleaningFee,
					loanId
			);
			
			 String updateSQL = "UPDATE tool_inventory SET tool_available = 't' WHERE tool_inventory_id = ?";
			
			 jdbcTemplate.update(updateSQL, getLoanById(loanId).getInventoryId());
		}
		
	public List<Tool> getListOfAvailableTools() {
	
		Tool foundTool = null;
		
		List<Tool> availableToolList = new ArrayList<>();
		String selectSQL =  "SELECT tool.tool_id as toolId, tool.name as toolName, tool.tool_category_id as toolCategoryId, tool.description as toolDescription, tool.loan_period_in_days as toolLoanPeriod, tool_category.name as toolCategoryName, tool_inventory.tool_inventory_id as toolInventoryId FROM tool INNER JOIN tool_inventory ON tool.tool_id = tool_inventory.tool_id inner join tool_category on tool.tool_category_id = tool_category.tool_category_id WHERE tool_available = 'T' ORDER BY toolName";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL);
		while(results.next()) {
			String toolName = results.getString("toolName");
			String toolDescription = results.getString("toolDescription");
			int toolLoanPeriod = results.getInt("toolLoanPeriod");
			int toolId = results.getInt("toolId");		
			int toolCategoryId = results.getInt("toolCategoryId");
			String toolCategoryName = results.getString("toolCategoryName");
			int toolInventoryId = results.getInt("toolInventoryId");
			
			foundTool = new Tool (toolName, toolDescription, toolLoanPeriod, toolId, toolCategoryId, toolCategoryName, toolInventoryId);
			availableToolList.add(foundTool);
		}		
		return availableToolList;
	}
	
	public Tool getToolByInventoryId(int toolInventoryId) {
		
		Tool foundTool = null;
		String selectSQL = "SELECT tool.tool_id as toolId, tool.name as toolName, tool.tool_category_id as toolCategoryId, tool.description as toolDescription, tool.loan_period_in_days as toolLoanPeriod, tool_category.name as toolCategoryName, tool_inventory.tool_inventory_id as toolInventoryId FROM tool INNER JOIN tool_inventory ON tool.tool_id = tool_inventory.tool_id inner join tool_category on tool.tool_category_id = tool_category.tool_category_id WHERE tool_inventory_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectSQL, toolInventoryId);
		while(results.next()) {
			String toolName = results.getString("toolName");
			String toolDescription = results.getString("toolDescription");
			int toolLoanPeriod = results.getInt("toolLoanPeriod");
			int toolId = results.getInt("toolId");		
			int toolCategoryId = results.getInt("toolCategoryId");
			String toolCategoryName = results.getString("toolCategoryName");
			toolInventoryId = results.getInt("toolInventoryId");
			
			foundTool = new Tool (toolName, toolDescription, toolLoanPeriod, toolId, toolCategoryId, toolCategoryName, toolInventoryId);			
		}
		return foundTool;
	}

	private void populateLoanAttributes(Loan existingLoan, SqlRowSet results) {
		existingLoan.setLoanId(results.getInt("loan_id"));
		existingLoan.setInventoryId(results.getInt("inventory_id"));
		existingLoan.setFirstName(results.getString("user_first_name"));
		existingLoan.setLastName(results.getString("user_last_name"));
		existingLoan.setDateOfLoan(results.getDate("loan_start_date"));
		existingLoan.setExpectedReturn(results.getDate("loan_due_date"));
		existingLoan.setDriversLicense(results.getString("user_license_num"));
		existingLoan.setPhoneNumber(results.getString("user_phone_num"));
		existingLoan.setToolLoaned(results.getString("tool_name"));
		existingLoan.setEndDate(results.getDate("loan_end_date"));
	}
}

