package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.TaskDao;


public class DeleteTaskController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  TaskId = Integer.parseInt(request.getParameter("TaskId"));
		
		
		System.out.println(TaskId + " : TaskID " );
		TaskDao taskDao = new TaskDao();
		taskDao.deleteTask(TaskId);
		response.sendRedirect("TodoListController");
	}
	
	
	
}
