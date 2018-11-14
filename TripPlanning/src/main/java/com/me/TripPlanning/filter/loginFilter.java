package com.me.TripPlanning.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class loginFilter implements Filter{

	static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
            + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";  
  
    static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);  
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("In login filter");
		String tag = "approve";
		HttpServletRequest req = (HttpServletRequest)request;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean test = isValid(username)&&isValid(password);
		if(test==false) {
			System.out.println("Dectected User Injection in login Filter");
			tag = "denied";		
		}
		req.setAttribute("tag", tag);
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isValid(String str) {  		  
	    if (sqlPattern.matcher(str).find()) {  
             return false;  
	    }  
	    return true;  
	}  


}
