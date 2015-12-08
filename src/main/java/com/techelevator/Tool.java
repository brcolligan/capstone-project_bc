package com.techelevator;

public class Tool {
	
	private String toolName;
	private String toolDescription;
	private int toolLoanPeriod;
	private int toolId;
	private int toolCategoryId;
	private String toolCategoryName;

		
	public Tool (String toolName, String toolDescription, int toolLoanPeriod, int toolId, int toolCategoryId, String toolCategoryName) {
		this.toolName = toolName;
		this.toolDescription = toolDescription;
		this.toolLoanPeriod = toolLoanPeriod;
		this.toolId = toolId;
		this.toolCategoryId = toolCategoryId;
		this.toolCategoryName = toolCategoryName;
	}
	public int getToolId() {
		return toolId;
	}
	public String getToolName() {
		return toolName;
	}
	public String getToolDescription() {
		return toolDescription;
	}
	public int getToolLoanPeriod() {
		return toolLoanPeriod;
	}
	public int getToolCategoryId() {
		return toolCategoryId;
	}
	public String getToolCategoryName() {
		return toolCategoryName;
	}
	
	
	
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	
	public void setToolDescription(String toolDescription) {
		this.toolDescription = toolDescription;
	}
	
	public void setToolLoanPeriod(int toolLoanPeriod) {
		this.toolLoanPeriod = toolLoanPeriod;
	}
	
	public void setToolCategoryId(int toolCategoryId) {
		this.toolCategoryId = toolCategoryId;
	}
	
	public void setToolCategoryName(String toolCategoryName) {
		this.toolCategoryName = toolCategoryName;
	}
	
	
}
