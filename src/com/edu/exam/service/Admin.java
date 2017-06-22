package com.edu.exam.service;

import java.util.List;

import com.edu.exam.entity.Classes;
import com.edu.exam.entity.Item_t;

public interface Admin {
	int addClasses(Classes c);
	List<Classes> findClasses(String classesName);
	List<Classes> findAllClasses();
	int deleteClasses(String classesName);
	int updateClasses(Classes classes);
	int addAdvisor(Classes c);
	List<Classes> findAllAdviser();
	List<Classes> findAdvisor(String classesName);
	int deleteAdviser(String adviserName);
	List<Item_t> findAllItem_t();
	Classes findClassesById (String id );
}
