package com.waldi.fishingcard.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/statistics")
public class CardStatisticsControler {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fishingInfo(Model model, Principal principal) {

		model.addAttribute("title", "Statystyki");
		model.addAttribute("message", "Ok, jest dobrze.");
		return "statisticsPage";
	}
}
