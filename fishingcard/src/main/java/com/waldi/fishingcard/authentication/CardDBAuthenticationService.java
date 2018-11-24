package com.waldi.fishingcard.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.waldi.fishingcard.dao.UserInfoDAO;
import com.waldi.fishingcard.model.UserInfo;

@Service
public class CardDBAuthenticationService implements UserDetailsService{
	@Autowired
	private UserInfoDAO userInfoDAO;

	public UserDetails loadUserByUsername(String userlogin) throws UsernameNotFoundException {

		UserInfo userInfo = null;
		try {
			userInfo = userInfoDAO.getUserInfo(userlogin);
			// System.out.println("Jest user: " + userInfo.getId());

		} catch (Exception e) {
			System.out.println("Posz³o: getUserInfo=NULL");
		}

		if (userInfo.getName() == null) {
			System.out.println("loadUserByUsername not found.");
			throw new UsernameNotFoundException("User " + userlogin + " was not found in the database");
		} else {
			//userInfoDAO.setLoginDate(userInfo.getId());
			System.out.println("Znaleziono");
		}

		// [USER,ADMIN,..]
		List<String> roles = userInfoDAO.getUserRoles(userlogin);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roles != null) {
			for (String role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = null;

		try {
			userDetails = (UserDetails) new User(userInfo.getName(), //
					userInfo.getPass(), grantList);
		} catch (Exception e) {

		}

		return userDetails; // to przechodzi do zmiennej "userPrincipal" -> do
							// jsp
	}
}
