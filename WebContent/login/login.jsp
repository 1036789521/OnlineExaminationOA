<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/style.css" tppabs="${pageContext.request.contextPath}/sources/css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="${pageContext.request.contextPath}/sources/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/sources/js/verificationNumbers.js" tppabs="${pageContext.request.contextPath}/sources/js/verificationNumbers.js"></script>
<script src="${pageContext.request.contextPath}/sources/js/Particleground.js" tppabs="${pageContext.request.contextPath}/sources/js/Particleground.js"></script>
<script  type="text/javascript">
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //注册
  $(".register").click(function(){
	  location.href="${pageContext.request.contextPath}/login/register.jsp"/*tpa=http://***index.html*/;
	  });
  //登录
    function checkUser(){
    	 var validate = validate();
    	//返回false,提示验证码错误，不提交表单
      	  if(validate == false){
     		  return false ; 
     	  }
     	  //如果返回为true,提交表单
    	  document.getElementById("formid").submit();
    	}

});
</script>
<title>登录</title>
</head>
<body>

  <!--   function validateForm(){  
    if(document.reply.title.value == ""){ //通过form名来获取form  
        alert("please input the title!");  
        document.reply.title.focus();  
        return false;  
    }     
    if(document.forms[0].cont.value == ""){ //通过forms数组获取form  
        alert("please input the content!");  
        document.reply.cont.focus();  
        return false;  
    }  
    return true;  
  }  
<form name="reply"  method="post" onsubmit="return validateForm( );">  
        <input type="text" name="title"  size="80" /><br />  
        <textarea name="cont" cols="80" rows="12"></textarea><br />  
        <input type="submit" value="提交" >  
</form>  -->


 <form id="formid" action="${pageContext.request.contextPath}/login/checked" method="POST" onsubmit = "return checkUser();" >
<dl class="admin_login">
 <dt>
  <strong>在线考试管理系统</strong>
  <em>Management System</em>
  <em class="warning" style="color:#e6302c ">${flag}</em>
 </dt>
 <dd class="user_icon">
  <input type="text" name="username" placeholder="账号" class="login_txtbx"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" name="password" placeholder="密码" class="login_txtbx"/>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd>
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn submit"   />
 </dd>
 <dd>
   <input  type="button" value="注册" class="submit_btn register"/> 
 </dd>
</dl>
</form>
</body>
</html>