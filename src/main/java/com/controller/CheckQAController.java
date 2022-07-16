package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.Dao.UserDao;


public class CheckQAController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String sQuestion = request.getParameter("sQuestion");
		String sAnswer = request.getParameter("sAnswer");
		
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.sQuestionAnswer(email, sQuestion, sAnswer);
		if(userBean == null) {
			request.setAttribute("ansError", "Plese Enter Valid Answer");
			
			request.getRequestDispatcher("CheckQuestion.jsp").forward(request, response);
		}else {
			request.setAttribute("email", email);
			request.getRequestDispatcher("UpdatePassword.jsp").forward(request, response);
		}
	}

}
