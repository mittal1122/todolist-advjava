package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignupFilter implements Filter {

	public void destroy() {
		System.out.println("SignupFilter :: destroy()");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		boolean isError = false;
		if(firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstnameError", "Enter First Name Properly ");
		}else {
			request.setAttribute("firstnameValue", firstName);
		}
		if(lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastnameError", "Enter Last Name Properly ");
		}else {
			request.setAttribute("lastnameValue", lastName);
		}if(email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Enter Email Properly ");
		}else {
			request.setAttribute("emailValue", email);
		}
		if(password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Enter password Properly ");
		}else {
			request.setAttribute("passwordValue", password);
		}
		if(gender == null || gender.trim().length() == 0) {
			isError = true;
			request.setAttribute("genderError", "Enter Gender Properly ");
		}else {
			request.setAttribute("genderValue", gender);
		}
		
		if(isError) {
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("SignupFilter :: init()");
		
		
	}

}
