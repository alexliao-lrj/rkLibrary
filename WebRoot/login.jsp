<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">


  </head>
  
  <body>
<div style="height:643px;background-image: url('images/login_bkg.jpg');background-repeat: no-repeat;background-size:100% 100%">
<div style="width: 60%;padding-left: 30%;padding-top: 15%">
  <h2>四川大学图书馆</h2>
<form class="form-horizontal" action="/dbLibrary/servlet/loginaction" method="post">
  <div class="form-group">
    <label for="inputID3" class="col-sm-2 control-label">学号</label>
    <div class="col-sm-10">
    <input type="text" class="form-control" id="inputID3" name="ID" placeholder="学号">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
    <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="密码">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox">  记住密码
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登陆</button>
    </div>
  </div>
</form>
</div>
</div>
    
    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
  </body>
</html>



