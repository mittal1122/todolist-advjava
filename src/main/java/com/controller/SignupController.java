package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.UserBean;
import com.Dao.UserDao;


public class SignupController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String sQuestion = request.getParameter("sQuestion");
		System.out.println(sQuestion + " : sQuestion");
		String sAnswer = request.getParameter("sAnswer");
				
		UserDao userDao = new UserDao();
		UserBean userBean = new UserBean();
		
		userBean.setFirstName(firstName);
		userBean.setLastName(lastName);
		userBean.setEmail(email);
		userBean.setGender(gender);
		userBean.setPassword(password);
		userBean.setsQuestion(sQuestion);
		userBean.setsAnswer(sAnswer);
		
		userBean.setUserType("customer");
		
		userDao.insertUser(userBean);
		System.out.println(userBean + " : userBean in SingupController");
		HttpSession session = request.getSession();
		
		session.setAttribute("userId", userBean.getUserId());
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}

}
