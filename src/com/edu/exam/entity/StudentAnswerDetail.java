package com.edu.exam.entity;

import org.springframework.stereotype.Component;

@Component
public class StudentAnswerDetail {
	//学生id
	private int  studentId ;
	//试卷名称
	private String paperName ;
	//考试总得分
	private int score ;
	//试题id
	private int itemId ; 
	//问题
	private String question ;
	//问题类型
	private String typeId;
	//A选项
	private String optionA ;
	//B选项
	private String optionB ;
	//C选项
	private String optionC ;
	//D选项
	private String optionD ;
	//学生答案
	private String studentAnswer ;
	//标准答案
	private String paperAnswer ;
	//本题分值
	private int value ;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	public String getPaperAnswer() {
		return paperAnswer;
	}
	public void setPaperAnswer(String paperAnswer) {
		this.paperAnswer = paperAnswer;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "StudentAnswerDetail [studentId=" + studentId + ", paperName=" + paperName + ", score=" + score
				+ ", itemId=" + itemId + ", question=" + question + ", typeId=" + typeId + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", studentAnswer="
				+ studentAnswer + ", paperAnswer=" + paperAnswer + ", value=" + value + "]";
	}
	
}
