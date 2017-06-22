package com.edu.exam.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Exam {

	private int id ;
	private String name ;
	private Date begin_time ;
	private Date over_time ;
	private int paperid ;
	private String className ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}
	public Date getOver_time() {
		return over_time;
	}
	public void setOver_time(Date over_time) {
		this.over_time = over_time;
	}
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", begin_time=" + begin_time + ", over_time=" + over_time
				+ ", paperid=" + paperid + ", className=" + className + "]";
	}
	
}
