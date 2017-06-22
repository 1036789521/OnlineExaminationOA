<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <div class="menu">                
        
        <div class="breadLine">            
            <div class="arrow"></div>
            <div class="adminControl active">
                Hi, 亲爱的${sessionScope.student.name}同学
            </div>
        </div>
        <!-- 管理员 -->
        <div class="admin">
            <div class="image">
                <img src="${pageContext.request.contextPath }/sources/img/users/aqvatarius.jpg" class="img-polaroid"/>                
            </div>
            <ul class="control">                
                <li><span class="icon-user"></span> <a href="${pageContext.request.contextPath }/login">${student.name }</a></li>
                <li><span class="icon-cog"></span> <a href="${pageContext.request.contextPath }/student/edit">设置</a></li>
                <li><span class="icon-share-alt"></span> <a href="${pageContext.request.contextPath }/logout">退出</a></li>
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