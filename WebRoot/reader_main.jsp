<%@ page language="java" import="java.util.* " pageEncoding="UTF-8" %>
<%@ page import="entity.Reader" %>
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

  </head>
  
 <body bgcolor="#faebd7">
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
            <li><a href="javascript:alert('管理员懒得走过来并要求你去前台找他：）')">联系管理员</a></li>
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

<div style="overflow:auto;height: 500px" >
  <div style="float:left;padding-left: 100px;padding-top:40px;width:50%">
    <img src="images/1.jpg" class="img-thumbnail">
  </div>
  <div style="float:left;width:30%;padding-left: 50px;padding-top: 150px">
    <p class="text-justify">四川大学图书馆始建于1896 年，是我国西南地区藏书规模最大的大学图书馆；馆舍总面积63,100平方米；馆藏纸质文献达699.75万余册，并拥有丰富的电子文献资源。可提供阅览、外借、参考咨询、科技项目查新、文献传递、用户培训、馆际互借、声像视听、复印复制、打印扫描、缩微复制等多种信息服务，并为本科生、研究生开设“文献检索与利用课”。</p>
  </div>
</div>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
