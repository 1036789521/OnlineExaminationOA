package com.edu.exam.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Administrator 试题的内容
 */
@Component
public class Item_t implements Serializable {
	private static final long serialVersionUID = 6878943282136603936L;
	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private int questionid;
	private String answer;

	public Item_t() {
		// TODO Auto-generated constructor stub
	}

	public Item_t(int id, String question, String option_A, String option_B, String option_C, String option_D,
			int questionid, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
		this.questionid = questionid;
		this.answer = answer;
	}

	public Item_t(String question, String option_A, String option_B, String option_C, String option_D, int questionid,
			String answer) {
		super();
		this.question = question;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
		this.questionid = questionid;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_A() {
		return option_A;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public String getOption_B() {
		return option_B;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public String getOption_C() {
		return option_C;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public String getOption_D() {
		return option_D;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Item_t [id=" + id + ", question=" + question + ", option_A=" + option_A + ", option_B=" + option_B
				+ ", option_C=" + option_C + ", option_D=" + option_D + ", questionid=" + questionid + ", answer="
				+ answer + "]";
	}

}
