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

public class AddTaskController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskName = request.getParameter("taskName");
		String taskDescription = request.getParameter("taskDescription");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		String endDate = request.getParameter("endDate");
//		String taskName = request.getParameter("");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    String creatAt = formatter.format(date);
		
	    HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
	    
	    System.out.println(creatAt+" : creatAt");
	    
	    TaskDao taskDao =new TaskDao();
	    TaskBean taskBean = new TaskBean();
	    
	    taskBean.setTaskName(taskName);
	    taskBean.setDiscription(taskDescription);
	    taskBean.setPriority(priority);
	    taskBean.setStatus(status);
	    taskBean.setCreatAt(creatAt);
	    taskBean.setEndDate(endDate);
	    taskBean.setUserId(userId);
	    
	    taskDao.insertTask(taskBean);
	    request.getRequestDispatcher("AddTask.jsp").forward(request, response);
	}

}
