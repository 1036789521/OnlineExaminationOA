package com.edu.exam.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class Student {
	private int id ;
	private String username ;
	private String password ;
	private String name ;
	private String agender;
	private String natives ;
	private String phone ;
	private String school ;
	private String status;
	private Date enter_time ;
	private String file ;
	private Date birthday ;
	private String type ;
	private String role ;
	private String email ;
	private Classes classes ;
	public Student(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAgender() {
		return agender;
	}
	public void setAgender(String agender) {
		this.agender = agender;
	}
	public String getNatives() {
		return natives;
	}
	public void setNatives(String natives) {
		this.natives = natives;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Date enter_time) {
		this.enter_time = enter_time;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", agender=" + agender + ", natives=" + natives + ", phone=" + phone + ", school=" + school
				+ ", status=" + status + ", enter_time=" + enter_time + ", file=" + file + ", birthday=" + birthday
				+ ", type=" + type + ", role=" + role + ", email=" + email + ", classes=" + classes + "]";
	}
	
	
	
	
}
