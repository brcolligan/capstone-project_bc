package com.techelevator.toolLibrary.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Tool {

	private String toolName;
	private String toolDescription;
	private int toolLoanPeriod;
	private int toolId;
	private int toolCategoryId;
	private String toolCategoryName;
	private int toolInventoryId;
	private String toolClientId;

	public Tool(String toolName, String toolDescription, int toolLoanPeriod, int toolId,
		int toolCategoryId, String toolCategoryName, int toolInventoryId) {
		
		this.toolName = toolName;
		this.toolDescription = toolDescription;
		this.toolLoanPeriod = toolLoanPeriod;
		this.toolId = toolId;
		this.toolCategoryId = toolCategoryId;
		this.toolCategoryName = toolCategoryName;
		this.setToolInventoryId(toolInventoryId);
		this.setToolClientId(toolClientId);
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

	public LocalDate getToolDueDate() throws ParseException {
		LocalDate today = LocalDate.now();
		LocalDate toolDueDate = today.plusDays(toolLoanPeriod);
		return toolDueDate;
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

	public int getToolInventoryId() {
		return toolInventoryId;
	}

	public void setToolInventoryId(int toolInventoryId) {
		this.toolInventoryId = toolInventoryId;
	}

	public String getToolClientId() {
		return toolClientId;
	}

	public void setToolClientId(String toolClientId) {
		this.toolClientId = toolClientId;
	}
}
