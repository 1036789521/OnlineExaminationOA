package com.edu.exam.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.exam.entity.Classes;
import com.edu.exam.entity.Item_t;
import com.edu.exam.mapper.AdminMapper;
import com.edu.exam.service.Admin;



@Service
public class AdminServiceImpl implements Admin {
	@Autowired
	private AdminMapper classesMapper;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public int deleteClasses(String classesName) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		System.out.println("service");
		int line =classesMapper.deleteClasses(classesName);
		return line;
	}
	
	@Override
	public List<Classes> findAllClasses() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		List<Classes>allClassesList = classesMapper.findAllClasses();
		return allClassesList;
	}

	
	@Override
	public int addClasses(Classes c) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		String classesName = c.getClassName();
		System.out.println(c.getClassBeginDate());
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		int i = classesMapper.addClasses(c);
		
		System.out.println("chenggongle=================");
		return i;
	}

	@Override
	public List<Classes> findClasses(String classesName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		List<Classes> classesList = classesMapper.findClasses(classesName);
		System.out.println(Arrays.asList(classesList));
		return classesList;
	}

	@Override
	public int addAdvisor(Classes c) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
//		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		int i = classesMapper.addAdvisor(c);
		System.out.println("chenggongleAdvisor=================");
		return i;
	}

	@Override
	public List<Classes> findAdvisor(String advisorName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		List<Classes> advisorList = classesMapper.findAdvisor(advisorName);
		System.out.println(Arrays.asList(advisorList));
		return advisorList;
	}


	@Override
	public List<Classes> findAllAdviser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		List<Classes> allAdviserList = classesMapper.findAllAdviser();
		return allAdviserList;
	}

	@Override
	public int deleteAdviser(String adviserName) {
		System.out.println("======SERVICE delete ADviser====");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		int line =classesMapper.deleteClasses(adviserName);
		return line;
	}

	@Override
	public List<Item_t> findAllItem_t() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		List<Item_t> allItem_tList = classesMapper.findAllItem_t();
		return allItem_tList;
	}

	@Override
	public int updateClasses(Classes classes) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println("---------------------");
		System.out.println(classes);
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		classesMapper.updateClasses(classes);
		return 0;
	}

	@Override
	public Classes findClassesById(String classesid) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		classesMapper = sqlSession.getMapper(AdminMapper.class);
		
		return classesMapper.findClassesById(classesid);
	}

	


	
}
