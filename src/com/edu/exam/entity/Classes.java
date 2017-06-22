package com.edu.exam.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Classes {

	private int id;
	private String className;
	private String classType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date classBeginDate;
	private String classDuration;
	private String classStatus;
	private String adviserName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date adviserEntry_time;
	private String adviserWork_experience;
	private String adviserStatus;
	private String trainerName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date trainerEntry_time;
	private String trainerWork_experience;
	private String trainerStatus;

	public Classes() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Date getClassBeginDate() {
		return classBeginDate;
	}

	public void setClassBeginDate(Date classBeginDate) {
		this.classBeginDate = classBeginDate;
	}

	public String getClassDuration() {
		return classDuration;
	}

	public void setClassDuration(String classDuration) {
		this.classDuration = classDuration;
	}

	public String getClassStatus() {
		return classStatus;
	}

	public void setClassStatus(String classStatus) {
		this.classStatus = classStatus;
	}

	public String getAdviserName() {
		return adviserName;
	}

	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}

	public Date getAdviserEntry_time() {
		return adviserEntry_time;
	}

	public void setAdviserEntry_time(Date adviserEntry_time) {
		this.adviserEntry_time = adviserEntry_time;
	}

	public String getAdviserWork_experience() {
		return adviserWork_experience;
	}

	public void setAdviserWork_experience(String adviserWork_experience) {
		this.adviserWork_experience = adviserWork_experience;
	}

	public String getAdviserStatus() {
		return adviserStatus;
	}

	public void setAdviserStatus(String adviserStatus) {
		this.adviserStatus = adviserStatus;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Date getTrainerEntry_time() {
		return trainerEntry_time;
	}

	public void setTrainerEntry_time(Date trainerEntry_time) {
		this.trainerEntry_time = trainerEntry_time;
	}

	public String getTrainerWork_experience() {
		return trainerWork_experience;
	}

	public void setTrainerWork_experience(String trainerWork_experience) {
		this.trainerWork_experience = trainerWork_experience;
	}

	public String getTrainerStatus() {
		return trainerStatus;
	}

	public void setTrainerStatus(String trainerStatus) {
		this.trainerStatus = trainerStatus;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", className=" + className + ", classType=" + classType + ", classBeginDate="
				+ classBeginDate + ", classDuration=" + classDuration + ", classStatus=" + classStatus
				+ ", adviserName=" + adviserName + ", adviserEntry_time=" + adviserEntry_time
				+ ", adviserWork_experience=" + adviserWork_experience + ", adviserStatus=" + adviserStatus
				+ ", trainerName=" + trainerName + ", trainerEntry_time=" + trainerEntry_time
				+ ", trainerWork_experience=" + trainerWork_experience + ", trainerStatus=" + trainerStatus + "]";
	}

}