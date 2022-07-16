package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CheckQAFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("ForgotPasswordFilter  :: destroy()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String sQuestion = request.getParameter("sQuestion");
		String sAnswer = request.getParameter("sAnswer");
		boolean isError = false;
		if(sQuestion ==null || sQuestion.trim().length() ==0) {
			isError = true;
			request.setAttribute("sQuestionErrorMsg", "Plese select Question ");
		}else {
			request.setAttribute("sQuestion", sQuestion);
		}
		
		if(sAnswer ==null || sAnswer.trim().length() ==0) {
			isError = true;
			request.setAttribute("sAnswerErrorMsg", "Plese Enter Answer");
		}else {
			request.setAttribute("sAnswer", sAnswer);
		}
		if(isError) {
			request.getRequestDispatcher("CheckQuestion.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ForgotPasswordFilter  :: init()");
		
	}

}
