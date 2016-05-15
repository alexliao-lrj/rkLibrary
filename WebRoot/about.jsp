<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <nav class="navbar navbar-default navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">四川大学图书馆</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">主页 <span class="sr-only">(current)</span></a></li>
                <li><a href="login.jsp">读者入口</a></li>
                <li><a href="loginadmin.jsp">管理员入口</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="about.jsp">关于</a></li>
                <li><a href="javascript:alert('对方不想跟你说话并向你扔了一只狗：）')">联系我们</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="width: 60%;padding-left: 10%;padding-top: 5%;overflow: auto">
<% 
		out.println("你问我这个图书馆吼不吼，资词不资词，我是资词的，这个图书馆是坠吼的！"+"<br>");
		out.println("你们啊，不要想整天搞个大新闻！"+"<br>");
		out.println("我这个图书馆，已经是身经百战了！"+"<br>");
		out.println("你们啊，还是too simple啊，sometimes naive！"+"<br>");
	for(int i=0; i<10; i++){
		out.println("+1 s"+"<br>");
	}

%>
</div>

<div align="right"><img src="images/haha.jpg"/></div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

  </body>
</html>