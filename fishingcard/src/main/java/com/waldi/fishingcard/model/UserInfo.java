package com.waldi.fishingcard.model;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class UserInfo {

	private int userId;
	private String userName;
	private String userSurname;
	private String login;
	private String pass;
	private String email;
	private boolean enabled;
	private Date lastLogin;
	private String resetToken;

	public UserInfo() {

	}

	public UserInfo(String userSurname, String password) {
		this.userSurname = userSurname.trim().toUpperCase();
		this.pass = password;
	}

	// ------------------------ To jest zmiana kodowania z tekstu przesy³anego z
	// formulzrza -------------------------------------
	public UserInfo changeUser() throws IOException {

		String newSName = this.getSurname();
		newSName = URLEncoder.encode(this.getSurname(), "ISO-8859-1");
		newSName = URLDecoder.decode(newSName, "UTF-8");
		this.setSurname(newSName);

		String newName = this.getName();
		newName = URLEncoder.encode(this.getName(), "ISO-8859-1");
		newName = URLDecoder.decode(newName, "UTF-8");
		this.setName(newName);

		String newEmail = this.getEmail();
		newEmail = URLEncoder.encode(this.getEmail(), "ISO-8859-1");
		newEmail = URLDecoder.decode(newEmail, "UTF-8");
		this.setEmail(newEmail);

		return this;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name.trim().toUpperCase();
	}

	public String getSurname() {
		return userSurname;
	}

	public void setSurname(String surname) {
		this.userSurname = surname.trim().toUpperCase();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login.trim().toUpperCase();
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

}
