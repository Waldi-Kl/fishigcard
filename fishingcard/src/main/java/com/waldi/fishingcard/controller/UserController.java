package com.waldi.fishingcard.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.waldi.fishingcard.dao.UserInfoDAO;
import com.waldi.fishingcard.model.UserInfo;

@Controller
@RequestMapping(value = "/userInfo")
public class UserController {

	@Autowired
	private UserInfoDAO userInfoDAO;

	@RequestMapping(value = { "/user/{userLog}" }, method = RequestMethod.GET)
	public String userInfo(Model model, @PathVariable("userLog") String userLog) {
		List<String> userRoles = userInfoDAO.getUserRoles(userLog);
		if (userRoles.size() == 0)
			userRoles.add("Brak przypisanej roli");
		UserInfo userInf = userInfoDAO.getUserInfo(userLog);
		model.addAttribute("title", "UserInfo");
		// model.addAttribute("message", userLog);
		model.addAttribute("user", userInf);
		model.addAttribute("role", userRoles);
		return "userInfoPage";
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String userListController(Model model) {
		List<UserInfo> list = null;
		try {
			list = userInfoDAO.getUsersList();
		} catch (Exception e) {
			// Tu powinno znalesc sie obs³uga wielu b³êdów jdbc (e.get..()) UWAGA!!!!
			// powinny tworzyæ siê logi z b³êdami.
			model.addAttribute("title", "UserInfo");
			model.addAttribute("message", "Nie powodzenie podczas po³¹czenia do bazy!");
			System.out.println("Blad: "+e);
			return "403Page";
		}

		model.addAttribute("title", "UserInfo");
		model.addAttribute("users", list);
		return "userListPage";
	}

	@RequestMapping(value = { "/adduser" }, method = RequestMethod.POST)
	public String addUser(Model model, UserInfo newUser) throws IOException {
		model.addAttribute("title", "UserInfo");
		if (newUser.getLogin().equals("")) {
			model.addAttribute("message", "Problem: brak loginu.");
			return "403Page";
		}

		newUser.changeUser();

		try {
			userInfoDAO.insertUser(newUser);
		} catch (Exception e) {
			// Tu powinno znalesc sie obs³uga wielu b³êdów jdbc (e.get..()) UWAGA!!!!
			// powinny tworzyæ siê logi z b³êdami.
			model.addAttribute("message", "Problem: " + e.getCause());
			return "403Page";
		}
		List<UserInfo> list = userInfoDAO.getUsersList();
		model.addAttribute("users", list);
		return "userListPage";
	}

	@RequestMapping(value = { "/deleteuser" }, method = RequestMethod.POST)
	public String deleteUser(Model model, UserInfo newUser) {

		model.addAttribute("title", "UserInfo");
		try {
			userInfoDAO.insertUser(newUser);
		} catch (Exception e) {
			// Tu powinno znalesc sie obs³uga wielu b³êdów jdbc (e.get..()) UWAGA!!!!
			// powinny tworzyæ siê logi z b³êdami.
			model.addAttribute("message", "Problem: " + e.getCause());
			return "403Page";
		}
		List<UserInfo> list = userInfoDAO.getUsersList();
		model.addAttribute("users", list);
		return "userListPage";

	}

	@RequestMapping(value = { "/updateuser" }, method = RequestMethod.POST)
	public String putUser(Model model, UserInfo myUser) throws IOException {
		model.addAttribute("title", "UserInfo");
		// ------------------------ To jest zmiana kodowania z tekstu przesy³anego z
		// formulzrza -------------------------------------
		myUser.changeUser();
		try {
			userInfoDAO.updateUser(myUser);
		} catch (Exception e) {
			// Tu powinno znalesc sie obs³uga wielu b³êdów jdbc (e.get..()) UWAGA!!!!
			// powinny tworzyæ siê logi z b³êdami.
			model.addAttribute("message", "Problem: " + e.getCause());
			return "403Page";
		}
		List<UserInfo> list = userInfoDAO.getUsersList();
		model.addAttribute("users", list);
		return "userListPage";
	}

	@RequestMapping(value = { "/updaterole" }, method = RequestMethod.POST)
	public String putUserRole(Model model, HttpServletRequest request, UserInfo myUser) {
		model.addAttribute("title", "UserInfo");
		// System.out.println("Rola to :" + request.getParameter("option"));
		// System.out.println("userID to :" + request.getParameter("userID"));
		int idUser = Integer.parseInt(request.getParameter("userID"));
		String rule = request.getParameter("option");
		if (rule != null) {
			switch (rule) {
			case "ADMIN":
				userInfoDAO.updateRule(1, idUser);
				break;
			case "USER":
				userInfoDAO.updateRule(2, idUser);
				break;
			case "HOST":
				userInfoDAO.updateRule(3, idUser);
				break;

			default:
				// System.out.println("Default");
				userInfoDAO.updateRule(0, idUser);
				break;
			}
		}
		List<UserInfo> list = userInfoDAO.getUsersList();
		model.addAttribute("users", list);
		return "userListPage";
	}

}
