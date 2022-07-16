package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.Bean.UserBean;
import com.Dao.UserDao;


public class UpdatePasswordController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserDao userDao = new UserDao();
		UserBean userBean = new UserBean();
		userBean.setPassword(password);
		userDao.updatePassword(email,password);
		response.sendRedirect("Login.jsp");
	}
	

	

}
