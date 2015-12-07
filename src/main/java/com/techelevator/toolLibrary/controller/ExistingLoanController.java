package com.techelevator.toolLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExistingLoanController {
	
	@RequestMapping( path={"", "/", "/existingLoans"} )
	public String reviewLoan() {
		return "existingLoanList";  
	}

	
	@RequestMapping( path={"", "/", "/loanReturn"} )
	public String loanReturn() {
		return "removeFromLoanPage"; 
	}
	
	
	@RequestMapping( path={"", "/", "/processedReturn"} )
	public String processedReturn() {
		return "redirect:homePage"; 
	}

	
}
