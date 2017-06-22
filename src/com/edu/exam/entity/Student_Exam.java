package com.edu.exam.entity;

import org.springframework.stereotype.Component;

@Component
public class Student_Exam {

	private int id ;
	private double score ;
	private String status ;
	private Student student ;
	private Exam exam ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
