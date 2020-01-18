package com.boot.app.FirstBootApp.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.app.FirstBootApp.filters.RequestResponseLoggingFilter;

@Configuration
public class SpringConfig {

	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
	    FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new RequestResponseLoggingFilter());
	    registrationBean.addUrlPatterns("/empByIds/*");
	         
	    return registrationBean;    
	}
}
