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
                Hi, 亲爱的${student.name}同学
            </div>
        </div>
        <!-- 管理员 -->
        <div class="admin">
            <div class="image">
                <img src="${pageContext.request.contextPath }/sources/img/users/aqvatarius.jpg" class="img-polaroid"/>                
            </div>
            <ul class="control">                
                <li><span class="icon-user"></span> <a href="showPersonal">${student.name }</a></li>
                <li><span class="icon-cog"></span> <a href="${pageContext.request.contextPath }/student/edit">设置</a></li>
                <li><span class="icon-share-alt"></span> <a href="${pageContext.request.contextPath }/login/logout">退出</a></li>
            </ul>
            <div class="info">
                  <span>Welcom back! Your last visit: 24.10.2012 in 19:55</span>
                </div>
        </div>
        
        <ul class="navigation"> 
            <li class="active">
                <a href="${pageContext.request.contextPath }/student/showPersonal">
                    <span class="isw-grid"></span><span class="text">个人中心</span>
                </a>
            </li>

            <li>
                <a href="${pageContext.request.contextPath }/student/showExam">
                    <span class="isw-list"></span><span class="text">我的考试</span>
                </a>               
            </li>                
        </ul>
        <div class="dr"><span></span></div>   
    </div>
    
    
    <div class="content">
        <div class="breadLine">
            <ul class="breadcrumb">
                <li><a>学生</a> <span class="divider">></span></li>                
                <li class="active">个人中心</li>
            </ul>   
        </div>
        <div class="workplace">
            
             <div class="row-fluid">                
                <div class="span3">
                    <div class="ushort clearfix">
                        <a href="#">${student.name }</a>
                        <a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/user_profile.jpg" class="img-polaroid"></a>
                        <input type="file" name="image"/>
                    </div>      
                    
                    <div class="block-fluid without-head">
                        <div class="toolbar nopadding-toolbar clearfix">
                            <h4>修改密码</h4>
                        </div>    
                            
                        <c:if test="${item == 2}">                                          
                        <div class="row-form clearfix">
                            <div class="span4">密码</div>
                            <div class="span8"><input type="password" value="s" name="password"/></div>
                        </div>
                        <div class="row-form clearfix">
                            <div class="span4">密码确认</div>
                            <div class="span8"><input  id="password" type="password" name="newPwd"/></div>
                        </div>                        
                        <div class="toolbar clear clearfix">
                            <div class="right">                                
                                <button type="button" id="password_modify" class="btn btn-small btn-warning"><span class="icon-ok icon-white"></span></button>                                
                            </div>
                        </div> 
                         </c:if>  
                         <c:if test="${item == 1}">                                                 
                   		 <div class=" alert-success">                
                		 <h4>修改密码成功!</h4>
               		         恭喜密码已经修改成功！
            			 </div>  
            			</c:if>   
                    </div>      
                
                </div>
                 <div class="span6">                                        
                <c:if test="${item == 1}">
                    <form:form action="${pageContext.request.contextPath }/student/modifyPersonal" method="POST" modelAttribute="student" >
                    <div class="block-fluid without-head">                        
                        <div class="toolbar clearfix">
                            <div class="left">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-small btn-success tip" title="Send mail"><span class="icon-envelope icon-white"></span></button>
                                    <button type="button" class="btn btn-small btn-info tip" title="User page"><span class="icon-info-sign icon-white"></span></button>                                    
                                </div>                                
                            </div>
                            <div class="right">
                                <div class="btn-group">
                                
                                    <button type="submit" class="btn btn-small btn-warning tip" title="Quick save"><span class="icon-ok icon-white"></span></button>
                                    <button type="button" class="btn btn-small btn-danger tip" title="Delete user"><span class="icon-remove icon-white"></span></button>
                                </div>
                            </div>
                        </div>                        
                        
                        <div class="row-form clearfix">
                            <div class="span3">姓名</div>
                            <div class="span9">
                            <form:input path="name" />
                           </div>
                        </div>

                        <div class="row-form clearfix">
                            <div class="span3">性别</div>
                            <div class="span9"> 
                             <form:input cssClass="input-mini"  path="agender"/>
       						</div>
                        </div>

                        <div class="row-form clearfix ">
                            <div class="span3">籍贯</div>
                            <div class="span9">
                            <form:input cssClass="input-mini" path="natives"/>
                            </div>
                        </div>                                                
                        
                        <div class="row-form clearfix">
                            <div class="span3">手机号码</div>
                            <div class="span9"><form:input path="phone"/></div>
                        </div>
                        <div class="row-form clearfix">
                            <div class="span3">生日</div>
                            <div class="span9"><form:input path="birthday"/></div>
                        </div>                        
                    </div>                    
                    </form:form>                  
                </c:if>
                 <c:if test="${item == 2}">
                 <div class=" alert-success">                
                		 <h4>修改个人信息成功!</h4>
               		          恭喜您个人信息已经修改成功！
            			 </div>  
                 </c:if>
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
        <script type="text/javascript">
        $(function(){
    		$("#password_modify").click(function(){
    		var mes = $("#password").val();
    		var url = "${pageContext.request.contextPath}/student/modifyPassword?newPwd="+mes;
    			location.href=url;
    		});
    	});
        </script>
</body>
</html>
