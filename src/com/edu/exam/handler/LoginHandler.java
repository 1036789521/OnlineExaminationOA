package com.edu.exam.handler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.exam.entity.Classes;
import com.edu.exam.entity.Student;
import com.edu.exam.entity.User;
import com.edu.exam.service.LoginService;
import com.edu.exam.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("login")
public class LoginHandler {
	@Autowired
	AdminHandler adminHandler ;
	@Autowired
	LoginService loginService;
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	// 根据用户名和密码登录
	@RequestMapping(value = "/checked", method = RequestMethod.POST)
	public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
			Map<String, Object> map, HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {
		
		User user = loginService.login(username, password);
		System.out.println("user:"+user);
		// 无该用户
		if (user == null) {
			request.setAttribute("flag", "用户名或密码错误");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return null;
		}
		//设置角色代码默认值为02
		if("".equals(user.getRole())||""==user.getRole()){
			user.setRole("02");
		}
		// 用户为管理员
		if (  "01".equals(user.getRole())) {
			List<Classes> allClassesList = adminServiceImpl.findAllClasses();
			map.put("allClassesList", allClassesList);
			return "admin/index" ;
			
		}
		// 用户为学生
		if ("02".equals(user.getRole())) {
			Student student = (Student) user.getObj();

			request.getSession().setAttribute("student", student);

			return "student/index";
		}
		return null;
	}

	// 注销用户
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 注销session
		HttpSession session = request.getSession();
		session.removeAttribute("student");
		// 重定向到登录页面
		if (session.getAttribute("student") == null) {

			response.sendRedirect(request.getContextPath() + "/login/login.jsp");

		}
		return "student/index";

	}
	//用户注册
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response,Student student ) throws IOException {
		//表单拿出信息
		student.setUsername(request.getParameter("uid"));
		student.setPassword(request.getParameter("psw1"));
		student.setEmail(request.getParameter("email"));
		student.setName(request.getParameter("nickname"));
		//注册
		loginService.Register(student);
		//注册成功后跳转至注册成功页面
		response.sendRedirect(request.getContextPath() + "/success.jsp");
		return "student/index";
	}
}
