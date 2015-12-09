package com.techelevator.toolLibrary.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ShoppingCartItem;
import com.techelevator.Tool;

import com.techelevator.toolLibrary.model.LoanDAO;

@Controller
public class NewLoanController {
	
	private LoanDAO loanDAO;
	public List<ShoppingCartItem> shoppingCart = new ArrayList <>();
	
	@Autowired
	public NewLoanController(LoanDAO loanDAO) {
		this.loanDAO = loanDAO;
	}

		@RequestMapping( path="/addTools")
		public String showInventoryList(Map <String, Object> model) {
			
			List <Tool> toolList = loanDAO.getListOfAvailableTools();
			model.put("toolList", toolList);
			return "inventoryList";  
		}
			
		@RequestMapping( path={"/addToCart"} )
		public String addToCart(@RequestParam("toolId") int toolId, Map<String, Object> model) {
			Date dateLoaned = null;
			ShoppingCartItem newShoppingCartItem = new ShoppingCartItem(toolId,dateLoaned);
			shoppingCart.add(newShoppingCartItem);
			model.put("shoppingCart", shoppingCart);
			return "redirect:inventoryList";  
		}
		
		@RequestMapping( path={"/viewCart"} )
		public String viewLoan() {
			return "cartView";  
		}
		@RequestMapping( path={"/removeFromCart"} )
		public String removeFromCart(@RequestParam("toolId") int toolId, Map<String, Object> model) {
			return "cartView";  
		}
		
		
		@RequestMapping( path={"/checkoutTools"} )
		public String processLoan() {
			return "loanProcess";  
		}
		
		
		@RequestMapping( path={"/reviewLoan"} )
		public String reviewLoan() {
			return "processedLoanReview";  
		}

		
		@RequestMapping( path={"/homePage"} )
		public String homePage() {
			return "redirect:homePage"; 
		}

	}