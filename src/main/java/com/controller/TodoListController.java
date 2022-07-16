package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.TaskBean;
import com.Dao.TaskDao;

public class TodoListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
		TaskDao taskDao =new  TaskDao();
		
		ArrayList<TaskBean> tasks= taskDao.taskList(userId);
		request.setAttribute("tasks", tasks);
		
		request.getRequestDispatcher("TaskList.jsp").forward(request, response);
	
	}

	

}
