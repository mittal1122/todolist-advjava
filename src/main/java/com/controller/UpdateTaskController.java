package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.TaskBean;
import com.Dao.TaskDao;


public class UpdateTaskController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int taskId = Integer.parseInt(request.getParameter("taskid"));
		String taskName = request.getParameter("taskName");
		String taskDescription = request.getParameter("taskDescription");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		String endDate = request.getParameter("endDate");
		
	    
	    TaskDao taskDao =new TaskDao();
	    TaskBean taskBean = new TaskBean();
	    
	    taskBean.setTaskName(taskName);
	    taskBean.setDiscription(taskDescription);
	    taskBean.setPriority(priority);
	    taskBean.setStatus(status);
	    taskBean.setTaskId(taskId);
	    taskBean.setEndDate(endDate);

	    
	    taskDao.UpdateTask(taskBean);
	    response.sendRedirect("TodoListController");
		
	}

}
