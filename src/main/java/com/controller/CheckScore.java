package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.TaskBean;
import com.Dao.TaskDao;


public class CheckScore extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");

		TaskDao dao = new TaskDao();
		ArrayList<TaskBean> tasks = dao.taskList(userId);

//		request.setAttribute("tasks", tasks);
		int score = 0;
		int total = 0;
		
		for (TaskBean tb : tasks) {
			if (tb.getPriority().equals("high")) {
				total += 100;
			} else if (tb.getPriority().equals("medium")) {
				total += 50;
			}
			if(tb.getStatus().equals("pending")) {
				System.out.println("Tasks are Pending");
				request.setAttribute("taskPending", "Some Task Are Pending");
			}else if (tb.getStatus().equals("done")) {
				if (tb.getPriority().equals("high")) {
					score += 100;
				} else if (tb.getPriority().equals("medium")) {
					score += 50;
				} 
			}
		}
		int marks = (score*100)/total;
		request.setAttribute("marks", marks);
		RequestDispatcher rd = request.getRequestDispatcher("ScoreTask.jsp");
		rd.forward(request, response);
	}
	

	

}
