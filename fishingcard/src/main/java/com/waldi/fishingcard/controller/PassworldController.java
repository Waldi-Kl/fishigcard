package com.waldi.fishingcard.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.waldi.fishingcard.dao.EmailService;
import com.waldi.fishingcard.dao.UserInfoDAO;
import com.waldi.fishingcard.dao.impl.EmailServiceImpl;
import com.waldi.fishingcard.model.UserInfo;

@Controller
@RequestMapping(value = "/forgotpassword")
public class PassworldController {
	
	@Autowired
	  private Environment env;
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
    private ServletContext servletContext;
	
	
//private EmailServiceImpl emailService2;
	@Autowired
private EmailService emailService2;

	
	// Display forgotPassword page. Wyœwetl stronê do wprowadzenia email
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		ModelAndView model = new ModelAndView("forgotPassword");
		model.addObject("message", "OK.");
		model.addObject("title", "UserInfo");
		return model;
    }
  
    // Process form submission from forgotPassword page. Po przes³¹niu maila. POST z formularza
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String userEmail, HttpServletRequest request) {
		UserInfo user = new UserInfo();
		user = userInfoDAO.findUserByEmail(userEmail);
		modelAndView.addObject("title", "UserInfo");
		if (user==null) {
			modelAndView.addObject("errorMessage", "Nie znaleziono konta przypisaneg do podanego adresu.");
		} else {
		
			// Generate random 36-character string token for reset password 
			user.setResetToken(UUID.randomUUID().toString());
			// Save token to database
			user.setPass("123");
			userInfoDAO.save(user);

			String appUrl = request.getScheme() + "://" + request.getServerName() + ":8080" + servletContext.getContextPath() +"/forgotpassword";
			// Email message
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom(env.getProperty("spring.mail.username"));	// service.name jest pobierane z pliku konfiguracyjnego config.propertis
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Restart has³a");
			passwordResetEmail.setText("Aby zrestartowaæ has³o kliknij link poni¿ej:\n" + appUrl
					+ "/reset?token=" + user.getResetToken());
			//emailService2 = new EmailServiceImpl();
			
			emailService2.sendEmail(passwordResetEmail);

			// Add success message to view
			modelAndView.addObject("successMessage", "Link do zmiany has³a zosta³ przes³any na adres: " + userEmail);
		}

		//System.out.println("Powinien uruchomiæ ksiê - forgotPassword");
		modelAndView.setViewName("forgotPassword");
		return modelAndView;

	}

	// Display form to reset password
		@RequestMapping(value = "/reset", method = RequestMethod.GET)
		public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
			UserInfo user = new UserInfo();
			user = userInfoDAO.findUserByResetToken(token);
			modelAndView.addObject("title", "Reset");
			if (user!=null) { // Token found in DB !!! UWAGA by³o user.getId()!=0
				modelAndView.addObject("resetToken", token);
				modelAndView.setViewName("resetPassword");	
			} else { // Token not found in DB
				modelAndView.addObject("errorMessage", "Oops!  Niepoprawny reset link.");
				modelAndView.setViewName("forgotPassword");
			}			
			return modelAndView;
		}
		
		// Process reset password form
		@RequestMapping(value = "/reset", method = RequestMethod.POST)
		public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

			// Find the user associated with the reset token
			UserInfo user = new UserInfo();
			user = userInfoDAO.findUserByResetToken(requestParams.get("resetToken"));
			
			// This should always be non-null but we check just in case
			if (user != null) {
				// Set new password    
				user.setPass(requestParams.get("password"));
	            
				// Set the reset token to null so it cannot be used again
				user.setResetToken(null);

				// Save user
				userInfoDAO.save(user);

				// In order to set a model attribute on a redirect, we must use
				// RedirectAttributes

				modelAndView.setViewName("loginPage");
				return modelAndView;
				
			} else {
				modelAndView.addObject("errorMessage", "Oops!  Niew³aœciwy reset link.");
				modelAndView.setViewName("resetPassword");	
			}
			
			return modelAndView;
	   }
   
    // Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		System.out.println("Uruchomil siê EXCeption!!");
		return new ModelAndView("loginPage");
	}
}
