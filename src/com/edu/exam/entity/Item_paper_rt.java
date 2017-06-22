package com.edu.exam.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Item_paper_rt implements Serializable {

	private static final long serialVersionUID = -2130629694174696475L;
	private int id;
	private int item_id;
	private int per_id;
	private int score;
	private Set<Item_t> item;

	public Item_paper_rt() {
		// TODO Auto-generated constructor stub
	}

	public Item_paper_rt(int id, int item_id, int per_id, int score) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.per_id = per_id;
		this.score = score;
	}

	public Item_paper_rt(int item_id, int per_id, int score) {
		super();
		this.item_id = item_id;
		this.per_id = per_id;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Set<Item_t> getItem() {
		return item;
	}

	public void setItem(Set<Item_t> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Item_paper_rt [id=" + id + ", item_id=" + item_id + ", per_id=" + per_id + ", score=" + score
				+ ", item=" + item + "]";
	}

}
