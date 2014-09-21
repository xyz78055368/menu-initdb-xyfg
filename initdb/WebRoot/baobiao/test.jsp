<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.11 Transitional//EN">
<html>
	<base href="<%=basePath%>">

	<title>幻彩飞扬报表系统</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<head>
		<style type="text/css">
div {
	float: left;
	margin: 2px;
	width: 222px;
	height: 38px;
}

#Layer1 {
	position: absolute;
	width: 863px;
	height: 416px;
	z-index: 1;
	left: 240px;
	top: 15px;
}

body {
	background-image: url(images/bj.jpg);
	background-repeat: no-repeat;
	width: 800px;
	scroll: no； height :       600px;
	height: 600px;
}
div1{

}
</style>

<script language="JavaScript" src="./css/test.js"
			type="text/javascript"></script>
	</head>
	<!--  overflow:scroll;overflow-y:hidden;-->
	<body>
			
		<form name="form1">
			<div>
			<div>
			
			 <font size="5">报表查询系统</font>
			</div>
				<div id="demo1"
					style="background-image: url(images/h02.jpg); width: 222px;"
					onclick="javascript:changeBg('dishhits')";
>
					<font style="top:15px" >菜品点击次数</font>
				</div>
				<div id="demo2"
					style="background-image: url(images/h01.jpg); width: 222px;"
					onclick="changeBg('dishcatehits')";
>
					菜类点击次数
				</div>
				<div id="demo3"
					style="background-image: url(images/h01.jpg); width: 222px;"
					onclick="changeBg('dianjilv')";
;
>
					菜品点击率
				</div>
				<div id="demo4"
					style="background-image: url(images/h01.jpg); width: 222px;"
					onclick="shuaxin()";>
					刷新
				</div>
			</div>
		</form>
		<div id="Layer1">
			<iframe id="xyz" src="baobiao/dishhits.jsp" width="80%" height="650px"></iframe>
		</div>
	</body>
</html>
