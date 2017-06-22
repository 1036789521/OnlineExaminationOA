package com.edu.exam.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
	// id
	private int id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 对应实体类 Admin或Student
	private Object obj;
	// 01：管理员 02：学生
	private String role;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", obj=" + obj + ", role=" + role + "]";
	}

}
