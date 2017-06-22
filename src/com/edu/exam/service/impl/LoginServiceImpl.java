package com.edu.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.User;
import com.edu.exam.mapper.LoginMapper;
import com.edu.exam.mapper.StudentMapper;
import com.edu.exam.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	User user = null  ;
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private StudentMapper studentMapper ;
	@Override
	public User login(String username, String password) {
		
		user.setUsername(username);
		
		user.setPassword(password);
		
		//验证是否存在该用户
		User validateUser = loginMapper.validateUser(user);
		//无该用户
		if(validateUser==null){
			return null ;
		}
		//管理员
		if("01".equals(validateUser.getRole())){
			return validateUser ;
		}
		//学生
		if("02".equals(validateUser.getRole())){
			//根据username查询学生所有信息
			Student student = studentMapper.getStudentByUserName(validateUser.getUsername());
			validateUser.setObj(student);
			return validateUser ;
		}
		return null;
	}
	@Override
	public void Register(Student student) {
		studentMapper.InsertStudent(student);
	}

}
