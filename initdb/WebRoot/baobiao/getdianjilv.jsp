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

		<title>My JSP 'dianjilv.jsp' starting page</title>


		<link rel="stylesheet" type="text/css" href="./css/style.js">
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
					菜类
				</td>
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
				<td bgcolor="#FFFFFF">
					点菜次数
				</td>
				<td bgcolor="#FFFFFF">
					点击率
				</td>
			</tr>
			<tbody id="group_one">
				<%
    	IReportform ipf = new ReportformImp();
    	List<DishHitsbb> list = ipf.getDishHitsCatebbList();
    	for(int i =0;i<list.size();i++){
    		DishHitsbb dhb = list.get(i);
    		%>
				<tr>
					<%if(dhb.getDishName().equals(null)||dhb.getDishName().isEmpty()){
    		%>
					<td><%=dhb.getCateName() %></td>
					<!--  <td colspan="5" align = "right"><%=dhb.getInPicNum() %></td>-->
					<%
				}  else{
				%>
					<td bgcolor="#FFFFFF"></td>
					<td bgcolor="#FFFFFF"><%=dhb.getDishName() %></td>
					<td bgcolor="#FFFFFF"><%=dhb.getPrice() %></td>
					<td bgcolor="#FFFFFF"><%=dhb.getSpec() %></td>
					<td bgcolor="#FFFFFF" align="right"><%=dhb.getInPicNum() %></td>
					<td bgcolor="#FFFFFF" align="right"><%=dhb.getOrederNum() %></td>
					<td bgcolor="#FFFFFF" align="right"><%=dhb.getOrederNum()/dhb.getInPicNum()*100 +"%"%></td>

					<%
				}  			
    		 %>
				</tr>
				<%
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
