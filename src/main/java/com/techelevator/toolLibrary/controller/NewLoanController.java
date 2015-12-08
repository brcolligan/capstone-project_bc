package com.techelevator.toolLibrary.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.Tool;
import com.techelevator.toolLibrary.model.LoanDAO;

@Controller
public class NewLoanController {
	
	private LoanDAO loanDAO;
	
	@Autowired
	public NewLoanController(LoanDAO loanDAO) {
		this.loanDAO = loanDAO;
	}

		@RequestMapping( path={"/addTools"} )
		public String showInventoryList(Map <String, Object> model) {
			List <Tool> toolList = loanDAO.getListOfAvailableTools();
			model.put("toolList", toolList);
			return "inventoryList";  
		}
			
		@RequestMapping( path={"/addToCart"} )
		public String addToCart(@RequestParam("toolId") int tool_id) {
			List <Tool> shoppingCart = 
			return "inventoryList";  
		}
		
		
		@RequestMapping( path={"/viewToolLoan"} )
		public String viewLoan() {
			return "loanCheckout";  
		}
		
		
		@RequestMapping( path={"/checkoutTools"} )
		public String processLoan() {
			return "processLoan";  
		}
		
		
		@RequestMapping( path={"/reviewLoan"} )
		public String reviewLoan() {
			return "reviewProcessedLoan";  
		}

		
		@RequestMapping( path={"/homePage"} )
		public String homePage() {
			return "redirect:homePage"; 
		}

	}