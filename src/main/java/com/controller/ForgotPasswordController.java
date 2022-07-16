package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.Dao.UserDao;

public class ForgotPasswordController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String VerifyEmail = request.getParameter("VerifyEmail");
		
		System.out.println(VerifyEmail +" : VerifyEmail");
		UserDao userDao = new UserDao();
		UserBean user = userDao.checkForgotEmail(VerifyEmail);
//		System.out.println(user);
		
			if(user != null ) {
				request.setAttribute("user", user.getEmail());
				request.setAttribute("sQuestion", user.getsQuestion());
				request.getRequestDispatcher("CheckQuestion.jsp").forward(request, response);
			}else {
				request.setAttribute("emailErrorMsg", "Re-Enter Email");
				
				request.getRequestDispatcher("TackEmailForgotPassword.jsp").forward(request, response);
			}
		}
	}


