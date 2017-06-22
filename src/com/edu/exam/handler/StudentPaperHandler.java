package com.edu.exam.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.exam.entity.Exam;
import com.edu.exam.entity.Item_paper_rt;
import com.edu.exam.entity.Item_t;
import com.edu.exam.entity.PaperAnswerStudent;
import com.edu.exam.entity.Paper_t;
import com.edu.exam.entity.Questiontype;
import com.edu.exam.entity.Student;
import com.edu.exam.entity.Student_Exam;
import com.edu.exam.service.StudentPaperService;
import com.edu.exam.service.StudentService;
import com.edu.exam.utils.AddPaperUtil;

/**
 * 处理试卷及题目的handler类
 */
@Controller
@RequestMapping("/studentpaper")
public class StudentPaperHandler {
	@Autowired
	private StudentPaperService studentPaperService;
	@Autowired
	StudentService studentService ;
	/**
	 * @param id
	 *            试卷的Id
	 * @param map
	 *            根据试卷id得到的试卷所有题目
	 * @return    考试页面 
	 */
	@RequestMapping("/exam")
	public String intexamjsp(@RequestParam("paperid") int id,@RequestParam("examid") int examId, Map<String, Object> map, HttpServletRequest request) {
		List<Item_paper_rt> itemList = studentPaperService.getItemByPaperId(id);
		Exam exam = studentPaperService.getExamById(examId);
		map.put("itemList", itemList);
		map.put("exam", exam);
		return "student/examItem";
	}

	/**
	 * @param map
	 *            得到题目的所有类型[选择题、填空题....]
	 * @return 跳转
	 */
	@RequestMapping("/getreqestiontypes")
	public String questionType(Map<String, Object> map) {
		List<Questiontype> questiontype = studentPaperService.getQuestionType();
		map.put("questiontypes", questiontype);
		map.put("item_t", new Item_t());
		
		return "student/additem";

	}
	/**
	 * 数据回显
	 * 
	 * @param item_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/oprationItems/{item_id}", method = RequestMethod.GET)
	public String updateItem(@PathVariable("item_id") int item_id, Map<String, Object> map) {
		List<Questiontype> questiontype = studentPaperService.getQuestionType();
		//通过id查询题目
		Item_t item_ts = studentPaperService.getItemById(item_id);
		//将题目类型和试题放入map中
		map.put("questiontypes", questiontype);
		map.put("item_t", item_ts);
		//判断题目类型
		switch(item_ts.getQuestionid()){
		case 1: return "student/additem";
		case 2: return "student/additem2";
		//TODO 问答题待扩展
		case 3: break;
		default : return "student/additem"; 
		}
		return null;
	}

	/**
	 * 转到添加页面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/oprationItems", method = RequestMethod.GET)
	public String addItem(Map<String, Object> map) {
		List<Questiontype> questiontype = studentPaperService.getQuestionType();
		map.put("questiontypes", questiontype);
		map.put("item_t", new Item_t());
		return "student/additem";
	}
	/**
	 * 
	 * 跳转增加填空题页面
	 * @param 
	 * @return
	 */
	@RequestMapping(value ="/additem2", method = RequestMethod.GET)
	public String additem2(Map<String, Object> map) {
		List<Questiontype> questiontype = studentPaperService.getQuestionType();
		map.put("questiontypes", questiontype);
		map.put("item_t", new Item_t());
		return "student/additem2";
		
	}
	/**
	 * 考试完成提交试卷计算结果并跳转首页
	 * @param request
	 * @param response
	 * @return 查看考试记录页面
	 */
	@RequestMapping("/savePaperAnswer")
	public String savePaperAnswer(HttpServletRequest request,HttpServletResponse response) {
		String result = request.getParameter("result");
		String examId = request.getParameter("examId");
		Student student =(Student)request.getSession().getAttribute("student");
		int studentId = student.getId();
		int scores = 0 ;
		//截取学生答案
		String stu_answer[] = result.split(",");
		List<String> stu_answerlist = new ArrayList<>();
		for (int i = 0; i < stu_answer.length; i++) {
			stu_answerlist.add(stu_answer[i]);			
			}
		//计算得分
	    scores = studentPaperService.getScores(studentId,stu_answerlist, examId);
	    System.out.println("scores:"+scores);
		return "redirect:/student/showExam";
	}
	/**
	 * 考试完成提交试卷计算结果并跳转首页
	 * @param request
	 * @param response
	 * @return 查看考试记录页面
	 */
	@RequestMapping("/examResult")
	public String examResult(Map<String, Object> map,HttpServletRequest request,HttpServletResponse response,@RequestParam("studentid") int studentId,@RequestParam("paperid") int paperId) {
		Student student = (Student) request.getSession().getAttribute("student");
		//试卷信息
		map.put("ExamList", studentService.showPersonalExam(student));
		//答题信息
		
		//TODO
		return "student/examResult";
	}
	

	/**
	 * 添加成绩的方法
	 * 
	 * @param map
	 * @return
	 */
	public int addScores(Map<String, Object> map) {
		int i = studentPaperService.addScore(map);
		return i;
	}

	/**
	 * 跳转到添加试卷页面
	 * 
	 * @return
	 */
	@RequestMapping("/addpaper")
	public String addpaper() {
		
		return "student/addpaper";

	}
	/**
	 * 删除试卷
	 * 
	 * @return 
	 */
	@RequestMapping("/delpaper")
	public String delpaper(@RequestParam("paperId") String paperId) {
		studentPaperService.delPaperById(paperId);
		return "redirect:/admin/tables";
	}

	/**
	 * 生成试卷的方法
	 * 
	 * @param xuanzeti
	 *            该试卷的选择题的个数
	 * @param panduanti
	 *            该试卷的判断题的个数
	 * @param xuanzeti_score
	 *            该试卷每个选择题的分数
	 * @param panduanti_score
	 *            该试卷每个判断题的分数
	 * @param papername
	 *            该试卷的名字
	 * @param count
	 *            该试卷的总分
	 * @return
	 */
	@RequestMapping("/addpaperItem")
	public String addpaperItem(@RequestParam("xuanzeti") int xuanzeti, @RequestParam("panduanti") int panduanti,
			@RequestParam("xuanzeti_score") int xuanzeti_score, @RequestParam("panduanti_score") int panduanti_score,
			@RequestParam("papername") String papername, @RequestParam("count") int count,@RequestParam("paperType") String paperType) {
		// 得到所有选择题的集合
		List<Integer> xzt = studentPaperService.getXztList();
		// 得到所有判断题的集合
		List<Integer> pdt = studentPaperService.getPdtList();
		// 随机选择的选择题的id集合
		HashSet<Integer> xztid = AddPaperUtil.getranadom(xuanzeti, xzt);
		// 随机选择的判断题的id集合
		HashSet<Integer> pdtid = AddPaperUtil.getranadom(panduanti, pdt);


		Paper_t paper_t = new Paper_t(papername,paperType, count);
		// 添加试题卷的信息
		int i = studentPaperService.addPaperInfo(paper_t);
		// 返回添加试题的id
		int paper_id = paper_t.getPaper_id();

		// 封装获取随机选择题的关系类，以便一次插入多条数据
		List<Item_paper_rt> xzt_lis = new ArrayList<>();
		for (Integer integer_id : xztid) {
			Item_paper_rt rt = new Item_paper_rt(integer_id, paper_id, xuanzeti_score);
			xzt_lis.add(rt);
		}

		// 封装随机获取的判断题的关系类，以便一次插入多条数据
		List<Item_paper_rt> pdt_lis = new ArrayList<>();
		for (Integer integer_id : pdtid) {
			Item_paper_rt rt = new Item_paper_rt(integer_id, paper_id, panduanti_score);
			pdt_lis.add(rt);
		}

		// 添加的方法
		int addxzt = studentPaperService.addXzts(xzt_lis);
		int addpdt = studentPaperService.addPdts(pdt_lis);
		return "redirect:/admin/tables";

	}

	/**
	 * 添加数据
	 * 
	 * @param item_t
	 * @return
	 */
	@RequestMapping(value = "/oprationItems", method = RequestMethod.POST)
	public String addItems(Item_t item_t) {
		int additem = studentPaperService.additems(item_t);
		
		return "redirect:/admin/statistic";
	}

	
	/**
	 * 更新数据
	 * 
	 * @param item_t
	 * @return
	 */
	@RequestMapping(value = "/oprationItems", method = RequestMethod.PUT)
	public String updates(Item_t item_t) {
		
		int i = studentPaperService.updates(item_t);
		
		return "redirect:/admin/statistic";

	}

	/**
	 * 删除试题
	 * 
	 * @param item_id
	 * @return
	 */
	@RequestMapping("/deleteItem")
	public String delete(@RequestParam("itemid") int item_id) {
		int i = studentPaperService.deleteItemById(item_id);
		
		return "redirect:/admin/statistic";
		
	}
	
}
