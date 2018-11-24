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
	
	"Select u.USE_ID, u.USE_SURNAME, u.USE_NAME, u.USE_LOGIN, u.USE_PASS, u.USE_EMAIL, u.USE_ENABLED, u.USE_RESETTOKEN from user u ";

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		int userId = rs.getInt("USE_ID");
		String surname = rs.getString("USE_SURNAME");
		String userName = rs.getString("USE_NAME");
		String userLogin = rs.getString("USE_LOGIN");
        String password = rs.getString("USE_PASS");        
        String email = rs.getString("USE_EMAIL"); 
  
        boolean enabled = rs.getBoolean("USE_ENABLED");
     //   Date lastLogin = rs.getDate("last_login");
        String resetToken = rs.getString("USE_RESETTOKEN");

        UserInfo user = new UserInfo(surname, password);
        user.setName(userName);
        user.setLogin(userLogin);
        user.setId(userId);
        user.setEmail(email);
        user.setEnabled(enabled);
    //  user.setLastLogin(lastLogin);
        user.setResetToken(resetToken);
        return user;

	}

	
}
