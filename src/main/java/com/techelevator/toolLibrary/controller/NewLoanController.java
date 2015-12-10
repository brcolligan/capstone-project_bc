package com.techelevator.toolLibrary.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.toolLibrary.model.LoanDAO;
import com.techelevator.toolLibrary.model.Tool;

@Controller
@SessionAttributes

public class NewLoanController {
	
	private LoanDAO loanDAO;
	
	List<Tool> shoppingCart = new ArrayList <>();
	
	
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
			
		
		@RequestMapping( path={"/addToCart"})
		public String addToCart(@RequestParam("toolInventoryId") int toolInventoryId, HttpSession session) {
			
			session.setAttribute("shoppingCart", shoppingCart);
			Tool addedTool = loanDAO.getToolByInventoryId(toolInventoryId);
			shoppingCart.add(addedTool);
			
			
			
			
			return "cartView";  
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