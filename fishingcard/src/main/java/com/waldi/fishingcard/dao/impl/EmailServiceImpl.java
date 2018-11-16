package com.waldi.fishingcard.dao.impl;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waldi.fishingcard.dao.EmailService;


//@Service("userService")
@Service
public class EmailServiceImpl implements EmailService {
	 @Autowired
	  private Environment env;

	@Async
	public void sendEmail(SimpleMailMessage email) {

		System.out.println("Poszedl sendEmail" );
		JavaMailSender mailSender = new JavaMailSenderImpl();

		
	   // ((JavaMailSenderImpl) mailSender).setHost("localhost");
	    //((JavaMailSenderImpl) mailSender).setPort(25);
//	    ((JavaMailSenderImpl) mailSender).setUsername("wsparcie@localhost");
//	    ((JavaMailSenderImpl) mailSender).setPassword("1234");
	    
		 ((JavaMailSenderImpl) mailSender).setHost(env.getProperty("spring.mail.host"));		
	    ((JavaMailSenderImpl) mailSender).setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
	    ((JavaMailSenderImpl) mailSender).setUsername(env.getProperty("spring.mail.username"));
	    ((JavaMailSenderImpl) mailSender).setPassword(env.getProperty("spring.mail.password"));
	    
	     
	    Properties props = ((JavaMailSenderImpl) mailSender).getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", env.getProperty("spring.mail.smtp.auth"));
	    props.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.smtp.starttls.enable"));
	    props.put("mail.debug", env.getProperty("spring.mail.username")); 
	    
		
		try {mailSender.send(email);							// nale¿y dodaæ dependency : <groupId>javax.mail</groupId> <artifactId>mail</artifactId><version>1.4.7</version>
		
		}catch (Exception e) {
			System.out.println("Blad z getUserInfo to: "+ e.toString());
		}

		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("To jest ENV z ESI=" + env.getProperty("spring.mail.username"));
	}

}
