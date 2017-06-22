<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>        
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
   <jsp:include page="/WEB-INF/commons/css.jsp"></jsp:include>
   <jsp:include page="/WEB-INF/commons/js.jsp"></jsp:include>
   <style type="text/css">
   .block-fluid{width:700px}
   </style>
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
            <div class="adminControl active">
                Hi, 尊敬的管理员
            </div>
        </div>
        <!-- 管理员 -->
        <div class="admin">
            <div class="image">
                <img src="${pageContext.request.contextPath }/sources/img/users/aqvatarius.jpg" class="img-polaroid"/>                
            </div>
            <ul class="control">                
                <li><span class="icon-share-alt"></span> <a href="login.html">退出</a></li>
            </ul>
        </div>
        
        <ul class="navigation"> 
            <li class="active">
                <a href="test">
                    <span class="isw-grid"></span><span class="text">班级管理</span>
                </a>
            </li>
            <li>
                <a href="ui">
                    <span class="isw-list"></span><span class="text">班主任管理</span>
                </a>               
            </li>          
            <li>
                <a href="forms">
                    <span class="isw-archive"></span><span class="text">学生管理</span>                 
                </a>
            </li>                        
            <li>
                <a href="messages">
                    <span class="isw-chat"></span><span class="text">讲师管理</span>
                </a>
            </li>                                    
            <li>
                <a href="statistic">
                    <span class="isw-graph"></span><span class="text">试题管理</span>
                </a>
            </li>   
            <li>
                <a href="tables">
                    <span class="isw-text_document"></span><span class="text">试卷管理</span>
                </a>                
            </li>   
            <li>
                <a href="user">
                    <span class="isw-documents"></span><span class="text">考试管理</span>
                </a>
            </li>            
        </ul>
        <div class="dr"><span></span></div>   
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
					<h4 style="text-align: center">班级信息维护</h4>
					<form:form 
						action="addclasses"
						method="post" modelAttribute="classes">
						
							<form:hidden path="id" />
							
						<table>
							<tbody>
								<tr>
									<td>班级名称:</td>
									<td><form:input path="className" /></td>
								</tr>
								<tr>
									<td>班级类型:</td>
									<td><form:input path="classType" /></td>
								</tr>
								<tr>
									<td>班主任:</td>
									<td><form:input path="adviserName" /></td>
								</tr>
								<tr>
									<td>讲师:</td>
									<td><form:input path="trainerName" /></td>
								</tr>
								<tr>
									<td>开班时间:</td>
									<td><form:input path="classBeginDate" /></td>
								</tr>
								<tr>
									<td>学习时长:</td>
									<td><form:input path="classDuration" /></td>
								</tr>
								<tr>
									<td>状态:</td>
									<td><form:input path="classStatus" /></td>
								</tr>
								<tr>
									<td>操作:</td>
									<td><input type="submit" value="提交" style="width: 220px;"></td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
			</div>
        </div>
    </div>
    <script type="text/javascript">
            function Download() {
                console.log($("tbody input:checked").length);
                var selNumber= $("tbody input:checked").length;

                if (selNumber!=1) {
                    var array = [];
                        $("tbody input:checked").each(function(){
                            var webs = $(this).parents("td").siblings("th#address").text();
                            console.log(webs);
                            array.push(webs);
                        });
                    console.log(array);
                    OpenWeb(array);

                }else{
                    var website = $("tbody input:checked").parents("td").siblings("th#address").text();
                    console.log(website);
                    window.open(website);
                }
                
            }

            function OpenWeb (array1){
                var a = 0;
                var time = setInterval(function () {
                    
                    if (a ==array1.length) {
                        clearInterval(time);
                    }else{
                        window.open(array1[a]);
                    }
                    a++;

                },1000);


            }
        </script>
</body>
</html>
