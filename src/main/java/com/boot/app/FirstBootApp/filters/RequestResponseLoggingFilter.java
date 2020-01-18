package com.boot.app.FirstBootApp.filters;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;


public class RequestResponseLoggingFilter implements Filter {
  
//	private static final Logger logger= (Logger) LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
    
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("Logging Request  {} : {}" +req.getMethod()+", "+ req.getRequestURI());
		//logger.debug("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
//		logger.debug("Logging Response :{}", res.getContentType());
		System.out.println("Logging Response :{} "+res.getContentType());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
