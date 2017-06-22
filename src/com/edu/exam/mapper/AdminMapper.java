package com.edu.exam.mapper;

import java.util.List;

import com.edu.exam.entity.Classes;
import com.edu.exam.entity.Item_t;

public interface AdminMapper {

	int addClasses(Classes classes);
	
	List<Classes> findClasses(String classesName);
	
	List<Classes> findAllClasses();
	
	int deleteClasses(String classesName);
	
	void updateClasses(Classes classes);
	
	Classes findClassesById(String classesid);
	
	int addAdvisor(Classes classes);
	
	List<Classes> findAllAdviser();
	
	List<Classes> findAdvisor(String classesName);
	
	int deleteAdviser(String classesName);
	
	List<Item_t> findAllItem_t();
	
}
