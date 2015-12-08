package com.techelevator.toolLibrary.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.Loan;
import com.techelevator.toolLibrary.model.LoanDAO;

@Controller
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
	public String loanReturn( @RequestParam("loanId") int loanId,
		     Map<String, Object> model ) {
		Loan loanById = loanDAO.getLoanById(loanId);
		model.put("loanById", loanById);
		return "removeFromLoan"; 
	}
	
	
	@RequestMapping( path= {"/processedReturn"} )
	public String processedReturn() {
		return "redirect:homePage"; 
	}

	
}
