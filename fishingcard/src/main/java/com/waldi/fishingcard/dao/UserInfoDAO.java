package com.waldi.fishingcard.dao;

import java.util.List;
import java.util.Optional;

import com.waldi.fishingcard.model.UserInfo;

public interface UserInfoDAO {

	// public UserInfo getUserInfo(String userName);
	public UserInfo getUserInfo(String userLogin);

	// [USER,AMIN,..]
	public List<String> getUserRoles(String userName);
	public List<UserInfo> getUsersList();
	public void insertUser(UserInfo u);
	public void deleteUser(String userLogin);
	public void updateUser(UserInfo user);
	public void updateRule(int rule, int id);
	public void deleteRule(int idUser);
	public void passChange(int idUser, int idChange);
	public void linkToPassChange(String userLog);
	public void setLoginDate(int userID);

	public UserInfo findUserByEmail(String email);
	public UserInfo findUserByResetToken(String resetToken);
	public void save(UserInfo user);

}
