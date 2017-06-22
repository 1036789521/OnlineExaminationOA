package com.edu.exam.test;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;
import com.edu.exam.entity.User;
import com.edu.exam.mapper.LoginMapper;
import com.edu.exam.mapper.StudentMapper;
import com.edu.exam.service.LoginService;
import com.edu.exam.service.StudentService;
import com.edu.exam.service.impl.StudentServiceImpl;

@ContextConfiguration("/application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {
	@Autowired
	private StudentMapper studnetMapper;
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private LoginService loginSercice ;
	@Autowired 
	private StudentService studentService;

	@Test
	public void test1(){
		System.out.println("進入測試");
		List<Student> list = studnetMapper.getAll();
		System.out.println(Arrays.asList(list));
	}
	@Test
	public void testLoginMapper(){
		User user = new User();
		user.setUsername("oa");
		user.setPassword("oa");
		User user1 = loginMapper.validateUser(user);
		System.out.println(user1.toString());
	}
	@Test
	public void testLoginSercice(){
		System.out.println(loginSercice.login("admin", "admin"));
	}
	@Test
	public void testFindExam(){
		List<Student_Exam> list = studnetMapper.getExamsOfStudent(1);
		System.out.println(Arrays.asList(list));
	}
	@Test
	public void testAllExamService(){
		Student student = new Student();
		student.setId(1);
		List<Student_Exam> list = studentService.showPersonalExam(student);
		for (Student_Exam student_Exam : list) {
			System.out.println(student_Exam);
		}
		//System.out.println(Arrays.asList(list));
	}
	@Test
	public void testModifyPwd(){
		//studnetMapper.modifyPwd(1, "admin");
		System.out.println(studentService.getStudentById(1));
	}
	@Test
	public void testGetStudentByUserName(){
		System.out.println(studnetMapper.getStudentByUserName("admin").toString());
	}
	@Test
	public void testregister(){
		Student student = new Student();
		student.setUsername("qazqaz");
		student.setPassword("!QAZ");
		student.setName("张琪");
		student.setEmail("12d3ddqs@163.com");
		System.out.println(studnetMapper.InsertStudent(student));
	}
}
