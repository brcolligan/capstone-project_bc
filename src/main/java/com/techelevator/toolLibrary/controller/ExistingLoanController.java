package com.techelevator.toolLibrary.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.toolLibrary.model.FeesCalculator;
import com.techelevator.toolLibrary.model.Loan;
import com.techelevator.toolLibrary.model.LoanDAO;
import com.techelevator.toolLibrary.model.Tool;

@Controller
@Transactional
public class ExistingLoanController {	
	private LoanDAO loanDAO;
	
	@Autowired
	public ExistingLoanController(LoanDAO LoanDAO) {
		this.loanDAO = LoanDAO;		
	}
	
	@RequestMapping( path={"/existingLoans"} )
	public String existingLoans (Map<String, Object> model) {
		List<Loan> loanList = loanDAO.getListOfLoans();
		model.put("loanList", loanList);
		return "existingLoanList";  
	}

	@RequestMapping( path={"/loanReturn"} )
	public String loanReturn( @RequestParam("loanId") int loanId, Map<String, Object> model,
								@RequestParam("cleaningFee") boolean applyCleaningFee
								) {
	
		Loan loanById = loanDAO.getLoanById(loanId);
		double cleaningFee = FeesCalculator.calculateCleaningFee(applyCleaningFee);
		double lateFees = FeesCalculator.calculateLateFees(loanById.getExpectedReturn(),loanById.getEndDate());
		double maintenanceFee = FeesCalculator.calculateMaintenanceFees(loanById.getToolCategoryName());
		
		
		
		LocalDate endDate = LocalDate.now();
		
		model.put("loan", loanById);	
		model.put("cleaningFee", cleaningFee);
		model.put("endDate", endDate);
		loanById.setCleaningFee(cleaningFee);
		loanById.setLateFee(lateFees);
		loanById.setMaintenanceFee(maintenanceFee);
		
		
		return "loanReturn"; 
	}
	
	@RequestMapping( path= {"/processedReturn"} )
	public String processedReturn( @RequestParam("loanId") int loanId,
									@RequestParam("cleaningFee") double cleaningFee,
									@RequestParam("lateFee") double lateFee,
									@RequestParam("maintenanceFee") double maintenanceFee
			) {
		loanDAO.updateReturnedItem(loanId, cleaningFee, lateFee, maintenanceFee);
		return "redirect:/existingLoans";
	}
}
