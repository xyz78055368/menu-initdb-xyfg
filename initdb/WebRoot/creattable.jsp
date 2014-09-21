<%
	int i = Integer.parseInt(request.getParameter("i"));
	CreatTableDao ctd = new CreatTableDaoImp();
	String CSql = ctd.getCreatTableSql(i);
	System.out.println(i+"*"+ CSql);
	out.println(CSql);
%>
<%@ page language="java" import="java.util.*,com.groupshop.dao.CreatTableDao,com.groupshop.daoImpl.CreatTableDaoImp" pageEncoding="utf-8"%>
