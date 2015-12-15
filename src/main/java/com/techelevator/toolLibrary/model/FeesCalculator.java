package com.techelevator.toolLibrary.model;

import java.time.*;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;

public class FeesCalculator {
	private Loan loan;
	private Tool tool;
	private LocalDate expectedReturn;
	private LocalDate endDate;
	static final double handToolDailyLateFee = 0.50d;
	static final double powerToolDailyLateFee = 1.00d;
	static final double dayRentalDailyLateFee = 5.0d;
	static final double gasPoweredMaintFee = 2.0d;
	static final double cleaningFee = 0.0d; // librarian discretion.
	double totalFees = 0d;

	public double calculateFees(LocalDate expectedReturn, LocalDate endDate, double cleaningFee) {
		this.expectedReturn = expectedReturn;
		this.endDate = endDate;
		long daysLate = DAYS.between(expectedReturn, endDate);

		if (daysLate > 0) {
			if (tool.getToolCategoryName() == "Electric Power Tool") {
				totalFees = (daysLate * powerToolDailyLateFee) + cleaningFee;
			} else if (tool.getToolCategoryName() == "Gasoline Power Tool") {
				totalFees = (daysLate * powerToolDailyLateFee) + gasPoweredMaintFee + cleaningFee;
			} else if (tool.getToolCategoryName() == "Hand Tool") {
				totalFees = (daysLate * handToolDailyLateFee) + cleaningFee;
			}
		} else {
			totalFees = 0 + cleaningFee;
		}

		return totalFees;
	}
}