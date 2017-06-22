package com.edu.exam.service;

import java.util.List;
import java.util.Map;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_paper_rt;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.PaperAnswerStudent;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Questiontype;

public interface StudentPaperService {

	public List<Item_paper_rt> getItemByPaperId(int id);

	public List<Questiontype> getQuestionType();

	public List<Integer> getXztList();

	public List<Integer> getPdtList();

	public int addPaperInfo(Paper_t paper_t);
	
	public int delPaperById(String paperId);

	public int addXzts(List<Item_paper_rt> xzt_lis);

	public int addPdts(List<Item_paper_rt> pdt_lis);

	public int saveAnswerInfo(List<PaperAnswerStudent> pas);

	public int addScore(Map<String, Object> map);

	public int additems(Item_t item_t);

	public Item_t getItemById(int item_id);

	public int deleteItemById(int item_id);

	public int updates(Item_t item_t);
	
	public List<Paper_t> getAllPapers();
	//查询所有考试
	public List<Exam> getAllExams();
	//根据id查询考试安排信息
	public Exam getExamById(int examId);
	//计算学生得分
	public int getScores (int studentId ,List<String> result,String examId);
}
