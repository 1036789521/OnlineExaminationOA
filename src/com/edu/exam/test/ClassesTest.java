package com.edu.exam.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.exam.entity.Classes;
import com.edu.exam.mapper.AdminMapper;
@ContextConfiguration("/application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClassesTest {
	@Autowired
	private AdminMapper adminMapper;
	
	@Test
	public void findClassesById(){
		Classes classes = adminMapper.findClassesById("2");
		System.out.println(classes);
	}
}
