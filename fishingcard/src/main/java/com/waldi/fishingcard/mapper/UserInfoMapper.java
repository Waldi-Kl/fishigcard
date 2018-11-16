package com.waldi.fishingcard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.waldi.fishingcard.model.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo> {
	
	public static final String BASE_SQL = //
//			 "Select u.id, u.surname, u.name, u.login, u.pass, u.email "//
//			+ " from user u ";
	
	"Select u.id, u.surname, u.name, u.login, u.pass, u.email, u.enabled, u.last_login, u.reset_token from user u ";

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		int userId = rs.getInt("id");
		String surname = rs.getString("surname");
		String userName = rs.getString("name");
		String userLogin = rs.getString("login");
        String password = rs.getString("pass");        
        String email = rs.getString("email"); 
  
        boolean enabled = rs.getBoolean("enabled");
        Date lastLogin = rs.getDate("last_login");
        String resetToken = rs.getString("reset_token");


        UserInfo user = new UserInfo(surname, password);
        user.setName(userName);
        user.setLogin(userLogin);
        user.setId(userId);
        user.setEmail(email);
        user.setEnabled(enabled);
        user.setLastLogin(lastLogin);
        user.setResetToken(resetToken);
        return user;

	}

	
}
