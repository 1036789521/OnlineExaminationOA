package com.edu.exam.service;

import com.edu.exam.entity.Student;
import com.edu.exam.entity.User;

public interface LoginService {
	/**
	 * 用户登录验证
	 * @param username 用户名
	 * @param password 密码
	 * */
	public User login(String username,String password);
	
	public void Register(Student student );
}
