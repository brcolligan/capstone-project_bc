package com.techelevator;

import java.util.Date;


public class ShoppingCartItem {
	
	private int toolId;
	private Date dateLoaned;

	
	public ShoppingCartItem (int toolId, Date dateLoaned) {
		this.toolId = toolId;
		this.dateLoaned = dateLoaned;
	}
	
	public int getToolId() {
		return toolId;
	}
	
	public Date getDateLoaned() {
		return dateLoaned;
	}
	
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	
	public void setDateLoaned(Date dateLoaned) {
		this.dateLoaned = dateLoaned;
	}
	
}
