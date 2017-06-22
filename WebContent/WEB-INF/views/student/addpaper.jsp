<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li class="active"><a href="test"> <span class="isw-grid"></span><span
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
			<li><a href="${pageContext.request.contextPath}/admin/statistic">
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
					<h4 style="text-align: center;">添加试卷</h4>

					<p style="color: red; font-size: 18px;">注意：总分加起来一百分</p>

					<form action="addpaperItem" method="post">
						<input type="hidden" name="count" value="100"><br>
						<table>
							<tbody>
								<tr>
									<td>试卷的名字:</td>
									<td><input type="text" name="papername"></td>
								</tr>
								<tr>
									<td>试卷类型:</td>
									<td><select name="paperType" >
										<option value="">请选择</option>
										<option value="Java">Java</option>
										<option value="PHP">PHP</option>
										<option value="IOS">IOS</option>
										<option value="Python">Python</option>
										<option value="others">其他</option>
									</td>
								</tr>
								<tr>
									<td>选择题数目:</td>
									<td><input type="text" name="xuanzeti"></td>
								</tr>
								<tr>
									<td>每个选择题的分数:</td>
									<td><input type="text" name="xuanzeti_score"></td>
								</tr>
								<tr>
									<td>判断题数目:</td>
									<td><input type="text" name="panduanti"></td>
								</tr>
								<tr>
									<td>每个判断题的分数:</td>
									<td><input type="text" name="panduanti_score"></td>
								</tr>
								<tr>
									<td>操作:</td>
									<td><input type="submit" value="添加" style="width: 220px;"></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div class="dr">
				<span></span>
			</div>
		</div>
	</div>
</body>
</html>