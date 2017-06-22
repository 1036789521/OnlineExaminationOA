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
<title>${param.exam_name}考试结果查询</title>
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
</head>
<body>
	<jsp:include page="/WEB-INF/commons/head.jsp"></jsp:include>
	<div class="content" style="width: 100%; margin-left: 0;">
		<div class="breadLine" style="width: 100%;"></div>
		<div class="workplace">
			<h2 style="text-align: center;">${exam.name}—结果查询</h2>
			<h4 style="color:red ;text-align: right;">考试分数：98分</h4>
			<hr />
			<form:form method="post" id="myForm">
			<input type="hidden"  name="result" class="result"  >
			<input type="hidden"  name="examId" value="${exam.id}" >
			<input type="hidden" name="student_id" value="${student.id}">
			<input type="hidden" name="paper_id" value="${param.paperid}">
			<h3>一、选择题</h3>
				<c:forEach items="${itemList}" var="itemlists" varStatus="s">
					<c:forEach items="${itemlists.item}" var="items">
					<c:if test="${items.questionid==1}">
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
				<c:forEach items="${itemList}" var="itemlists" varStatus="s">
					<c:forEach items="${itemlists.item}" var="items">
					<c:if test="${items.questionid==2}">
						<h3>二、判断题</h3>
						<label>${s.index+1}、${items.question}(${itemlists.score}分)</label>
						<ol type="A" style="padding-top: 1px;" class="ool">
						<input type="radio" name="student_answer_${s.index}" value="正确">正确&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<input type="radio" name="student_answer_${s.index}" value="错误">错误
						</ol>
						</c:if>
					</c:forEach>
				</c:forEach>
				<div align="center" >
				<input type="button" value="返回首页" align="middle"  onclick="backIndex();"
					style="width: 100px; margin-top: 10px;">
					</div>
					<c:if test=""></c:if>
					<c:otherwise></c:otherwise>
					<c:choose>
					<c:when test=""></c:when>
					<c:when test=""></c:when>
					<c:otherwise>
					
					</c:otherwise>
					</c:choose>
			</form:form>
		</div>
	</div>
</body>
</html>