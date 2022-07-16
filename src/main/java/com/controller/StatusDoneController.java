package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.TaskDao;


public class StatusDoneController extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  taskId = Integer.parseInt(request.getParameter("taskid"));
		TaskDao taskDao = new TaskDao();
		taskDao.UpdateStatus(taskId);
		response.sendRedirect("TodoListController");
	}

}
