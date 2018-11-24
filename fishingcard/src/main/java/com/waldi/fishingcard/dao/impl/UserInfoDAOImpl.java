package com.waldi.fishingcard.dao.impl;


import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waldi.fishingcard.dao.UserInfoDAO;
import com.waldi.fishingcard.mapper.UserInfoMapper;
import com.waldi.fishingcard.model.UserInfo;

@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {

	
	@Autowired
	public UserInfoDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	
	@Autowired
	private PasswordEncoder passwordEncoder;	// kodowanie hasÂ³a rypt-em

	public List<String> getUserRoles(String userLogin) {
		// String sql = "Select r.User_Role "//
		// + " from User_Roles r where r.Username = ? ";
		String sql = "select r.RUL_NAME from rule r where r.RUL_ID in (select ur.RUL_ID "//
				+ "from user_rule ur where ur.USE_ID =(select u.USE_ID from user u where u.USE_LOGIN =?))";
		Object[] params = new Object[] { userLogin };
		List<String> rules = this.getJdbcTemplate().queryForList(sql, params, String.class);
		return rules;
	}

	public UserInfo getUserInfo(String userLogin) {
		// TODO Auto-generated method stub
		// String sql = "Select * "// .id, u.surname, u.name, u.login, u.pass, u.e-mail
		// + " from user u where u.login = ? ";
		String sql = UserInfoMapper.BASE_SQL + "where u.USE_LOGIN = ?";
		Object[] params = new Object[] { userLogin };
		UserInfoMapper mapper = new UserInfoMapper();
		UserInfo userInfo = new UserInfo();
		try {
			userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
		}catch (Exception e) {
			//userInfo.setId(1);
			userInfo.setId(0);
		}

		return userInfo;

	}

	
	public List<UserInfo> getUsersList(){

		String sql = UserInfoMapper.BASE_SQL;
		Object[] params = new Object[] {};
		UserInfoMapper mapper = new UserInfoMapper();
		List<UserInfo> lista = this.getJdbcTemplate().query(sql, params, mapper);
		return  lista;
	}
	
	public void insertUser(UserInfo user){		
		String sql = "INSERT INTO user " +
			"(USE_SURNAME, USE_NAME , USE_LOGIN , USE_PASS , USE_EMAIL) VALUE (?,?,?,?,?)";
		this.getJdbcTemplate().update(sql, user.getSurname(),user.getName(),user.getLogin(),passwordEncoder.encode(user.getPass()),user.getEmail()); // passwordEncoder.encode(user.getPass()) to kodowanie BCRYPT
	}
	
	public void deleteUser(String userLogin) {
		String sql = "DELETE FROM user WHERE USE_LOGIN=?";
		this.getJdbcTemplate().update(sql, userLogin.trim());
	}

	public void updateUser(UserInfo user) {
		//System.out.println("Nazwisko z updateUser :"+ user.getSurname());
		String sql = "UPDATE user " +
		"SET USE_SURNAME = ?, USE_NAME= ?, USE_EMAIL= ? WHERE USE_ID = ?";
		this.getJdbcTemplate().update(sql,  user.getSurname(), user.getName(),user.getEmail(),user.getId());
		
	}

	public void updateRule(int rule, int idUser) {
		// TODO Auto-generated method stub

		String sql = "SELECT EXISTS (SELECT 1 from user_rule WHERE USE_ID=?)";
		String sql1 = "update user_rule SET RUL_ID= ? WHERE USE_ID= ?";		
		String sql2 = "INSERT INTO user_rule (USE_ID, RUL_ID) VALUE (?,?)";	
		//String sql3 = "delete from user_rule where USE_ID =?";
		String sw1 = (String)getJdbcTemplate().queryForObject(
				sql, new Object[] { idUser }, String.class);
		if (sw1.equalsIgnoreCase("0")) {						// staÂ³a powinna byÃ¦ zapisana nie w formie liczbowej !!!!!
			this.getJdbcTemplate().update(sql2,  idUser, rule); // je¿eli nie ma User=0 to wstaw rolê
		} else {
			if (rule==0) {
				this.getJdbcTemplate().update(sql1, rule, idUser);
			} else {
				this.getJdbcTemplate().update(sql1, rule, idUser);
			}
		}
		
	}

	public void deleteRule(int idUser) {
		// TODO Auto-generated method stub
		
	}

	public void passChange(int idUser, int idChange) {
		// TODO Auto-generated method stub
		
	}

	public void linkToPassChange(String userLog) {
		// TODO Auto-generated method stub
		 System.out.println("Wys³ano link do urzytkownika");
		 
	}
/*
	@Override
	public void setLoginDate(int idUser) {
		// TODO Auto-generated method stub
		Date today = new Date();
		// System.out.println("Tu powinna zapisaæ siê data logowania");
			String sql = "UPDATE user " +
			"SET USE_LOGIN = ? WHERE USE_ID = ?";
			this.getJdbcTemplate().update(sql, today ,idUser);
	}
*/
	@Override
	public UserInfo findUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		String sql = UserInfoMapper.BASE_SQL + "where u.USE_EMAIL = '"+email+"'";

		UserInfoMapper mapper = new UserInfoMapper();
		UserInfo userInfo = new UserInfo();
		try {
			userInfo = this.getJdbcTemplate().queryForObject(sql, mapper);
		}catch (Exception e) {
			userInfo= null;
		}
		return userInfo;
		
		//return userRepository.findByEmail(email);
	}

	@Override
	public UserInfo findUserByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		//return userRepository.findByResetToken(resetToken);
		
		String sql = UserInfoMapper.BASE_SQL + "where u.USE_RESETTOKEN = '"+ resetToken +"'";
		UserInfoMapper mapper = new UserInfoMapper();
		UserInfo userInfo = new UserInfo();
		try {
			
			userInfo = this.getJdbcTemplate().queryForObject(sql, mapper);
		}catch (Exception e) {
			//userInfo.setId(1);
			userInfo= null;
		}
		
		return userInfo;
	}

	@Override
	public void save(UserInfo user) {
		// TODO Auto-generated method stub
		//userRepository.save(user);
		String sql = "UPDATE user " +
		"SET USE_PASS = ?, USE_RESETTOKEN = ? WHERE USE_ID = ?";
		this.getJdbcTemplate().update(sql, passwordEncoder.encode(user.getPass()), user.getResetToken(), user.getId());
		}
}
