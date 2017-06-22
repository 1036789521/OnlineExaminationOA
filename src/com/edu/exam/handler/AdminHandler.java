package com.edu.exam.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.edu.exam.entity.Classes;
import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Student;
import com.edu.exam.service.impl.AdminServiceImpl;
import com.edu.exam.service.impl.StudentPaperServiceImpl;
import com.edu.exam.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminHandler {
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	@Autowired
	private StudentPaperServiceImpl studentPaperServiceImpl;
	@RequestMapping("/test")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("admin/index");
		List<Classes> allClassesList = adminServiceImpl.findAllClasses();
		mv.addObject("allClassesList", allClassesList);
		return mv;
	}

	/*
	 * @RequestMapping("/updateClasses") public ModelAndView go1() {
	 * ModelAndView mv = new ModelAndView("admin/updateClasses"); List<Classes>
	 * allClassesList = adminServiceImpl.findAllClasses();
	 * mv.addObject("allClassesList", allClassesList); return mv; }
	 */
	@RequestMapping("/ui")
	public ModelAndView go2() {
		ModelAndView mv = new ModelAndView("admin/ui");
		List<Classes> allAdviserList = adminServiceImpl.findAllClasses();
		mv.addObject("allClassesList", allAdviserList);
		return mv;
	}
	//学生管理页面
	@RequestMapping("/forms")
	public ModelAndView go3() {
		ModelAndView mv = new ModelAndView("admin/forms");
		//查询所有学生信息
		List<Student> studentsList = studentServiceImpl.getAllStudents();
		mv.addObject("studentsList", studentsList);
		return mv;
	}

	@RequestMapping("/messages")
	public ModelAndView go4() {
		ModelAndView mv = new ModelAndView("admin/messages");
		List<Classes> allClassesList = adminServiceImpl.findAllClasses();
		mv.addObject("trainersList", allClassesList);
		return mv;
	}

	@RequestMapping("/statistic")
	public ModelAndView go5() {
		ModelAndView mv = new ModelAndView("admin/statistic");
		List<Item_t> allItem_tList = adminServiceImpl.findAllItem_t();
		mv.addObject("allItem_tList", allItem_tList);
		return mv;
	}

	@RequestMapping("/tables")
	public ModelAndView go6() {
		ModelAndView mv = new ModelAndView("admin/tables");
		List<Paper_t> paperList = studentPaperServiceImpl.getAllPapers();
		mv.addObject("paperList", paperList);
		return mv;
	}

	@RequestMapping("/user")
	public ModelAndView go7() {
		ModelAndView mv = new ModelAndView("admin/user");
		List<Exam> examList = studentPaperServiceImpl.getAllExams();
		mv.addObject("examList", examList);
		return mv;
	}

	// 鐝骇绠＄悊
	public ModelAndView classesManager(Classes classes, int methodNumber) {
		ModelAndView mv = null;
		if (methodNumber == 0) {
			mv = addClass(classes);
		}
		if (methodNumber == 1) {
			mv = findClass(classes);
		}
		if (methodNumber == 2) {
			mv = addClass(classes);
		}
		if (methodNumber == 3) {
			/* mv =deleteClasses(classes); */
		}
		return mv;
	}

	// 添加班级信息成功并跳回班级管理页面
	@RequestMapping("/addclasses")
	public ModelAndView addClass(Classes classes) {
		ModelAndView mv = new ModelAndView("admin/index");
		adminServiceImpl.addClasses(classes);
		return login();
	}

	@RequestMapping("/add")
	public ModelAndView addClass() {
		ModelAndView mv = new ModelAndView("admin/updateClasses");
		mv.addObject("classes", new Classes());
		return mv;
	}

	@RequestMapping("/find")
	public ModelAndView findClass(Classes classes) {
		ModelAndView mv = new ModelAndView("admin/index");
		String classesName = classes.getClassName();
		List<Classes> classesList = adminServiceImpl.findClasses(classesName);
		mv.addObject("classesList", classesList);
		System.out.println("++++++++++++" + classesList);
		return mv;
	}

	@RequestMapping("/deleteClasses")
	public ModelAndView deleteClasses(@RequestParam("className") String classesName) {

		ModelAndView mv = new ModelAndView("admin/index");
		int line = adminServiceImpl.deleteClasses(classesName);

		List<Classes> allAdviserList = adminServiceImpl.findAllClasses();
		mv.addObject("allClassesList", allAdviserList);

		return mv;
	}

	// 跳转至更新班级信息页面
	@RequestMapping("/realUpdateClasses")
	public ModelAndView update(Classes classes, @RequestParam("classesid") String classesid) {
		ModelAndView mv = new ModelAndView("admin/updateClasses");
		// 数据库返回指定班级信息
		classes = adminServiceImpl.findClassesById(classesid);
		
		mv.addObject("classes", classes);

		return mv;
	}

	// 班级信息更新后跳转并返回至首页
	@RequestMapping("/updateclasses")
	public ModelAndView updateClasses(Classes cl) throws ParseException {
		ModelAndView mv = new ModelAndView("admin/index");
		// 班级信息保存至数据库
		adminServiceImpl.updateClasses(cl);
		return mv;
	}
	//
	@RequestMapping("/addadviser")
	public String addAdviser(Classes classes) {
		System.out.println("addadviser");
		adminServiceImpl.addAdvisor(classes);
		System.out.println(classes);
		return "admin/ui";
	}

	@RequestMapping("/findadviser")
	public ModelAndView findAdviser(Classes classes) {

		ModelAndView mv = new ModelAndView("admin/ui");
		System.out.println("findadviser");
		String advisorName = classes.getAdviserName();
		List<Classes> advisorList = adminServiceImpl.findAdvisor(advisorName);
		mv.addObject("advisorList", advisorList);

		return mv;
	}

	@RequestMapping("/deleteAdviser")
	public ModelAndView deleteAdviser(Classes classes) {
		ModelAndView mv = new ModelAndView("admin/ui");
		String adviserName = classes.getClassName();
		int line = adminServiceImpl.deleteAdviser(adviserName);

		System.out.println("+++++Handler deleteAdviser+++++++" + line);
		return mv;
	}

}
