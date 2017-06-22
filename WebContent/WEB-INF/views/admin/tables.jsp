<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<jsp:include page="/WEB-INF/commons/css.jsp"></jsp:include>
<jsp:include page="/WEB-INF/commons/js.jsp"></jsp:include>
<title></title>

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
				<li><span class="icon-share-alt"></span> <a href="${pageContext.request.contextPath }/login/login.jsp">退出</a></li>
			</ul>
		</div>

		<ul class="navigation">
			<!-- 项目总结报告 -->
			<li ><a href="test"> <span class="isw-grid"></span><span
					class="text">班级管理</span>
			</a></li>

			<!-- 项目情况进展表 -->
			<li><a href="ui"> <span class="isw-list"></span><span
					class="text">班主任管理</span>
			</a></li>
			<li><a href="forms"> <span class="isw-archive"></span><span
					class="text">学生管理</span>
			</a></li>
			<li><a href="messages"> <span class="isw-chat"></span><span
					class="text">讲师管理</span>
			</a></li>
			<li><a href="statistic"> <span class="isw-graph"></span><span
					class="text">试题管理</span>
			</a></li>
			<li class="active"><a href="tables"> <span class="isw-text_document"></span><span
					class="text">试卷管理</span>
			</a></li>
			<li><a href="user"> <span class="isw-documents"></span><span
					class="text">考试管理</span>
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
				<li class="active">试卷管理</li>
			</ul>
		</div>

		<div class="workplace">

			<div class="row-fluid">
				<div class="span12">
					<div class="head clearfix">
					 <input type="submit"  id="batchDel" class="btn btn-default" value="批量删除">
						<form action="#" style="float:right " >
						<input type="text" placeholder="请输入试卷名称" name="paperName">
						<input type="submit"  class="btn btn-default" value="搜索">&nbsp
						<input type="button" id="add" class="btn btn-default"  value="添加">
					</form> 
					</div>
					<div class="block-fluid">
						<table cellpadding="0" cellspacing="0" width="100%" class="table">
							<thead>
								<tr>
									<th ><input id="checkedAll" name="checkedAll" type="checkbox" /></th>
									<th width="20%">名称</th>
									<th width="20%">类型</th>
									<th width="20%">试题数量</th>
									<th width="20%">创建时间</th>
									<th width="20%">操作</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach var="paper" items="${paperList }" >
								<tr>
										<td> <input  name="box" type="checkbox"/>
										     <span class="id"  hidden="true" >${paper.paper_id}</span>
										</td>
										<td>${paper.papername}</td> 
										<td>${paper.paperType}</td> 
										<td>${paper.count}</td> 
										<td>${paper.createDate}</td> 
										<th>
											 <div class="btn-group">                                        
											   <button data-toggle="dropdown" class="btn dropdown-toggle">请选择 <span class="caret"></span></button>
                               		           <ul class="dropdown-menu">
                                               <li><a  href="#">修改</a></li>
                                               <li><a href="${pageContext.request.contextPath}/studentpaper/delpaper?paperId=${paper.paper_id}">删除</a></li>
                                               </ul>
                                   			 </div>
										</th> 
								</tr>
									</c:forEach> 
							</tbody>
						</table>
					</div>
					<div class="dr">
						<span></span>
					</div>

					

				</div>
			</div>
			<div class="dr">
				<span></span>
			</div>
		</div>
	</div>
		<script type="text/javascript">
		   $(function(){
			   <!--增加-->
	    		$("#add").click(function(){
	    		var url = "${pageContext.request.contextPath}/studentpaper/addpaper";
	    			location.href=url;
	    		});
			   <!--全选或全部删除-->
			     		 $("#checkedAll").click(function () {
			     	            if ($(this).attr("checked")) { // 全选 
			     	            	//alert("全选");
			     	                $("input[name='box']").each(function () {
			     	                    $(this).attr("checked", "checked");
			     	                    $(this).parent("span").attr("class","checked");
			     	                });
			     	            }
			     	            else { // 取消全选 
			     	            	//alert("取消全选");
			     	                $("input[name='box']").each(function () {
			     	                    $(this).removeAttr("checked");
			     	                    $(this).parent("span").removeAttr("class");
			     	                });
			     	            }
			     	        });
			     	<!--批量删除按钮--> 
			     	$("#batchDel").click(function(){
			     		 // console.log("按钮点击");
			     		var checklist = new Array() ;
			     		 //遍历所有checked选框，选出被选中的对应Id
			     		  $("input[name='box']").each(function () {
			     			  if( $(this).attr("checked")==null||$(this).attr("checked")==""){
			     				 //这里就不会写啦 
			     			  }
			               });
			     		});
			 	});
		</script>
</body>
</html>
