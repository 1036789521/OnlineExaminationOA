<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                Hi, 亲爱的${sessionScope.student.name}同学
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
                 <div class="workplace">
            
            <div class="row-fluid">
                
                <div class="span6">                    
                    
                    <div class="block-fluid ucard clearfix">
                        
                            <div class="left">
                                <h4>Aqvatarius</h4>
                                <div class="image">
                                    <a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/user_profile.jpg" class="img-polaroid"></a>                            
                                </div>
                                <ul class="control">                
                                    <li><span class="icon-pencil"></span> <a href="${pageContext.request.contextPath }/student/edit">修改</a></li>
                                    <li><span class="icon-user"></span> <a href="ui.html">状态</a></li>
                                    <li><span class="icon-info-sign"></span> <a href="users.html">信息</a></li>
                                    <li><span class="icon-envelope"></span> <a href="messages.html">发送短信</a></li>
                                </ul>                               
                            </div>
                            <div class="info">                                                                
                                <ul class="rows">
                                    <li class="heading">学生个人信息</li>
                                    <li>
                                        <div class="title">姓名:</div>
                                        <div class="text">${sessionScope.student.name }</div>
                                    </li>
                                    <li>
                                        <div class="title">性别:</div>
                                        <div class="text">${sessionScope.student.agender }</div>
                                    </li>
                                    <li>
                                        <div class="title">电话:</div>
                                        <div class="text">${sessionScope.student.phone }</div>
                                    </li>
                                    <li>
                                        <div class="title">生日:</div>
                                        <div class="text">${sessionScope.student.birthday }</div>
                                    </li>
                                    <li>
                                        <div class="title">班级:</div>
                                        <div class="text">${sessionScope.student.classes.className }</div>
                                    </li>
                                    <li>
                                        <div class="title">入班时间:</div>
                                        <div class="text">${sessionScope.student.enter_time }</div>
                                    </li>
                                    <li>
                                        <div class="title">毕业学校:</div>
                                        <div class="text">${sessionScope.student.school }</div>
                                    </li>                                     
                                </ul>                                                      
                            </div>                        
                            
                    </div>
                </div>                                
                 
                <div class="span6">        
                    <div class="head clearfix">
                        <div class="isw-favorite"></div>
                        <h1>最近活动</h1>
                    </div>                
                    <div class="block-fluid scrollBox withList">
                        <div class="scroll" style="height: 200px;">
                            
                            <ul class="list">
                                <li><span class="date"><b>Nov 7</b> 12:45</span> Aqvatarius commented on <a href="#">Some news name</a></li>
                                <li><span class="date"><b>Nov 7</b> 12:32</span> Aqvatarius uploaded <a href="#">.zip file</a></li>
                                <li><span class="date"><b>Nov 7</b> 12:25</span> Aqvatarius logged in</li>
                                <li><span class="date"><b>Nov 6</b> 20:21</span> Aqvatarius commented on <a href="#">Class aptent taciti</a></li>
                                <li><span class="date"><b>Nov 6</b> 20:15</span> Aqvatarius commented on <a href="#">Integer dignissim consequat</a></li>
                                <li><span class="date"><b>Nov 6</b> 19:33</span> Aqvatarius logged in</li>
                                <li><span class="date"><b>Nov 5</b> 18:27</span> Aqvatarius added <a href="#">image</a></li>
                                <li><span class="date"><b>Nov 5</b> 12:45</span> Aqvatarius commented on <a href="#">Some news name</a></li>
                                <li><span class="date"><b>Nov 5</b> 12:32</span> Aqvatarius uploaded <a href="#">.zip file</a></li>                                
                                <li><span class="date"><b>Nov 5</b> 20:21</span> Aqvatarius commented on <a href="#">Class aptent taciti</a></li>
                                <li><span class="date"><b>Nov 5</b> 12:25</span> Aqvatarius logged in</li>
                                <li><span class="date"><b>Nov 3</b> 20:15</span> Aqvatarius commented on <a href="#">Integer dignissim consequat</a></li>                                
                                <li><span class="date"><b>Nov 3</b> 18:27</span> Aqvatarius added <a href="#">image</a></li>                                
                                <li><span class="date"><b>Nov 3</b> 19:33</span> Aqvatarius logged in</li>
                                <li><span class="date"><b>Nov 2</b> 12:45</span> Aqvatarius commented on <a href="#">Some news name</a></li>
                                <li><span class="date"><b>Nov 2</b> 12:32</span> Aqvatarius uploaded <a href="#">.zip file</a></li>
                                <li><span class="date"><b>Nov 2</b> 12:25</span> Aqvatarius logged in</li>
                                <li><span class="date"><b>Nov 1</b> 20:21</span> Aqvatarius commented on <a href="#">Class aptent taciti</a></li>
                                <li><span class="date"><b>Nov 1</b> 20:15</span> Aqvatarius commented on <a href="#">Integer dignissim consequat</a></li>                                
                            </ul>    
                            
                        </div>                                                                                                                                
                    </div>
                    
                </div>                 
                
            </div>            
            
            <div class="row-fluid">

                <div class="span6">
                    <div class="head clearfix">
                        <div class="isw-picture"></div>
                        <h1>学生相册</h1>                       
                    </div>
                    <div class="block gallery clearfix">
                        
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>
                        <a class="fancybox" rel="group" href="${pageContext.request.contextPath }/sources/img/example_full.jpg"><img src="${pageContext.request.contextPath }/sources/img/example_mini.jpg" class="img-polaroid"/></a>                        
                        
                    </div>
                </div>

                <div class="span6">
                    <div class="head clearfix">
                        <div class="isw-users"></div>
                        <h1>朋友圈</h1>
                    </div>
                    
                    <div class="block-fluid users">                                                

                            <div class="item clearfix">
                                <div class="image"><a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/olga_s.jpg" width="32"/></a></div>
                                <div class="info">
                                    <a href="#" class="name">Olga</a>                                
                                    <span>online</span>
                                    <div class="controls">                    
                                        <a href="#" class="icon-pencil"></a> 
                                        <a href="#" class="icon-envelope"></a>                                         
                                        <a href="#" class="icon-remove"></a>
                                    </div>                                      
                                </div>                                
                            </div>                        

                            <div class="item clearfix">
                                <div class="image"><a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/alexey_s.jpg" width="32"/></a></div>
                                <div class="info">
                                    <a href="#" class="name">Alexey</a>  
                                    <span>online</span>
                                    <div class="controls">                    
                                        <a href="#" class="icon-pencil"></a> 
                                        <a href="#" class="icon-envelope"></a>                                         
                                        <a href="#" class="icon-remove"></a>
                                    </div>                                                                
                                </div>
                            </div>                              
                        
                            <div class="item clearfix">
                                <div class="image"><a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/dmitry_s.jpg" width="32"/></a></div>
                                <div class="info">
                                    <a href="#" class="name">Dmitry</a>                                    
                                    <span>online</span>
                                    <div class="controls">                    
                                        <a href="#" class="icon-pencil"></a> 
                                        <a href="#" class="icon-envelope"></a>                                         
                                        <a href="#" class="icon-remove"></a>
                                    </div>                                                                
                                </div>
                            </div>                         

                            <div class="item clearfix">
                                <div class="image"><a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/helen_s.jpg" width="32"/></a></div>
                                <div class="info">
                                    <a href="#" class="name">Helen</a>                                                                        
                                    <div class="controls">                    
                                        <a href="#" class="icon-pencil"></a> 
                                        <a href="#" class="icon-envelope"></a>                                         
                                        <a href="#" class="icon-remove"></a>
                                    </div>                                                                
                                </div>
                            </div>                                  

                            <div class="item clearfix">
                                <div class="image"><a href="#"><img src="${pageContext.request.contextPath }/sources/img/users/alexander_s.jpg" width="32"/></a></div>
                                <div class="info">
                                    <a href="#" class="name">Alexander</a>                                                                        
                                    <div class="controls">                    
                                        <a href="#" class="icon-pencil"></a> 
                                        <a href="#" class="icon-envelope"></a>                                         
                                        <a href="#" class="icon-remove"></a>
                                    </div>                                                                
                                </div>
                            </div>                                                          
                        
                    </div>                
                    
                </div>                
                
            </div>            
            
            <div class="dr"><span></span></div>           
            
            
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
