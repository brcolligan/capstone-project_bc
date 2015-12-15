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
	
	
	
	public static double calculateCleaningFee(boolean applyCleaningFee) {
		if (applyCleaningFee) {
			return 5.0;
		} else {
			return 0.0;
		}
	}
	
	public static double calculateMaintenanceFees(String toolCategoryName) {
		
		String stringToCompare = "Gasoline Power Tool";
		if (toolCategoryName.equals(stringToCompare)) {
			return gasPoweredMaintFee;
		} else {
			return 0.0;
		}
	}

	public static double calculateLateFees(LocalDate expectedReturn, LocalDate endDate, int toolLoanPeriod, String toolCategoryName) {
		double lateFees = 0.0d;
		long daysLate = DAYS.between(expectedReturn, endDate);
		if (daysLate > 0 && toolLoanPeriod == 1) {
			lateFees += daysLate * dayRentalDailyLateFee;
		}else if (daysLate > 0) {
			if (toolCategoryName.equals("Electric Power Tool")||toolCategoryName.equals("Gasoline Power Tool")) {
				lateFees += (daysLate * powerToolDailyLateFee);
			} else if (toolCategoryName.equals("Hand Tool")) {
				lateFees += (daysLate * handToolDailyLateFee);
			}
			
		} return lateFees;
	}

}
