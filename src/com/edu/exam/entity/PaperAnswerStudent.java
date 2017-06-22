package com.edu.exam.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class PaperAnswerStudent implements Serializable {
	private static final long serialVersionUID = -5359521925956012847L;
	private int id;
	private int student_id;
	private int paper_id;
	private int item_id;
	private String answer_item;
	private String student_answer;
	private int score;

	public PaperAnswerStudent() {
		// TODO Auto-generated constructor stub
	}

	public PaperAnswerStudent(int student_id, int paper_id, int item_id, String answer_item, String student_answer,
			int score) {
		super();
		this.student_id = student_id;
		this.paper_id = paper_id;
		this.item_id = item_id;
		this.answer_item = answer_item;
		this.student_answer = student_answer;
		this.score = score;
	}

	public PaperAnswerStudent(int id, int student_id, int paper_id, int item_id, String answer_item,
			String student_answer) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.paper_id = paper_id;
		this.item_id = item_id;
		this.answer_item = answer_item;
		this.student_answer = student_answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getAnswer_item() {
		return answer_item;
	}

	public void setAnswer_item(String answer_item) {
		this.answer_item = answer_item;
	}

	public String getStudent_answer() {
		return student_answer;
	}

	public void setStudent_answer(String student_answer) {
		this.student_answer = student_answer;
	}

	@Override
	public String toString() {
		return "PaperAnswerStudent [id=" + id + ", student_id=" + student_id + ", paper_id=" + paper_id + ", item_id="
				+ item_id + ", answer_item=" + answer_item + ", student_answer=" + student_answer + ", score=" + score
				+ "]";
	}

}
