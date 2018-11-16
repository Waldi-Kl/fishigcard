package com.waldi.fishingcard.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waldi.fishingcard.dao.PersonDAO;
import com.waldi.fishingcard.model.Person;
import com.waldi.fishingcard.model.UserInfo;

@Controller
@RequestMapping(value = "/personInfo")
public class PersonController {

	@Autowired
	private PersonDAO personDAO;
	
	@RequestMapping(value = { "/person/{idUser}" }, method = RequestMethod.GET)
	public String personInfo(Model model, @PathVariable("userLog") String userLog) {
	
		return "cps";
	}
	
	@RequestMapping(value = { "/personList"}, method = RequestMethod.GET)
	public String personList(Model model) {
		List<Person> list = null;
		try {
			list = personDAO.getPersonList();
		} catch (Exception e) {

			model.addAttribute("title", "Person");
			model.addAttribute("message", "Nie powodzenie podczas po³¹czenia do bazy!");
			System.out.println("Blad: "+e);
			return "403Page";
		}

		model.addAttribute("title", "Person");
		model.addAttribute("persons", list);
		return "personListPage";
	}
	
	@RequestMapping(value = { "/personList/{name}" }, method = RequestMethod.GET)
	public String personListName(Model model) {
		
		return "cps";
	}
	
	@RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
	public String addPerson(Model model, UserInfo newUser) throws IOException {
		
		return "cps";
	}

	
	@RequestMapping(value = { "/updatePerson" }, method = RequestMethod.POST)
	public String putPerson(Model model, UserInfo myUser) throws IOException {
		
		return "cps";
	}
	
	
}

	