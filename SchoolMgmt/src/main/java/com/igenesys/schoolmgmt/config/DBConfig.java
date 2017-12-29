package com.igenesys.schoolmgmt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:db.properties"})
public class DBConfig {
	
			  @Autowired
			  private Environment env;
			  DriverManagerDataSource dataSource;
			  
			  @Bean
			  public JdbcTemplate jdbcTemplate()
			  {
			 
			    DriverManagerDataSource dataSource = new DriverManagerDataSource();
			    
			    dataSource.setDriverClassName(this.env.getProperty("db.driver"));
			    dataSource.setUrl(this.env.getProperty("db.url"));
			    dataSource.setUsername(this.env.getProperty("db.user"));
			    dataSource.setPassword(this.env.getProperty("db.password"));
			    
			    this.dataSource = dataSource;
			    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			    return jdbcTemplate;
			  }
			  
			  @Bean
			  public PlatformTransactionManager transactionManager()
			  {
			    DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
			    dataSourceTransactionManager.setDataSource(this.dataSource);
			    return dataSourceTransactionManager;
			  }

}
