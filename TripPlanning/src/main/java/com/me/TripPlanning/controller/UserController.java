package com.me.TripPlanning.controller;

import java.util.Random;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.captcha.botdetect.web.servlet.Captcha;
import com.me.TripPlanning.dao.UserDAO;
import com.me.TripPlanning.pojo.User;



@Controller
public class UserController {

	@RequestMapping(value="/register.htm", method = RequestMethod.GET)
	protected String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(value="/login.htm", method = RequestMethod.GET)
	protected String showLoginForm() {
		return "login";
	}
	
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	protected String logout(HttpServletRequest request) {
		//remove user from session
		HttpSession session = request.getSession(false);
		session.setAttribute("currentUser",null);
		System.out.println("user has successfully log out");
		return "home";
	}
	
	//save user into session
	@RequestMapping(value = "/loginpost.htm", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request, ModelMap map,UserDAO userDao) {
		String tag = (String)request.getAttribute("tag");       
	     if(!tag.isEmpty()) {
	         if(tag.equals("denied")) {
	        	map.addAttribute("message","Your input is not safe, please log in again");
	 			return "Message";
	         }
	     }	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10000);
		try {
			User u = userDao.getUser(username, password);

			if (u != null && u.getStatus() == 1) {
				session.setAttribute("currentUser", u);
				return "user-dashboard";
			} else if (u != null && u.getStatus() == 0) {
				map.addAttribute("errorMessage", "Please activate your account to login!");
				return "login";
			} else {
				map.addAttribute("errorMessage", "Invalid username/password!");
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//create a new user
	@RequestMapping(value="/register.htm", method = RequestMethod.POST)
	protected String registerUser(HttpServletRequest request, ModelMap map,UserDAO userDao) throws Exception {
		Captcha captcha = Captcha.load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");
		
		if (captcha.validate(captchaCode)) {
			System.out.println("Captcha valid");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setRole("common");
			user.setStatus(0);
			
			try {
				userDao.register(user);
				Random rand = new Random();
				int randomNum1 = rand.nextInt(5000000);
				int randomNum2 = rand.nextInt(5000000);
				try {
					String str = "http://localhost:8080/TripPlanning/validateemail.htm?email=" + email
							+ "&key1="+ randomNum1 + "&key2=" + randomNum2;
					HttpSession session = request.getSession();
										
					session.setAttribute("key1", randomNum1);
					session.setAttribute("key2", randomNum2);
					System.out.println("Sending email");
					sendEmail(email,
							"Click on this link to activate your account : "+ str);
					map.addAttribute("message", "Email has been sent, please active your account.");
					return "Message";
					
				} catch (Exception e) {
					System.out.println("Email cannot be sent");
				}
				
			}catch(Exception e) {
				throw new Exception("In cotroller. exception in register user:" + e.getMessage());
			}
		}else {
			map.addAttribute("errorMessage", "Invalid Captcha!");
			System.out.println("invalid Invalid");
			return "home";
		}
		return "home";
	}
	
	
	public void sendEmail(String useremail, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("contactapplication2018@gmail.com", "springmvc"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@msis.neu.edu"); // This user email does not									// exist
			email.setSubject("Password Reminder");
			email.setMsg(message); // Retrieve email from the DAO and send this
			email.addTo(useremail);
			email.send();
		} catch (EmailException e) {
			System.out.println("Email cannot be sent");
		}
	}
	
	//validate and active user
	@RequestMapping(value = "/validateemail.htm", method = RequestMethod.GET)
	public String validateEmail(HttpServletRequest request, ModelMap map,UserDAO userDao) {
		// The user will be sent the following link when the use registers
		// This is the format of the email
		// http://hostname:8080/lab10/user/validateemail.htm?email=useremail&key1=<random_number>&key2=<body
		// of the email that when user registers>
		
		HttpSession session = request.getSession(false);
		String email = request.getParameter("email");
		
		int key1 = Integer.parseInt(request.getParameter("key1"));
		int key2 = Integer.parseInt(request.getParameter("key2"));
		int sessionKey1 = (Integer)(session.getAttribute("key1"));
		int sessionKey2 = (Integer)(session.getAttribute("key2"));
		
		if((key1==sessionKey1)&&(key2==sessionKey2)){
			try {
				boolean updateStatus = userDao.activeUser(email);
				if (updateStatus) {
					map.addAttribute("message", "You have successfully active your account!");
					return "Message";
				} else {

					return "error";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			map.addAttribute("errorMessage", "Link expired , generate new link");
			map.addAttribute("resendLink", true);
			return "error";
		}
		return "login";
		
	}
	
	
	@RequestMapping(value = "/resendemail.htm", method = RequestMethod.POST)
	public String resendEmail(HttpServletRequest request,ModelMap map) {
		HttpSession session = request.getSession();
		String useremail = request.getParameter("username");
		Random rand = new Random();
		int randomNum1 = rand.nextInt(5000000);
		int randomNum2 = rand.nextInt(5000000);
		try {
			String str = "http://localhost:8080/TripPlanning/user/validateemail.htm?email=" + useremail + "&key1=" + randomNum1
					+ "&key2=" + randomNum2;
			session.setAttribute("key1", randomNum1);
			session.setAttribute("key2", randomNum2);
			sendEmail(useremail,
					"Click on this link to activate your account : "+ str);
			map.addAttribute("message", "Email has been send");
			return "Message";
			
		} catch (Exception e) {
			System.out.println("Email cannot be sent");
			map.addAttribute("message", "Email cannot be sent");
			return "Message";
		}
	}
	
	@RequestMapping(value = "/forgotpassword.htm", method = RequestMethod.GET)
	public String getForgotPasswordForm(HttpServletRequest request) {	
		return "forgot-password";
	}
	
	@RequestMapping(value = "/forgotpassword.htm", method = RequestMethod.POST)
	public String handleForgotPasswordForm(HttpServletRequest request, ModelMap map,UserDAO userDao) throws Exception {
		String useremail = request.getParameter("email");
		User user = userDao.getByEmail(useremail);
		if(user!=null) {
			sendEmail(useremail, "Your password is : " + user.getPassword());
			map.addAttribute("message", "Your password was emailed to you.");
			return "Message";
		}else {
			map.addAttribute("message", "cannot find this email, please make sure you have entered right email");
			return "Message";
		}
	}
	
	
	
	@RequestMapping(value="/checkUserName.htm", method = RequestMethod.POST)
	@ResponseBody
	public String checkUserName(HttpServletRequest request,UserDAO userDao) throws Exception{
		String name = request.getParameter("username");
		try {
			Boolean duplicate = userDao.checkDuplicateUsername(name);
			if(duplicate.equals(false)) {
				return "not validate";
			}else {
				return "validate";
			}
		}catch(Exception e) {
			throw new Exception("In cotroller. exception in validation username:" + e.getMessage());
		}
	}
	
	@RequestMapping(value="/checkEmail.htm", method = RequestMethod.POST)
	@ResponseBody
	public String checkEmail(HttpServletRequest request,UserDAO userDao) throws Exception{
		String email = request.getParameter("email");
		try {
			Boolean duplicate = userDao.checkDuplicateEmail(email);
			if(duplicate.equals(false)) {
				return "not validate";
			}else {
				return "validate";
			}
		}catch(Exception e) {
			throw new Exception("In controller. exception in validate email: " + e.getMessage());
		}
	}
	

}
