package com.techelevator.toolLibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping( path={"", "/", "/homePage"} )
	public String showHomePage() {
	
		return "homePage";  
	}
}
