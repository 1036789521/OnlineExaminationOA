package com.edu.exam.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;
import com.edu.exam.mapper.StudentMapper;
import com.edu.exam.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<Student_Exam> showPersonalExam(Student student) {
		return studentMapper.getExamsOfStudent(student.getId());
	}
	@Override
	public void modifyPwd(int id, String newPwd) {
		studentMapper.modifyPwd(id, newPwd);
	}
	@Override
	public Student getStudentById(int id) {
		
		return studentMapper.getStudentById(id);
	}
	@Override
	public Student updatePersonalById(Student student ) {
		
		studentMapper.updateStudentById(student);
		
		return studentMapper.getStudentById(student.getId());
		
	}
	@Override
	public List<Student> getAllStudents() {
		
		return studentMapper.getAll();
	}

}
