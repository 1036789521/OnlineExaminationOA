package com.edu.exam.mapper;

import java.util.List;
import java.util.Map;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_paper_rt;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.PaperAnswerStudent;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Questiontype;

public interface StudentPaperMapper {

	List<Item_paper_rt> getItemByPaperId(int id);

	List<Questiontype> getQuestionTypes();

	List<Integer> getXztList();

	List<Integer> getPdtList();

	int addPaper_t(Paper_t paper_t);
	
	//根据id删除试卷
	public int delPaperById(String paperId) ;

	int addXzts(List<Item_paper_rt> xzt_lis);

	int addPdts(List<Item_paper_rt> pdt_lis);

	int saveAnswerInfo(List<PaperAnswerStudent> pas);

	int addScore(Map<String, Object> map);

	int additems(Item_t item_t);
	//根据item_id查询对应试题
	Item_t getItemById(int item_id);

	int deleteItemById(int item_id);

	int updates(Item_t item_t);
	//查询所有试卷
	public List<Paper_t> getAllPapers();
	//查询所有考试
	public List<Exam> getAllExams();
	//根据id查询考试安排信息
	public Exam getExamById(int examId);
	//根据paperId查询查询所有本套试题
	public  List<Item_t> getItemsByPaperId(int paperId);
		
}
