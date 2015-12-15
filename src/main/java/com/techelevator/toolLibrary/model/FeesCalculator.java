package com.techelevator.toolLibrary.model;

import java.time.*;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;

public class FeesCalculator {
	private Loan loan;
	private static Tool tool;
	private LocalDate expectedReturn;
	private LocalDate endDate;
	private static final double handToolDailyLateFee = 0.50d;
	private static final double powerToolDailyLateFee = 1.00d;
	private static final double dayRentalDailyLateFee = 5.0d;
	private static final double gasPoweredMaintFee = 2.0d;
	private double cleaningFee = 0.0d; // librarian discretion.
	static double lateFees = 0.0d;

	
	public static double calculateCleaningFee(boolean applyCleaningFee) {
		if (applyCleaningFee) {
			return 5.0;
		} else {
			return 0.0;
		}
	}

	public double calculateMaintenanceFees(String toolCategoryName) {
		if (toolCategoryName == "Gasoline Power Tool") {
			return gasPoweredMaintFee;
		} else {
			return 0.0;
		}
	}

	public static double calculateLateFees(LocalDate expectedReturn, LocalDate endDate) {

		long daysLate = DAYS.between(expectedReturn, endDate);

		if (daysLate > 0 && tool.getToolLoanPeriod() == 1) {
			lateFees += daysLate * dayRentalDailyLateFee;
		}

		if (daysLate > 0) {
			if (tool.getToolCategoryName() == "Electric Power Tool"||tool.getToolCategoryName()=="Gasoline Power Tool") {
				lateFees += (daysLate * powerToolDailyLateFee);
			} else if (tool.getToolCategoryName() == "Hand Tool") {
				lateFees += (daysLate * handToolDailyLateFee);
			}
		} return lateFees;
	}

}
