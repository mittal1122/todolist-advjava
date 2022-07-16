package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddTaskFilter implements Filter{
	

	@Override
	public void destroy() {
		System.out.println("AddTaskFilter :: destroy()");
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String taskName = request.getParameter("taskName");
		String taskDescription = request.getParameter("taskDescription");
		String priority = request.getParameter("priority");
		String status = request.getParameter("status");
		String endDate = request.getParameter("endDate");
	
		System.out.println(priority);
		boolean isError = false; 
		if(taskName ==null || taskName.trim().length() ==0) {
			isError = true;
			request.setAttribute("taskErrorMsg", "Plese Enter Task Name ");
		}else {
			request.setAttribute("taskNameValue", taskName);
		}
		
		if(priority ==null || priority.trim().length() ==0) {
			isError = true;
			request.setAttribute("priorityErrorMsg", "Plese Enter priority");
		}else {
			request.setAttribute("prorityValue", priority);
		}
		if(status ==null || status.trim().length() ==0) {
			isError = true;
			request.setAttribute("statusErrorMsg", "Plese Enter status");
		}else {
			request.setAttribute("statusValue", status);
		}
		if(endDate == null) {
			isError = true;
			request.setAttribute("endDateErrorMsg", "Plese Enter endDate");
		}else {
			request.setAttribute("endDateValue", endDate);
		}
		
		if(isError) {
			request.getRequestDispatcher("AddTask.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {

		System.out.println("AddTaskFilter :: init()");
		
	}
}
