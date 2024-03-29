package com.edu.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.exam.entity.Student;
/**
 * 用户登录验证过滤器
 * */
public class CommonFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		    HttpServletRequest req = (HttpServletRequest) request;
		    HttpServletResponse res = (HttpServletResponse) response;
		    System.out.println("进入filter");
		    HttpSession session = req.getSession(true);

		    //从session里取的用户名信息
		    Student student =  (Student) session.getAttribute("student");
		    
		    //判断如果没有取到用户信息,就跳转到登陆页面
		    if (student == null || "".equals(student)) {
		      //跳转到登陆页面
		      res.sendRedirect(req.getContextPath()+"/login/login.jsp");
		    }
		    else {
		      //已经登陆,继续此次请求
		      chain.doFilter(request,response);
		    }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
