<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	DownPic dp = new DownPicImp();
	String name = "";
	name = new String(request.getParameter("name").getBytes("GBK"));
	dp.downPic(name);
	request.getRequestDispatcher("img/" + name).forward(request,
			response);
	out.clear();
	out = pageContext.pushBody();
%>
<%@ page language="java" import="java.util.*,java.net.URLDecoder"
	pageEncoding="UTF-8"%>
<%@page import="com.groupshop.dao.DownPic"%>
<%@page import="com.groupshop.daoImpl.DownPicImp"%>
