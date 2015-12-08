package com.techelevator.toolLibrary.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.Loan;
import com.techelevator.ssgeek.forum.model.Topic;
import com.techelevator.toolLibrary.model.LoanDAO;

@Controller
public class ExistingLoanController {
	
	@RequestMapping( path={"", "/", "/existingLoans"} )
	public String existingLoans (Map<String, Object> model) {
		List<Loan> loanList = LoanDAO.getListOfLoans();
		model.put("loanList", loanList);
		return "existingLoanList";  
	}

	
	@RequestMapping( path={"", "/", "/loanReturn"} )
	public String loanReturn(Map<String, Object> model) {
		List<Loan> loanById = LoanDAO.getLoanById();
		model.put("loanById", loanById); {
		return "removeFromLoanPage"; 
	}
	
	
	@RequestMapping( path={"", "/", "/processedReturn"} )
	public String processedReturn() {
		return "redirect:homePage"; 
	}

	
}
