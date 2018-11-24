package com.waldi.fishingcard.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waldi.fishingcard.dao.UserInfoDAO;
import com.waldi.fishingcard.dao.impl.UserInfoDAOImpl;
import com.waldi.fishingcard.model.UserInfo;


@Controller
public class MainController {
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	  private Environment env;

   @RequestMapping(value = { "/", "/homepage"}, method = RequestMethod.GET)
   public String mainController(Model model) {
       model.addAttribute("title", "Welcome");
       model.addAttribute("message", "Wybierz rodzaj zadania.");

       return "homePage";
   }

 
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String loginPage(Model model ) {
	   model.addAttribute("title", "Login");
       return "loginPage";
   }
   
   @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
   public String forgotPassword(Model model ) {
	   model.addAttribute("title", "Forgot");
       return "forgotPassword";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(Model model) {
       model.addAttribute("title", "Logout");
       model.addAttribute("message", "Do zobaczenia.");
       return "logoutSuccessfulPage";
   }

   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
	   model.addAttribute("title", "403"); 
       if (principal != null) {
           model.addAttribute("message", "Witaj " + principal.getName()
                   + "<br> Nie posiadasz uprawniê do tej strony!");
       } else {
           model.addAttribute("msg",
                   "Nie posiadasz uprawniê do tej strony!");
       }
       return "403Page";
   }
   
// ---------------- Brak podania loginu na stronie do logowania --------------
   @RequestMapping(value = {"/newpass"}, method = RequestMethod.GET)
   public String newPasswordErr(Model model) {
       model.addAttribute("title", "Login");
       model.addAttribute("message", "Podaj login.");
       return "loginPage";
   }
   // ---------------- Informacja o zmianie chas³¹ -------------- 
   @RequestMapping(value = {"/newpass/update"}, method = RequestMethod.POST)
   public String newPasswordUpdate(Model model) {
	  // System.out.println("uruchomi³ sie updat");
       model.addAttribute("title", "Karta wêdkarska");
       model.addAttribute("message", "Zmieniono has³o.");
       return "homePage";
   }
   // ---------------- Metoda generuj¹ca link do zmiany chas³a  --------------
   @RequestMapping(value = {"/newpass/{userLog}"}, method = RequestMethod.GET)
   public String newPassword(Model model, @PathVariable("userLog") String userLog) {
	
	 // UserInfo myUser = userInfoDAO.getUserInfo(userLog);
	  
	   userInfoDAO.linkToPassChange(userLog);
       model.addAttribute("title", "Karta wêdkarska");
       model.addAttribute("message", "Na twój e-mal przes³ano link do zmiany has³¹.");
       return "newPass";
   }
   // ---------------- Metoda pozwalaj¹ca zmieniæ has³o. Link z email  -------------- 
   @RequestMapping(value = {"/newpass/{userLog}/{idChange}"}, method = RequestMethod.GET)
   public String passChange(Model model, @PathVariable("userLog") String userLog, @PathVariable("idChange") int idChange) {
	   
       model.addAttribute("title", "Karta wêdkarska");
       return "newPass2";
   }
   

}
