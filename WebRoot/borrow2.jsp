<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Book" %>
<%@ page import="entity.Admin" %>
<%@ page import="dao.BorrowDao" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>借阅确认</title>
    
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
     String adminname = null;
     Admin admin = (Admin)session.getAttribute("admin");
     if(admin!=null){
        	adminname = admin.getname();
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
            <a class="navbar-brand" href="adminmain.jsp">四川大学图书馆</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="adminmain.jsp">主页 <span class="sr-only">(current)</span></a></li>
                <li><a href="search_book.jsp">查询图书</a></li>
                <li><a href="borrow.jsp">借阅图书</a></li>
                <li><a href="return.jsp">归还图书</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">图书信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="BookAdd.jsp">新书上架</a></li>
                        <li><a href="BookDel.jsp">旧书下架</a></li>
                        <li><a href="BookUpd.jsp">信息更新</a></li>
                        
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">读者信息 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ReaderQuery.jsp">读者查询</a></li>
                        <li><a href="ReaderRegister.jsp">读者注册</a></li>
                        <li><a href="ReaderUpd.jsp">信息更新</a></li>
                        <li><a href="ReaderDel.jsp">删除用户</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="about.jsp">关于</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=adminname %><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="admininfo.jsp">个人信息</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="index.jsp">退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div style="width: 90%;padding-left: 10%;padding-top: 5%;overflow: auto">
<table class="table">
  <thead>
  <tr>
    <th>当前图书信息</th>
    <th>图书ID</th>
    <th>图书名称</th>
    <th>作者</th>
    <th>出版社</th>
    <th>状态</th>
  </tr>
  </thead>
 <tbody>
 <%
 	Book b = (Book)request.getSession().getAttribute("book"); 
 	int count=0;
 	BorrowDao dao = new BorrowDao();
 	String isAva = "";
 	if(dao.isAvailable(b.getbid())){
 		isAva="在架上";
 	}else{
 		isAva="已借出";
 	}
 	if(b!=null){
 		count=1;
 	}
 	out.print("<tr>");
 	out.print("<th>"+count+"</th>");
 	out.print("<th>"+b.getbid()+"</th>");
 	out.print("<th>"+b.getname()+"</th>");
 	out.print("<th>"+b.getauthor()+"</th>");
 	out.print("<th>"+b.getpublisher()+"</th>");
 	out.print("<th>"+isAva+"</th>");
 	out.print("</tr>");
  %>
 </tbody>
 <tr></tr>
</table>
</div>

<div style="width: 35%;padding-left: 11%">
    <form class="form-horizontal" action="/dbLibrary/servlet/borrowbook" method="post">
    <div class="form-group">
            <label for="InputReader_ID">图书ID</label>
            <input type="text" class="form-control" id="InputReader_ID" placeholder="读者ID">
        </div>
        <div class="form-group">
            <label for="InputReader_ID">读者ID</label>
            <input type="text" class="form-control" id="InputReader_ID" name="ReaderID" placeholder="读者ID">
        </div>
        <button type="submit" class="btn btn-default">确认借阅</button>
    </form>
</div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
  </body>
</html>
