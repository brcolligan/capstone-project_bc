package com.techelevator.toolLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewLoanController {

		@RequestMapping( path={"", "/", "/addTools"} )
		public String showInventoryList() {	
			return "inventoryList";  
		}
			
		
		@RequestMapping( path={"", "/", "/viewToolLoan"} )
		public String viewLoan() {
			return "loanCheckout";  
		}
		
		
		@RequestMapping( path={"", "/", "/checkoutTools"} )
		public String processLoan() {
			return "processLoan";  
		}
		
		
		@RequestMapping( path={"", "/", "/reviewLoan"} )
		public String reviewLoan() {
			return "reviewProcessedLoan";  
		}

		
		@RequestMapping( path={"", "/", "/homePage"} )
		public String homePage() {
			return "redirect:homePage"; 
		}

	}