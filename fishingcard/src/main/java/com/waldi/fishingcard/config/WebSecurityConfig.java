package com.waldi.fishingcard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.waldi.fishingcard.authentication.CardDBAuthenticationService;

 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    
    @Autowired
    CardDBAuthenticationService cardDBAauthenticationService;
 
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        // Users in memory.
        auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
        auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("USER, ADMIN");
        auth.inMemoryAuthentication().withUser("admin2").password("123").roles("ADMIN");
 
        // For User in database.
      //  auth.userDetailsService(kardDBAauthenticationService);	Tak by³o
        auth.userDetailsService(cardDBAauthenticationService).passwordEncoder(passwordEncoder());	// A tak ma byæ
 
    }
    
    @Bean
   	public PasswordEncoder passwordEncoder(){
   		PasswordEncoder encoder = new BCryptPasswordEncoder();
   		return encoder;
   	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/homepage", "/login", "/logout", "/newpass/*","/forgotpassword", "/404").permitAll();
 
        // /cardInfo page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/cardInfo/*","/personInfo/*").access("hasAnyRole('ROLE_HOST', 'ROLE_USER', 'ROLE_ADMIN')");
        
        // /settingsPages page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/admin/settingsPages","/statistics/*").access("hasAnyRole('ROLE_HOST', 'ROLE_ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin","/userInfo/*").access("hasRole('ROLE_ADMIN')");
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("userlogin")//	Parametr z formularza logowania
                .passwordParameter("password")//	Parametr z formularza logowania
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful"); 
    }
}