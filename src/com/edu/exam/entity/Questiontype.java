package com.edu.exam.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Administrator 题目的类型
 */
@Component
public class Questiontype implements Serializable {

	private static final long serialVersionUID = 331948823920236260L;
	private int id;
	private String questiontype;

	public Questiontype() {
		// TODO Auto-generated constructor stub
	}

	public Questiontype(String questiontype) {
		super();
		this.questiontype = questiontype;
	}

	public Questiontype(int id, String questiontype) {
		super();
		this.id = id;
		this.questiontype = questiontype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	@Override
	public String toString() {
		return "Questiontype [id=" + id + ", questiontype=" + questiontype + "]";
	}

}
