package com.edu.exam.handler;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;
import com.edu.exam.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentHandler {
	@Autowired
	StudentService studentService ;
	/*
	 * 展示主页
	 * **/
	@RequestMapping("/showPersonal")
	public String personal(){
		
		return "student/index";
	}
	/*
	 * 考试记录查询
	 * **/
	@RequestMapping("/showExam")
	public String historialExam(Map<String,Object> map,HttpServletRequest request,HttpServletResponse response) {
		Student student = (Student) request.getSession().getAttribute("student");
		List<Student_Exam> ExamList = studentService.showPersonalExam(student);
		map.put("ExamList", ExamList);
		return "student/historical";
	}
	/*
	 * 更改个人信息
	 * **/
	@RequestMapping("/edit")
	public String editPersonalInformation(Model model,HttpSession session){
		HashMap<String, Object> map = new HashMap<>();
		map.put("男","男");
		map.put("女","女");
		model.addAttribute("sex",map);
		model.addAttribute("students",session.getAttribute("student"));
		return "student/edit";
	}
	/*
	 * 修改个人信息成功后跳转页面
	 * **/
	@RequestMapping("/modifyPersonal")
	public String modifyPersonal(HttpSession session,Student student,Map<String,Object> map,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		//根据id更新个人信息
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("student", studentService.updatePersonalById(student));
		//当item参数为2时为个人信息修改成功
		map.put("item", "2");
		return "student/edit_success";
		
	}
	@ModelAttribute
	public void getStudent(HttpSession session, Map<String,Object> map,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		map.put("student", session.getAttribute("student"));

	}

	/*
	 * 修改密码
	 * **/
	@RequestMapping("modifyPassword")
	public String modifyPassword(@RequestParam("newPwd")String newPwd,HttpSession session,Map<String,Object> map){
		//修改数据库中密码
		Student student = (Student) session.getAttribute("student");
		int id = student.getId() ; 
		studentService.modifyPwd(id,newPwd);
		//更新session中个人信息
		session.setAttribute("student",studentService.getStudentById(id) );
		//当item参数为1时为密码修改成功
		map.put("item", "1");
		return "student/edit_success";
		
	}
}
