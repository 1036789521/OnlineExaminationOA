package com.edu.exam.service;

import java.util.List;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;
public interface StudentService {
	//获取学生所有考试记录
	public List<Student_Exam> showPersonalExam(Student student);
	//修改学生密码
	public void modifyPwd(int id, String newPwd);
	//根据学生id查询学生信息
	public Student getStudentById(int id );
	//根据学生id更新学生信息并返回更新后的学生信息
	public Student updatePersonalById(Student student );
	//查询所有学生信息
	public List<Student> getAllStudents();
}
