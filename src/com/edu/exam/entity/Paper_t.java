package com.edu.exam.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Paper_t {

	private int paper_id;
	
	private String paperType;
	
	private String papername;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate ; 
	
	private int count;

	public Paper_t() {
	}

	public Paper_t(String papername, int count) {
		super();
		this.papername = papername;
		this.count = count;
	}
	public Paper_t(String papername,String paperType, int count) {
		super();
		this.papername = papername;
		this.paperType = paperType;
		this.count = count;
	}

	public Paper_t(int paper_id, String papername, int count) {
		super();
		this.paper_id = paper_id;
		this.papername = papername;
		this.count = count;
	}

	public Paper_t(int paper_id, String paperType, String papername, int count) {
		super();
		this.paper_id = paper_id;
		this.paperType = paperType;
		this.papername = papername;
		this.count = count;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Paper_t [paper_id=" + paper_id + ", paperType=" + paperType + ", papername=" + papername
				+ ", createDate=" + createDate + ", count=" + count + "]";
	}
	
	

}
