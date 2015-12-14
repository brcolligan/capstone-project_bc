package com.techelevator.toolLibrary.model;

import java.time.*;

import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;

public class feeCalculator {
private Loan loan;
private Tool tool;
private LocalDate expectedReturn;
private LocalDate endDate;

static final double handToolDailyLateFee = 0.50d;
static final double powerToolDailyLateFee = 1.00d;
static final double dayRentalDailyLateFee = 5.0d;

static final double gasPoweredMaintFee = 5.0d;
static final double cleaningFee = 5.0d;


private double calculateLateFee(LocalDate expectedReturn, LocalDate endDate){
	double lateFee=0d;
	this.expectedReturn =expectedReturn;
	this.endDate = endDate;
	long daysLate = DAYS.between(expectedReturn, endDate);
	
	if (daysLate >0) {
		if(tool.getToolCategory()=="Electric Power Tool") {
			lateFee=(daysLate*powerToolDailyLateFee);
		} else if (tool.getToolCategory()=="Gasoline Power Tool") {
			lateFee=daysLate*powerToolDailyLateFee;
		} else if (tool.getToolCategory()=="Hand Tool") {
			lateFee=daysLate*handToolDailyLateFee;
			
		}
	}
	return lateFee;
}   // ONE DAY late period tools: 
}