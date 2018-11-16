package com.waldi.fishingcard.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.waldi.fishingcard.dao.UserInfoDAO;


@Configuration
@ComponentScan("com.waldi.fishingcard.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource({"classpath:datasource-cfg.properties", "classpath:config.properties","classpath:aplication.properties"})

public class ApplicationContextConfig {
	 // The Environment class serves as the property holder
	  // and stores all the properties loaded by the @PropertySource
	  @Autowired
	  private Environment env;
	 
	 // @Autowired
	  private UserInfoDAO userInfoDAO;

	  
	  
	  @Bean
	  public ResourceBundleMessageSource messageSource() {
	      ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
	      // Load property in message/validator.properties
	     // rb.setBasenames(new String[] { "messages/validator" });
	      rb.setBasenames(new String[] { "messages" });
	      return rb;
	  }
	 
	  /*
	   * 
	   */
	  @Bean(name = "viewResolver")
	  public InternalResourceViewResolver getViewResolver() {
	      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	      viewResolver.setPrefix("/WEB-INF/pages/");
	      viewResolver.setSuffix(".jsp");
	      return viewResolver;
	  }
	 
	  /*
	   * 
	   */
	  @Bean(name = "dataSource")
	  public DataSource getDataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 
	      // See: datasouce-cfg.properties
	      dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
	      dataSource.setUrl(env.getProperty("ds.url"));
	      dataSource.setUsername(env.getProperty("ds.username"));
	      dataSource.setPassword(env.getProperty("ds.password"));

	 
	      return dataSource;
	  }
	 
	  // Transaction Manager
	  /*
	   * 
	   */
	  @Autowired
	  @Bean(name = "transactionManager")
	  public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
	      DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
	 
	      return transactionManager;
	  }

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}
}
