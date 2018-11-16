package com.waldi.fishingcard.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	   @RequestMapping(method = RequestMethod.GET)
	   public String adminPage(Model model) {
		   model.addAttribute("title", "Admin");
	       return "adminPage";
	   }
	   
		 @RequestMapping(value = "/settingsPages",method = RequestMethod.GET)
		   public String cardSettings(Model model, Principal principal) {
		 
			// System.out.println("Uruchomi³ sie cardSettings !!!");
		       model.addAttribute("title", "Ustawienia kart");
		       return "cardSetting";
		   }
}
