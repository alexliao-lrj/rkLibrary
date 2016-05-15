<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员入口</title>
    
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
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="about.jsp">关于</a></li>
                <li><a href="loginadmin.jsp">登录</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="width: 60%;padding-left: 35%">
<form class="form-horizontal" action="/dbLibrary/servlet/adminlogin" method="post">
  <div class="form-group">
    <label for="InputAdmin_ID">管理员ID</label>
    <input type="text" class="form-control" id="InputAdmin_ID" name="aid" placeholder="管理唯一身份标识">
  </div>
  <div class="form-group">
    <label for="InputAdmin_pwd">管理员密码</label>
    <input type="text" class="form-control" id="InputAdmin_pwd" name="pwd" placeholder="管理员密码">
  </div>

  <button type="submit" class="btn btn-default">上线！</button>
</form>
</div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>

  </body>
</html>

<script>
	var fail = '<%=request.getParameter("loginfail")%>';
	if(fail == 'yes'){
		alert("用户名/密码错误！");
	}
</script>
