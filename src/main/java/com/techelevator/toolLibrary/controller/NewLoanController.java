package com.techelevator.toolLibrary.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.toolLibrary.model.LoanDAO;
import com.techelevator.toolLibrary.model.Tool;

@Controller

public class NewLoanController {
	
	private LoanDAO loanDAO;
	
	
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
			
			Tool addedTool = loanDAO.getToolByInventoryId(toolInventoryId);
			
			if (session.getAttribute("shoppingCart") == null)  {
				session.setAttribute("shoppingCart", new ArrayList <>());
			}
				((List<Tool>) session.getAttribute("shoppingCart")).add(addedTool);
			
			return "cartView";  
		}
		
		
		@RequestMapping( path={"/viewCart"} )
		public String viewLoan() {
			return "cartView";  
			
			
		}
		@RequestMapping( path={"/removeFromCart"} )
		public String removeFromCart(@RequestParam("toolInventoryId") int toolInventoryId, HttpSession session) {
			Tool addedTool = loanDAO.getToolByInventoryId(toolInventoryId);
			((List<Tool>) session.getAttribute("shoppingCart")).remove(addedTool);
			return "cartView";  
		}
		
		
		@RequestMapping( path={"/checkoutTools"} )
		public String processLoan(HttpSession session) {
			
			//accept form submission
			//change value of tool_inventory.inventory_availability
			//insert new loan row in DB
			
			session.invalidate();
			
			return "loanProcess";  
		}
		
		@RequestMapping( path={"/reviewLoan"} )
		public String reviewLoan() {
			return "redirect: homePage";  
		}



	}