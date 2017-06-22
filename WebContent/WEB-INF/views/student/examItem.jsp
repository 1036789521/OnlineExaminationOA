<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/commons/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/commons/js.jsp"></jsp:include>
<title>${param.exam_name}考试页面</title>
<style type="text/css">
.shuoming li {
	padding-top: 5px;
	font-size: 15px;
}
.ool li {
	font-size: 16px;
	padding-top: 4px;
	margin-left: 25px;
}
ol {
	padding-top: 3px;
}
label {
	padding-top: 7px;
	font-size: 16px;
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/sources/js/jquery.min.js"></script>
<script type="text/javascript">
	function saveMessage() {
		var result = $("input[name^='student_answer_']:checked").map(
				function() {
					return $(this).val();
				}).get().join(",");
		var uri = "savePaperAnswer";
		//将做题答案封装后放入隐藏域中
		$(".result").val(result);
		$("#myForm").attr("action", uri).submit();
		return false;
	}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/commons/head.jsp"></jsp:include>
	<div class="content" style="width: 100%; margin-left: 0;">
		<div class="breadLine" style="width: 100%;"></div>
		<div class="workplace">
			<h2 style="text-align: center;">${exam.name}—考试</h2>
			<p style="font-size: 18px;">注意事项：</p>
			<ol type="1" class="shuoming">
				<li>本试卷为移动网络维护代维人员的专业技能测试题，考试时间为120分钟，采取闭卷考试。</li>
				<li>应考人员在答题前，请将所在公司名称、本人姓名认真准确地填写在试卷纸上。</li>
				<li>请应考人员将答案写在试卷上。答题时，要字迹工整，保持卷面干净。</li>
				<li>应考人员应严格遵守考场纪律，服从监考人员的监督和管理，凡考场舞弊不听劝阻或警告者，监考
					人员有权终止其考试资格，没收试卷，以0分处理，并报所在公司部门予以处理。</li>
				<li>正式考试计时从点击答题按扭时算起，到90分钟时系统自动提交试卷。考试结束前10分钟，系统将提醒一次。</li>
				<li>如遇断网或断电，无法继续考试时，请与网管联系，电话为010-59192774。</li>
				<li>考生应尽量对每道题做出选项，不要浪费机会。</li>
			</ol>
			<hr />
			<c:if test="${empty itemList}">
				<p>该试卷没有试题</p>
			</c:if>
			<form:form method="post" id="myForm">
			<input type="hidden"  name="result" class="result"  >
			<input type="hidden"  name="examId" value="${exam.id}" >
			<input type="hidden" name="student_id" value="${student.id}">
			<input type="hidden" name="paper_id" value="${param.paperid}">
			<h3>一、选择题</h3>
				<c:forEach items="${itemList}" var="itemlists" varStatus="s">
					<c:forEach items="${itemlists.item}" var="items">
					<c:if test="${items.questionid==1}">
						<input type="hidden" name="item_id" value="${itemlists.item_id}">
						<input type="hidden" name="answer_item" value="${items.answer}">
						<input type="hidden" name="score" value="${itemlists.score}">
						<label>${s.index+1}、${items.question}(${itemlists.score}分)</label>
						<ol type="A" style="padding-top: 1px;" class="ool">
							<c:if test="${items.option_A!=null}">
								<li><input type="radio" name="student_answer_${s.index}"
									id="aa_${s.index}_1" value="${items.option_A}">
									${items.option_A}</li>
							</c:if>
							<c:if test="${items.option_B!=null}">
								<li><input type="radio" name="student_answer_${s.index}"
									id="aa_${s.index}_2" value="${items.option_B}">
									${items.option_B}</li>
							</c:if>
							<c:if test="${items.option_C!=null}">
								<li><input type="radio" name="student_answer_${s.index}"
									id="aa_${s.index}_3" value="${items.option_C}">
									${items.option_C}</li>
							</c:if>
							<c:if test="${items.option_D!=null}">
								<li><input type="radio" name="student_answer_${s.index}"
									id="aa_${s.index}_4" value="${items.option_D}">
									${items.option_D}</li>
							</c:if>
						</ol>
						</c:if>
					</c:forEach>
				</c:forEach>
				
						<h3>二、判断题</h3>
				<c:forEach items="${itemList}" var="itemlists" varStatus="s">
					<c:forEach items="${itemlists.item}" var="items">
					<c:if test="${items.questionid==2}">
						<input type="hidden" name="student_id" value="1">
						<input type="hidden" name="paper_id" value="${param.paperid}">
						<input type="hidden" name="exam_id" value="${param.examid}">
						<input type="hidden" name="item_id" value="${itemlists.item_id}">
						<input type="hidden" name="answer_item" value="${items.answer}">
						<input type="hidden" name="score" value="${itemlists.score}">
						<label>${s.index+1}、${items.question}(${itemlists.score}分)</label>
						<ol type="A" style="padding-top: 1px;" class="ool">
						<input type="radio" name="student_answer_${s.index}" value="正确">正确&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<input type="radio" name="student_answer_${s.index}" value="错误">错误
						</ol>
						</c:if>
					</c:forEach>
				</c:forEach>
				<div align="center" >
				<input type="submit" value="交卷" align="middle"  onclick="saveMessage();"
					style="width: 100px; margin-top: 10px;">
					</div>
			</form:form>
		</div>
	</div>
</body>
</html>