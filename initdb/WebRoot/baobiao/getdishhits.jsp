<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.groupshop.dao.IReportform"%>
<%@page import="com.groupshop.daoImpl.ReportformImp"%>
<%@page import="com.groupshop.entity.DishHitsbb"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'getdishhits.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="styles.css">
		<style type="text/css">
#Layer1 {
	position: absolute;
	width: 450px;
	height: 60x;
	z-index: 1;
	left: 230px;
	top: 610px;
}
</style>
		<script language="JavaScript" src="./css/fenye.js"
			type="text/javascript"></script>
		<script type="text/javascript">
	window.onload = function() {
		page = new Page(25, 'table1', 'group_one');
	};
</script>
	</head>

	<body>
		<table id="table1" width="100%" border="0" cellpadding="1"
			cellspacing="1" bgcolor="#00FFCC">
			<tr>
				<td bgcolor="#FFFFFF">
					菜名
				</td>
				<td bgcolor="#FFFFFF">
					单价
				</td>
				<td bgcolor="#FFFFFF">
					单位
				</td>
				<td bgcolor="#FFFFFF">
					点击次数
				</td>
			</tr>
			<tbody id="group_one">

				<%
    	IReportform ipf = new ReportformImp();
    	
    	List<DishHitsbb> list = ipf.getDishHitsbbList(); 
    	for(int i =0;i<list.size();i++){
    		DishHitsbb dhb = list.get(i);
    		if(i%2!=1){
    		%>
				<tr>
					<td bgcolor="#FFFddF"><%=dhb.getDishName() %></td>
					<td bgcolor="#FFFddF"><%=dhb.getPrice() %></td>
					<td bgcolor="#FFFddF"><%=dhb.getSpec() %></td>
					<td bgcolor="#FFFddF"><%=dhb.getInPicNum() %></td>
				</tr>

				<%
    		}else{
    		%>
				<tr>
					<td bgcolor="#FFFFFF"><%=dhb.getDishName() %></td>
					<td bgcolor="#FFFFFF"><%=dhb.getPrice() %></td>
					<td bgcolor="#FFFFFF"><%=dhb.getSpec() %></td>
					<td bgcolor="#FFFFFF"><%=dhb.getInPicNum() %></td>
				</tr>
				<%
    		}
    	}
    	 %>
			</tbody>
		</table>
		<div id="Layer1">
		<input type="button" value="上一页" onclick=page.prePage();;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="下一页" onclick=page.nextPage();;>
		</div>
	</body>
</html>
