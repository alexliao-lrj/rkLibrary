<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Reader" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询图书</title>
    
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
   <%
     String reader_name = null;
     Reader reader = (Reader)session.getAttribute("reader");
     if(reader!=null){
        reader_name = reader.getname();
       }
    %>
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
      <a class="navbar-brand" href="reader_main.jsp">四川大学图书馆</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="reader_main.jsp">主页 <span class="sr-only">(current)</span></a></li>
        <li><a href="search_book.jsp">查询图书</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更多功能 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="ReaderUpd.jsp">修改个人信息</a></li>
            <li><a href="#">To be online...</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="javascript:alert('汪汪汪！管理员不想跟你说话并向你扔了一只旋转狗：）')">联系管理员</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">To be online...</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="about.jsp">关于</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=reader_name %><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="reader_info.jsp">查看个人信息</a></li>
            <li><a href="reader_borrowed.jsp">查看已借阅书籍</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="index.jsp">登出</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div style="width: 60%;padding-left: 35%">
<form method="post" action="/dbLibrary/servlet/book_searchaction">
  <div class="form-group">
    <label for="InputBook_ID">书ID</label>
    <input type="text" class="form-control" id="InputBook_ID" name="Book_ID" placeholder="书ID">
  </div>
  <div class="form-group">
    <label for="InputBook_name">书名</label>
    <input type="text" class="form-control" id="InputBook_name" name="Book_name" placeholder="书名">
  </div>
  <div class="form-group">
    <label for="InputAutor">作者</label>
    <input type="text" class="form-control" id="InputAuthor" name="Author" placeholder="作者">
  </div>
  <div class="form-group">
    <label for="InputPublisher">出版社</label>
    <input type="text" class="form-control" id="InputPublisher" name="Publisher" placeholder="出版社">
  </div>
  <p>*任意输入其中一种即可查询</p>

  <button type="submit" class="btn btn-default">查询</button>
</form>
</div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
