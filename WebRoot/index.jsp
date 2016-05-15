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
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap1.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	$(document).ready(function(){
	$('.carousel').carousel();
	});
	</script>

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
                <li><a href="index.jsp">主页 <span class="sr-only">(current)</span></a></li>
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

<!-- 下面是第二个模块 -->
<div class="container-fluid" style="width: 160%;padding-left: 1%">
			<div class="span">
				<div class="span12" style="background-color: #f1f1f1;width: 60%; padding-right: 5%" id="mains">
					<!-- this is 3rd layout -->
					<div class="span5">
					<marquee direction="left" onMouseOver=
	this.stop();;;;
onMouseOut=
	this.start();;
>
						<font><p> <img height="18" width="19"
									border="0" src="<%=request.getContextPath()%>/images/ph.png">
								膜法师图书馆联系电话：(021)88888888
								</p> </font>
					</marquee>

				
			<div id="myCarousel" class="carousel slide" style="width: 150%;padding-left: 1%">
							<div class="carousel-inner">
								<div class="item active">
									<img src="<%=request.getContextPath()%>/images/1.jpg" alt=""
										class="img-rounded">
									<div class="carousel-caption">
										<h4>
											图书馆远景
										</h4>
										<p>
											对方不想说话并向你扔了一座图书馆
										</p>
									</div>
								</div>
								<div class="item">
									<img src="<%=request.getContextPath()%>/images/2.jpg" alt=""
										class="img-rounded">
									<div class="carousel-caption">
										<h4>
											图书馆近景
										</h4>
										<p>
											暮色四合，灯火阑珊。
										</p>
									</div>
								</div>
								<div class="item">
									<img src="<%=request.getContextPath() %>/images/3.jpg" alt=""
										class="img-rounded">
									<div class="carousel-caption">
										<p>
											长桥长长长长到教学区<br>
											送回多少赖床doge的唏嘘
										</p>
									</div>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">&lsaquo;</a>
							<a class="right carousel-control" href="#myCarousel"
								data-slide="next">&rsaquo;</a>
						</div>
					</div>

					<div style="float:right;width:40%;padding-right: 25;padding-top: 5%">
					<p style="font-size:23">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img style="filter:gray" src="images/haha.jpg" width="100" height="60">  膜法师图书馆简介</p>
					<hr/>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					四川大学图书馆始建于1896 年，是我国西南地区藏书规模最大的大学图书馆；馆舍总面积63,100平方米；馆藏纸质文献达699.75万余册，并拥有丰富的电子文献资源。可提供阅览、外借、参考咨询、科技项目查新、文献传递、用户培训、馆际互借、声像视听、复印复制、打印扫描、缩微复制等多种信息服务，并为本科生、研究生开设“文献检索与利用课”。
					<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					膜法师图书馆是四川大学图书馆一个隐秘的分馆，我馆左右铭：天若有情天亦老，我为长者续一秒。+1s
					<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					入馆须知：1.入馆者须为长者续一秒。 2.流利背诵《葛底斯堡演说》(Gettysburg Address)者可获得借阅许可。 3.能同华莱士谈笑风生者可获得最高借阅权限。 4.满足上述条件并精通各种乐器者，可申请管理员资格。
					</p>
					</div>						
					</div>		
				</div>
			</div>
		</div>


<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/jquery1.js"></script>
<script src="js/bootstrap1.js"></script>

  </body>
</html>
<script>
	var fail = '<%=request.getParameter("rloginfail")%>';
	if(fail == 'yes'){
		alert("登录失败，请重试！");
	}
</script>