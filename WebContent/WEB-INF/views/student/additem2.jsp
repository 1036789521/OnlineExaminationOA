<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/commons/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/commons/js.jsp"></jsp:include>
<style type="text/css">
td {
	font-size: 18px;
}
</style>
<title>添加试卷</title>
</head>
<body>
	<!-- 头 -->
	<div class="header">
		<ul class="header_menu">
			<li class="list_icon"><a href="#">&nbsp;</a></li>
		</ul>
	</div>
	<div class="menu">
		<div class="breadLine">
			<div class="arrow"></div>
			<div class="adminControl active">Hi, 尊敬的管理员</div>
		</div>
		<!-- 管理员 -->
		<div class="admin">
			<div class="image">
				<img
					src="${pageContext.request.contextPath }/sources/img/users/aqvatarius.jpg"
					class="img-polaroid" />
			</div>
			<ul class="control">
				<li><span class="icon-share-alt"></span> <a href="login.html">退出</a></li>
			</ul>
		</div>
		<ul class="navigation">
			<!-- 项目总结报告 -->
			<li ><a href="test"> <span class="isw-grid"></span><span
					class="text">班级管理</span>
			</a></li>
			<!-- 项目情况进展表 -->
			<li><a href="${pageContext.request.contextPath}/admin/ui"> <span
					class="isw-list"></span><span class="text">班主任管理</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/forms">
					<span class="isw-archive"></span><span class="text">学生管理</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/messages">
					<span class="isw-chat"></span><span class="text">讲师管理</span>
			</a></li>
			<li class="active"><a href="${pageContext.request.contextPath}/admin/statistic">
					<span class="isw-graph"></span><span class="text">试题管理</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/tables">
					<span class="isw-text_document"></span><span class="text">试卷管理</span>
			</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/user">
					<span class="isw-documents"></span><span class="text">考试管理</span>
			</a></li>
		</ul>
		<div class="dr">
			<span></span>
		</div>
	</div>
	<div class="content">
		<div class="breadLine">
			<ul class="breadcrumb">
				<li><a>管理员</a> <span class="divider">></span></li>
				<li class="active">项目总结报告</li>
			</ul>
		</div>
		<div class="workplace">
			<div class="row-fluid">
				<div class="span12">
					<h4 style="text-align: center;">添加试题题目</h4>
					<form:form style="text-align: center;"
						action="${pageContext.request.contextPath}/studentpaper/oprationItems"
						method="post" modelAttribute="item_t">
						<c:if test="${item_t.id!=0}">
							<form:hidden path="id" />
							<input type="hidden" name="_method" value="PUT" />
						</c:if>
						<table>
							<tbody>
								<tr>
									<td>题目的题型:</td>
											<td><form:select path="questionid" onchange="fun1(this.value)">
											<form:option value="1" label="选择题" />
											<form:option value="2" selected = "selected" label="判断题" />
											<form:option value="3" label="问答题" />
										</form:select></td> 
								</tr>
								<tr>
									<td>题目的题头:</td>
									<td><form:textarea path="question" cssStyle="height:60px" /></td>
								</tr>
								<tr>
									<td>题目的答案:</td>
									<td><form:select path="answer">
										<form:option value="正确" label="正确"  />
										<form:option value="错误" label="错误" />
										</form:select>
									</td>
								</tr>
								<tr>
									<td>操作:</td>
									<td><input type="submit" value="添加试题" style="width:220px;"></td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
			</div>
			<div class="dr">
				<span></span>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function fun1(data)
	{
		if("1"==data){
			window.location.href='${pageContext.request.contextPath}/studentpaper/oprationItems';
			
		}
		if("2"==data){
			return false ;
		}
		if("3"==data){
			//TODO
		}
	}
	
	</script>
</body>
</html>