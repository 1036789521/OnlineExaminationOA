package com.edu.exam.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_paper_rt;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.PaperAnswerStudent;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Questiontype;
import com.edu.exam.mapper.StudentPaperMapper;
import com.edu.exam.service.StudentPaperService;

@Service
public class StudentPaperServiceImpl implements StudentPaperService {
	@Autowired
	private StudentPaperMapper studentPaperMapper;

	@Override
	public List<Item_paper_rt> getItemByPaperId(int id) {

		return studentPaperMapper.getItemByPaperId(id);
	}

	@Override
	public List<Questiontype> getQuestionType() {

		return studentPaperMapper.getQuestionTypes();
	}

	@Override
	public List<Integer> getXztList() {

		return studentPaperMapper.getXztList();
	}

	@Override
	public List<Integer> getPdtList() {

		return studentPaperMapper.getPdtList();
	}

	@Override
	public int addPaperInfo(Paper_t paper_t) {

		return studentPaperMapper.addPaper_t(paper_t);
	}

	@Override
	public int addXzts(List<Item_paper_rt> xzt_lis) {
		return studentPaperMapper.addXzts(xzt_lis);

	}

	@Override
	public int addPdts(List<Item_paper_rt> pdt_lis) {

		return studentPaperMapper.addPdts(pdt_lis);

	}

	@Override
	public int saveAnswerInfo(List<PaperAnswerStudent> pas) {

		return studentPaperMapper.saveAnswerInfo(pas);
	}

	@Override
	public int addScore(Map<String, Object> map) {

		return studentPaperMapper.addScore(map);
	}

	@Override
	public int additems(Item_t item_t) {

		return studentPaperMapper.additems(item_t);
	}

	@Override
	public Item_t getItemById(int item_id) {

		return studentPaperMapper.getItemById(item_id);
	}

	@Override
	public int deleteItemById(int item_id) {

		return studentPaperMapper.deleteItemById(item_id);
	}

	@Override
	public int updates(Item_t item_t) {

		return studentPaperMapper.updates(item_t);
	}

	@Override
	public List<Paper_t> getAllPapers() {

		return studentPaperMapper.getAllPapers();
	}

	@Override
	public List<Exam> getAllExams() {
		return studentPaperMapper.getAllExams();
	}

	@Override
	public Exam getExamById(int examId) {
		return studentPaperMapper.getExamById(examId);
	}

	@Override
	public int delPaperById(String paperId) {

		return studentPaperMapper.delPaperById(paperId);
	}

	@Override
	public int getScores(int studentId,List<String> result, String examId) {
		//学生所得分数
		int score = 0 ; 
		List<PaperAnswerStudent> pasList = new ArrayList<>();
		if(null!=examId&&!"".equals(examId)){
			int examIds =Integer.parseInt(examId);
			Exam exam = studentPaperMapper.getExamById(examIds);
			int paperId = exam.getPaperid();
			//获得本套试题并计算得分
			List<Item_paper_rt> list = studentPaperMapper.getItemByPaperId(paperId);
			//List<Item_t> items = studentPaperMapper.getItemsByPaperId(paperIds);
			//每道题的id、学生答案、标准答案、该题分值封装进PaperAnswerStudent表
			//TODO
			System.out.println("resultSize:");
			for(int i = 0 ;i<list.size();i++){
				PaperAnswerStudent pas =new PaperAnswerStudent();
				//题id
				int itemid = list.get(i).getItem_id();
				//学生答案
				String stuAnswer = result.get(i);
				//标准答案
				String answer = studentPaperMapper.getItemById(itemid).getAnswer();
				//该题分值
				int point = list.get(i).getScore();
				pas.setStudent_id(studentId);
				pas.setPaper_id(paperId);
				pas.setItem_id(itemid);
				pas.setStudent_answer(stuAnswer);
				pas.setAnswer_item(answer);
				pas.setScore(point);
				pasList.add(pas);
				//计算得分
				score += this.checked(pas);
			}
		}
		//将学生答题情况保存数据库
		if(pasList!=null){
			this.saveAnswerInfo(pasList);
			//得分添加到数据库
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("studentid", studentId);
			map.put("examid", examId);
			map.put("score", score);
			map.put("status", "已考试");
			studentPaperMapper.addScore(map);
		}
		return score ;
	}
		
	// 计算得分
	private int checked(PaperAnswerStudent pas) {

		// 答案一致，返回本题分值，否则返回0分
		if (pas.getAnswer_item().equals(pas.getStudent_answer())) {
			return pas.getScore();
		}
		return 0;
	}

}
