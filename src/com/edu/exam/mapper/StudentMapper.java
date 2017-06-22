package com.edu.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;

public interface StudentMapper {
	//取得所有学生信息
	public List<Student> getAll();
	//根据id查找对应学生的考试信息
	public List<Student_Exam> getExamsOfStudent(int studentid);
	//修改学生密码
	public void modifyPwd(@Param("id")int id,@Param("newPwd")String newPwd);
	//根据id查学生信息
	public Student getStudentById(int id );
	//根据id更新学生信息
	public void updateStudentById(Student student );
	//根据username查询学生信息
	public Student getStudentByUserName(@Param("username")String username);
	//注册学生用户
	public int InsertStudent(Student student);
}
