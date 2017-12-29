package com.igenesys.schoolmgmt.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan({"com.igenesys.schoolmgmt.dao"})
@Import({DBConfig.class})
@EnableWebMvc

public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean
	  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	  {
	    return new PropertySourcesPlaceholderConfigurer();
	  }
	  
	  public MessageSource messageSource()
	  {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setUseCodeAsDefaultMessage(true);
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    messageSource.setBasenames(new String[] { "classpath:config" });
	    messageSource.setCacheSeconds(0);
	    return messageSource;
	  }
}
