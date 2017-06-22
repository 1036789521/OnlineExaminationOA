package com.edu.exam.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_paper_rt;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Questiontype;
import com.edu.exam.mapper.StudentPaperMapper;
import com.edu.exam.service.impl.StudentPaperServiceImpl;

@ContextConfiguration("/application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentPaperTest {
	@Autowired
	private StudentPaperMapper studentPaperMapper;
	@Autowired
	private StudentPaperServiceImpl studentPaperServiceImpl;
	@Test
	public void test1() {
		List<Item_paper_rt> list = studentPaperMapper.getItemByPaperId(1);
		for (Item_paper_rt item_paper_rt : list) {
			System.out.println(item_paper_rt);
		}
	}

	@Test
	public void test2() {
		List<Questiontype> list = studentPaperMapper.getQuestionTypes();
		System.out.println(Arrays.asList(list));
	}

	@Test
	public void test3() {
		List<Integer> xzt = studentPaperMapper.getXztList();
		System.out.println(Arrays.asList(xzt));
	}

	@Test
	public void test4() {
		List<Integer> pdt = studentPaperMapper.getPdtList();
		System.out.println(Arrays.asList(pdt));
	}

	@Test
	public void test5() {
		Paper_t paper_t = new Paper_t("300期java测试1", 100);
		int i = studentPaperMapper.addPaper_t(paper_t);
		System.out.println(paper_t);
		System.out.println(i);
	}

	@Test
	public void test6() {
		List<Item_paper_rt> li = new ArrayList<>();
		li.add(new Item_paper_rt(2, 2, 5));
		li.add(new Item_paper_rt(3, 2, 5));
		li.add(new Item_paper_rt(4, 2, 5));
		li.add(new Item_paper_rt(7, 2, 5));
		li.add(new Item_paper_rt(13, 2, 5));
		int i = studentPaperMapper.addXzts(li);
		System.out.println(i);
	}

	@Test
	public void test8() {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("studentid", 1);
		hashMap.put("examid", 1);
		hashMap.put("score", 70);
		hashMap.put("status", "已考试");
		int i = studentPaperMapper.addScore(hashMap);
		System.out.println(i);
	}
	@Test
	public void test9(){
		//List<Exam> exams = studentPaperMapper.getAllExams();
		List<Exam> exams = studentPaperServiceImpl.getAllExams();
		System.out.println(exams);
	}
}
